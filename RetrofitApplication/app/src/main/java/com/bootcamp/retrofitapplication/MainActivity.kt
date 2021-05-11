package com.bootcamp.retrofitapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.retrofitapplication.adapters.PostItemAdapter
import com.bootcamp.retrofitapplication.apiHelper.RetrofitSingleton
import com.bootcamp.retrofitapplication.models.PostItem
import com.bootcamp.retrofitapplication.postRepository.PostRepository
import com.google.android.material.button.MaterialButton
import okio.IOException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException

class MainActivity : AppCompatActivity() {
    var adapter:PostItemAdapter = PostItemAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recylcer = findViewById<RecyclerView>(R.id.recyclerPosts)
        recylcer.layoutManager = LinearLayoutManager(this)
        recylcer.adapter = adapter



        val button = findViewById<MaterialButton>(R.id.buttonrequest)


        button.setOnClickListener {
            sendRequestRepository()
        }


    }


    fun sendRequest(){
        RetrofitSingleton.api.getPosts().enqueue(object : Callback<List<PostItem>>{
            override fun onResponse(call: Call<List<PostItem>>, response: Response<List<PostItem>>) {
                if (response.code() == 200){
                    response.body()?.let {
                        adapter.list = it
                        adapter.notifyDataSetChanged()
                    }
                }else{

                }
            }

            override fun onFailure(call: Call<List<PostItem>>, t: Throwable) {

                when {
                    t is IOException ->{

                    }
                    t is ConnectException ->{

                    }
                }
            }
        })
    }

    fun sendRequestRepository(){
        PostRepository.PostRepositoryObject.getInstance().getPosts().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
    }

}