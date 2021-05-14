package com.bootcamp.emptyapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class DetailFragment : Fragment() {

    var dogImageUrl: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            dogImageUrl = it.getString("myDogImageUrl").toString()
        }
        Log.d("chris","tengo tu dato y es ${dogImageUrl}")
        val textView = view.findViewById<TextView>(R.id.tv_dog_url)
        textView.text = dogImageUrl
    }
}