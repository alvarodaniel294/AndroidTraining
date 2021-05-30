package com.bootcamp.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.data.Wish
import com.bootcamp.wishlistapp.data.WishApp
import com.bootcamp.wishlistapp.data.WishListener
import com.bootcamp.wishlistapp.data.WishViewModel
import com.bootcamp.wishlistapp.data.recycler.WishAdapter
import com.bootcamp.wishlistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), WishListener {

    lateinit var activityMainBinding: ActivityMainBinding
    val wishViewModel: WishViewModel by viewModels()
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initRecyclerView()
        listenButtonSave()
        initSubscriptions()
    }


    fun initSubscriptions(){
        wishViewModel.getAllWishesFromDatabase(application).observe(this, Observer { currentWishes ->
            recycler.adapter = WishAdapter(currentWishes,this)
        })
    }

    fun initRecyclerView(){
        recycler = activityMainBinding.rvWish
        recycler.layoutManager = LinearLayoutManager(this)
    }

    fun listenButtonSave(){
        activityMainBinding.btnSave.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setMessage("Do you want to insert this wish ?")
                .setPositiveButton("Hell Yeah"){ dialog, id ->
                    val body = activityMainBinding.edBody.text.toString()
                    val priority: String = activityMainBinding.edPriority.text.toString()
                    val owner: String = activityMainBinding.edOwner.text.toString()
                    val myWish: Wish = Wish(null,body,priority,owner)
                    wishViewModel.saveNewWish(myWish,application)
                }
                .setNegativeButton("Nope."){ dialog, id ->
                    dialog.dismiss()
                }
            alertDialog.create().show()
        }
    }

    override fun editWish(editWish: Wish) {
        var alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setMessage("Do you really want to edit this wish ?")
            .setPositiveButton("Yes"){ dialog, id ->
                activityMainBinding.edBody.setText(editWish.body)
                activityMainBinding.edOwner.setText(editWish.owner)
                activityMainBinding.edPriority.setText(editWish.priority)
            }
            .setNegativeButton("Nope"){ dialog, id ->
                dialog.dismiss()
            }
        alertDialog.create().show()
    }

    override fun deleteWish(delWish: Wish) {
        // muestra un alert y elimina el wish
        var alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setMessage("Do you really want to delete this wish ?")
            .setPositiveButton("Yes"){ dialog, id ->
            wishViewModel.deleteWish(delWish,application)
             }
            .setNegativeButton("Nope."){ dialog, id ->
                dialog.dismiss()
            }
        alertDialog.create().show()

    }
}