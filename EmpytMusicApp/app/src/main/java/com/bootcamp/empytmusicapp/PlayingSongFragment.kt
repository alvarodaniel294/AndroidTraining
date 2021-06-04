package com.bootcamp.empytmusicapp

import android.app.Service
import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.core.content.ContextCompat.startForegroundService
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bootcamp.empytmusicapp.databinding.FragmentPlayingSongBinding
import com.bootcamp.empytmusicapp.services.MusicService
import com.bootcamp.empytmusicapp.viewModels.SongViewModel


class PlayingSongFragment : Fragment() {
    private val viewModel: SongViewModel by activityViewModels()
    private lateinit var binding: FragmentPlayingSongBinding
    private lateinit var volumenSeekBar: SeekBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayingSongBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.song.observe(viewLifecycleOwner, {
            binding.songName.text = it.name
            binding.songAuthor.text = it.author
        })
        binding.songPlayingStatus.setOnClickListener {
            stopSong()
        }
        val audioManager = getActivity()?.getSystemService(AUDIO_SERVICE) as AudioManager
        val maxVolumen = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val currentVolumen = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        volumenSeekBar =  binding.volumenSeekbar
        volumenSeekBar.max = maxVolumen
        volumenSeekBar.progress = currentVolumen
        volumenSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }
    fun stopSong() {
        val intent = Intent(requireContext(), MusicService::class.java)
        intent.putExtra(MusicService.STOP_FLAG, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(requireContext(), intent)
        }
    }
}