package com.bootcamp.emptyapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bootcamp.emptyapplication.adapters.MyItemRecyclerViewAdapter
import com.bootcamp.emptyapplication.databinding.FragmentItemListBinding
import com.bootcamp.emptyapplication.models.Item

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding
    private val list = generateData()
    private val adapter = MyItemRecyclerViewAdapter(list)
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        binding.list.layoutManager = LinearLayoutManager(this.context)
        binding.list.adapter = adapter
        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            this.refreshDataTest()
            this.adapter.notifyDataSetChanged()
            this.swipeRefreshLayout.isRefreshing = false
        }
        return binding.root
    }

    private fun generateData(): ArrayList<Item> {
        val list = ArrayList<Item>()
        list.add(Item("Mock 1", "https://picsum.photos/id/1/300/200"))
        list.add(Item("Mock 2", "https://picsum.photos/id/2/300/200"))
        list.add(Item("Mock 3", "https://picsum.photos/id/3/300/200"))
        list.add(Item("Mock 4", "https://picsum.photos/id/4/300/200"))
        list.add(Item("Mock 5", "https://picsum.photos/id/5/300/200"))
        list.add(Item("Mock 6", "https://picsum.photos/id/6/300/200"))
        return list
    }

    private fun refreshDataTest() {
        list.add(Item("Mock 7", "https://picsum.photos/id/10/300/200"))
        list.add(Item("Mock 8", "https://picsum.photos/id/11/300/200"))
        list.add(Item("Mock 9", "https://picsum.photos/id/12/300/200"))
        list.add(Item("Mock 10","https://picsum.photos/id/13/300/200"))
    }
}