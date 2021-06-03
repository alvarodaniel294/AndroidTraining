package com.bootcamp.empytmusicapp

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startForegroundService
import androidx.fragment.app.activityViewModels
import com.bootcamp.empytmusicapp.databinding.FragmentPlayingSongBinding
import com.bootcamp.empytmusicapp.listeners.SongListener
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.services.MusicService
import com.bootcamp.empytmusicapp.viewModels.SongViewModel

class PlayingSongFragment : Fragment() {
    private val viewModel: SongViewModel by activityViewModels()
    private lateinit var binding: FragmentPlayingSongBinding
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
    }

    fun stopSong() {
        val intent = Intent(getActivity(), MusicService::class.java)
        intent.putExtra(MusicService.STOP_FLAG, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(getActivity() as Context, intent)
        }
    }

}