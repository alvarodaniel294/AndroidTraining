package com.bootcamp.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.emptyapplication.Adapter.TeamAdapter
import com.bootcamp.emptyapplication.Interfaces.TeamListener
import com.bootcamp.emptyapplication.Models.Team
import com.bootcamp.emptyapplication.databinding.ActivityMainBinding
import com.bootcamp.emptyapplication.fragments.RecycleFragment
import com.bootcamp.emptyapplication.fragments.SecondFragment
import com.bootcamp.emptyapplication.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var recycleFragment = RecycleFragment()
        var secondFragment = SecondFragment()
        var thirdFragment = ThirdFragment()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId ) {
                R.id.recyclerItem -> showFragment(recycleFragment)
                R.id.secondItem -> showFragment(secondFragment)
                R.id.thirdItem -> showFragment(thirdFragment)
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutWrapper,fragment)
            commit()
        }
}