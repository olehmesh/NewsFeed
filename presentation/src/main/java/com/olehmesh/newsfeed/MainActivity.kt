package com.olehmesh.newsfeed

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.olehmesh.newsfeed.base.BaseActivity
import com.olehmesh.newsfeed.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding?.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

}