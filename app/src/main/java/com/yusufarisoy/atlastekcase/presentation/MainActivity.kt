package com.yusufarisoy.atlastekcase.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yusufarisoy.atlastekcase.R
import com.yusufarisoy.atlastekcase.presentation.listing.ListingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, ListingFragment.newInstance())
            .commit()
    }
}
