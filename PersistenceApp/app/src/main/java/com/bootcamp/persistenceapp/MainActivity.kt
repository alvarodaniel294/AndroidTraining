package com.bootcamp.persistenceapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.persistenceapp.entities.Todo
import com.bootcamp.persistenceapp.viewmodelFactory.TodoViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val NAME_KEY = "myname"
    }

    lateinit var nameEditText: EditText
    lateinit var preferences: SharedPreferences
    lateinit var preferences2: SharedPreferences
    lateinit var recycler: RecyclerView
    val viewModel: TodoViewModel by viewModels<TodoViewModel> {
        TodoViewModelFactory((application as TodoApp).todoRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById<EditText>(R.id.nameEditText)
        recycler = findViewById<RecyclerView>(R.id.todoRecycler)
        preferences = getSharedPreferences("PERSISTENCE", Context.MODE_PRIVATE)
        //preferences2 = getPreferences(Context.MODE_PRIVATE)

        findViewById<Button>(R.id.saveButton).setOnClickListener(this)
        findViewById<Button>(R.id.showBtn).setOnClickListener(this)
        findViewById<Button>(R.id.saveDBButton).setOnClickListener(this)


        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = TodoAdapter(mutableListOf())

//        viewModel.getListFromDB(application).observe(this, Observer {
//            recycler.adapter = TodoAdapter(it)
//        })

        viewModel.todoList.observe(this, Observer {
            recycler.adapter = TodoAdapter(it)
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.saveButton -> {
                saveButton()
            }
            R.id.showBtn -> {
                showName()
            }
            R.id.saveDBButton -> {
                //saveInDB()
                saveInDBWithRepository()
            }
        }
    }

    private fun saveInDB() {
        val data = nameEditText.text.toString()
        viewModel.saveData(data, application)
    }

    private fun saveInDBWithRepository(){
        val data = nameEditText.text.toString()
        val todo = Todo(null, data, "completed")
        viewModel.saveDataWithRepository(todo)
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
    }


}