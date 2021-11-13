package com.saigyouji.cloudmusic.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.saigyouji.cloudmusic.dataRemote.menuData.MenuItem

class MainMenuAdapter(diffCallback: DiffUtil.ItemCallback<MenuItem>): ListAdapter<MenuItem, MainMenuHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuHolder {
        return MainMenuHolder.create(parent)
    }
    override fun onBindViewHolder(holder: MainMenuHolder, position: Int) {
        val item = getItem(position)
        val onclick = if(position == 0)
            View.OnClickListener {  }
        else
            View.OnClickListener {}

        holder.bind(item.iconId,item.itemText, item.numText, onclick)
    }
}