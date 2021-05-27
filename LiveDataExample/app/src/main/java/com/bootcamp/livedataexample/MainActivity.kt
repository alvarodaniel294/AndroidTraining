package com.bootcamp.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bootcamp.livedataexample.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    val viewmodel:MainActivityViewModel by viewModels()


    lateinit var titleTextView: TextView
    lateinit var changeTitleButton: Button
    //val title:MutableLiveData<String> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById<TextView>(R.id.titleTextView)
        changeTitleButton = findViewById(R.id.changeTitleButton)

        viewmodel.title.observe(this, Observer {
            titleTextView.text = it
        })

        changeTitleButton.setOnClickListener {
            viewmodel.updateTitle()
        }




    }


//    private fun changeTitle(){
//        titleTextView.text = "new title"
//    }
}

