package com.bootcamp.persistenceapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val NAME_KEY = "myname"
    }

    lateinit var nameEditText: EditText
    lateinit var preferences:SharedPreferences
    lateinit var preferences2:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById<EditText>(R.id.nameEditText)
        preferences = getSharedPreferences("PERSISTENCE", Context.MODE_PRIVATE)
        //preferences2 = getPreferences(Context.MODE_PRIVATE)

        findViewById<Button>(R.id.saveButton).setOnClickListener(this)
        findViewById<Button>(R.id.showBtn).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.saveButton ->{
                saveButton()
            }
            R.id.showBtn ->{
                showName()
            }
        }
    }

    private fun showName() {
        val text = preferences.getString(NAME_KEY, "Default Value")


        text?.let {
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
       }
    }

    private fun saveButton() {

        val textToSave = nameEditText.text.toString()

        preferences.edit().putString(NAME_KEY, textToSave).apply()


       // preferences.edit().putInt(NAME_KEY, 88).apply()



        //preferences.edit().putString(NAME_KEY, textToSave).apply()
    }


}