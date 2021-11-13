package com.saigyouji.cloudmusic.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(fg: FragmentActivity, list: List<Fragment>) :FragmentStateAdapter(fg) {
    private  var  list = list
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
    override fun getItemCount(): Int {
        return list.size
    }
}