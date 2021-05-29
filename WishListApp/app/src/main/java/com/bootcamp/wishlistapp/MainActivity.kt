package com.bootcamp.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.wishlistapp.data.Wish
import com.bootcamp.wishlistapp.data.WishApp
import com.bootcamp.wishlistapp.data.WishListener
import com.bootcamp.wishlistapp.data.recycler.WishAdapter
import com.bootcamp.wishlistapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), WishListener {

    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var wishAdapter: WishAdapter
    val app = applicationContext as WishApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initRecyclerView()
        listenButtonSave()
        listenButtonShow()
    }

    fun initRecyclerView(){
        wishAdapter = WishAdapter( app.room.wishDao().getAllWishes(),this  )
        val recycler = activityMainBinding.rvWish
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = wishAdapter
    }

    fun listenButtonSave(){
        activityMainBinding.btnSave.setOnClickListener {
            val body = activityMainBinding.edBody.text.toString()
            val priority: String = activityMainBinding.edPriority.text.toString()
            val owner: String = activityMainBinding.edOwner.text.toString()
            val myWish: Wish = Wish(null,body,priority,owner)
            app.room.wishDao().insertWish(myWish)
        }
    }

    fun listenButtonShow(){
        activityMainBinding.btnShow.setOnClickListener {
            wishAdapter.notifyDataSetChanged()
        }
    }

    override fun editWish(editWish: Wish) {
        TODO("Not yet implemented")
    }

    override fun deleteWish(delWish: Wish) {
        TODO("Not yet implemented")
    }
}