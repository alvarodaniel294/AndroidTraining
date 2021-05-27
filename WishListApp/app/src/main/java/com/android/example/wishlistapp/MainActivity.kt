package com.android.example.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.wishlistapp.Entities.Wish
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var recycler: RecyclerView
    var priorityValue: String = "Medium"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById<RecyclerView>(R.id.wishRecycler)
        findViewById<Button>(R.id.saveDBButton).setOnClickListener { saveInDB() }
        findViewById<Button>(R.id.lowPriority).setOnClickListener { priorityValue = "Low" }
        findViewById<Button>(R.id.mediumPriority).setOnClickListener { priorityValue = "Medium" }
        findViewById<Button>(R.id.highPriority).setOnClickListener { priorityValue = "High" }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = WishAdapter(mutableListOf(), application)
        showList()
    }
    private fun saveInDB(){
        CoroutineScope(Dispatchers.IO).launch{
            val app = application.applicationContext as WishApp
            val stringToSave = findViewById<EditText>(R.id.nameEditText).text.toString()
            val todoToSave = Wish(null,stringToSave,priorityValue,"Josue")
            app.wishDB.wishDao().addWish(todoToSave)
        }
    }

    private fun showList(){
        CoroutineScope(Dispatchers.IO).launch{
            val app = application.applicationContext as WishApp
            val listTodo = app.wishDB.wishDao().getWishList()

            withContext(Dispatchers.Main){
                listTodo.observe(this@MainActivity, Observer{
                    recycler.adapter = WishAdapter(it, application)
                })
            }
        }
    }

}