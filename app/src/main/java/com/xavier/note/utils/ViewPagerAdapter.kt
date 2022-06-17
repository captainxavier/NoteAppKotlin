package com.xavier.note.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xavier.note.ui.home.AllFragment
import com.xavier.note.ui.home.FolderFragment

class ViewPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragment,lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                AllFragment()
            }
            1 ->{
                FolderFragment()
            }
            else->{
                Fragment()
            }
        }

    }
}