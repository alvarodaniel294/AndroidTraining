package com.bootcamp.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bootcamp.emptyapplication.databinding.ActivityMainBinding
import com.bootcamp.emptyapplication.fragments.HomeFragment
import com.bootcamp.emptyapplication.fragments.ItemFragment
import com.bootcamp.emptyapplication.fragments.OtherFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(binding.frame.id, HomeFragment()).commit()
        binding.bottomNav.setOnNavigationItemSelectedListener {
            var fragment: Fragment? = null
            when (it.itemId) {
                R.id.nav_list -> {
                    fragment = ItemFragment()
                }
                R.id.nav_home -> {
                    fragment = HomeFragment()
                }
                R.id.nav_other -> {
                    fragment = OtherFragment()
                }
                else -> false
            }
            if (fragment != null) {
                supportFragmentManager.beginTransaction().replace(binding.frame.id, fragment).commit()
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}

