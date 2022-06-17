package com.xavier.note.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.xavier.note.R
import com.xavier.note.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.layout_home_center.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){tab,position->
            run {
                when (position) {
                    0 -> {
                        tab.text = "All"
                    }
                    1 -> {
                        tab.text = "Folders"
                    }
                }
            }
        }.attach()
    }
}