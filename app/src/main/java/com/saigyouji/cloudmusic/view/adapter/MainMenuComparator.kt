package com.saigyouji.cloudmusic.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.saigyouji.cloudmusic.dataRemote.menuData.MenuItem

class MainMenuComparator: DiffUtil.ItemCallback<MenuItem>() {
    override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return newItem.numText == newItem.numText
    }
    override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return newItem ==  oldItem
    }
}