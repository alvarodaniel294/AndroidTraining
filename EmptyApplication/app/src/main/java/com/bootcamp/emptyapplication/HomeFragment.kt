package com.bootcamp.emptyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    var dogs = mutableListOf<String>(
            "https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg",
            "https://images.dog.ceo/breeds/mexicanhairless/n02113978_2425.jpg",
            "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_4028.jpg",
            "https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg",
            "https://images.dog.ceo/breeds/mexicanhairless/n02113978_2425.jpg",
            "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_4028.jpg")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv_RecycleView: RecyclerView = view.findViewById(R.id.rv_dogs)
        rv_RecycleView.layoutManager = LinearLayoutManager(parentFragment?.context) //HomeFragment().context
        val recyclerAdapter = DogAdapter(dogs)
        rv_RecycleView.adapter = recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()
    }
}