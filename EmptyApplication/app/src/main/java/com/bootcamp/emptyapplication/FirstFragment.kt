package com.bootcamp.emptyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bootcamp.emptyapplication.databinding.ActivityMainBinding
import com.bootcamp.emptyapplication.databinding.FragmentFirstBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : Fragment(), RecyclerViewOnItemClickListener {

    private val users = mutableListOf<User>(
            User(
                    1, "McLovin",true, "https://pbs.twimg.com/profile_images/1359688227003772929/SY9TQ1h0.jpg"
            ),
            User(
                    2, "Juanito Arco Iris",true, "https://pbs.twimg.com/profile_images/1142560485629468672/ykeUJZVJ_400x400.jpg"
            ),
            User(
                    3, "Samantha",true, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJrHF0hjaC4bD2DPmM5D7vi17H_j3xwoCQ1w&usqp=CAU"
            )
    )

    private lateinit var  userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView = view?.findViewById(R.id.reciclerView) as RecyclerView
        userAdapter = UserAdapter(users, this)
        recycler.layoutManager = LinearLayoutManager(parentFragment?.context)

        recycler.adapter = userAdapter
        userAdapter.notifyDataSetChanged()

        val swipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            users.add(User(4, "Josue", connected = false, "https://i.pinimg.com/originals/d1/4b/bd/d14bbd636058f8f4c889bbeae71379b8.png"))
            swipeRefreshLayout.isRefreshing = false
            userAdapter.notifyDataSetChanged()


        }

    }

    override fun viewProfile(user: User) {
        val navController = findNavController()
        val bundle = Bundle()
        bundle.putString(userDetails.NAME, user.name)
        bundle.putString(userDetails.IMAGE, user.url)
        navController.navigate(R.id.action_firstFragment_to_userDetails, bundle)
    }
}