package com.bootcamp.emptyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bootcamp.emptyapplication.databinding.ActivityMainBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val users = mutableListOf<User>(
            User(
                    1, "McLovin",true, "https://pbs.twimg.com/profile_images/1359688227003772929/SY9TQ1h0.jpg"
            ),
            User(
                    2, "Juanito Arco Iris",true, "https://images.vexels.com/media/users/3/203449/isolated/lists/5c54f244e824bc49de3eba5c9351f3cd-ilustracion-del-planeta-venus.png"
            ),
            User(
                    3, "Samantha",true, "https://pbs.twimg.com/profile_images/1142560485629468672/ykeUJZVJ_400x400.jpg"
            )
    )
    private lateinit var  userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding
    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userAdapter = UserAdapter(users)
        val recycler: RecyclerView = view?.findViewById(R.id.firstFragment) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(parentFragment?.context)
        recycler.adapter = userAdapter
        userAdapter.notifyDataSetChanged()

    }
}