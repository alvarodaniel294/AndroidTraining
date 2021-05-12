package com.bootcamp.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val users = mutableListOf<User>(
        User(
            1, "McLovin",true, "https://pbs.twimg.com/profile_images/1359688227003772929/SY9TQ1h0.jpg"
        ),
        User(
            2, "Juanito Arco Iris",true, "https://pbs.twimg.com/profile_images/1142560485629468672/ykeUJZVJ_400x400.jpg"
        )

    )
    private lateinit var  userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}