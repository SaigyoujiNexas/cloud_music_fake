package com.saigyouji.cloudmusic.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saigyouji.cloudmusic.R

class MainMenuHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageIcon : ImageView = itemView.findViewById(R.id.iv_main_menu)
    private val  menuText: TextView = itemView.findViewById(R.id.tv_main_menu)
    private val numText: TextView = itemView.findViewById(R.id.tv_main_menu_num)

    fun bind(iconId: Int, text: Int, num: Int, l : View.OnClickListener)
    {
        imageIcon.setImageResource(iconId);
        menuText.setText(text)
        numText.setText(num)
        itemView.setOnClickListener(l)
    }
    companion object{
        fun create(parent: ViewGroup):MainMenuHolder{
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_music_main, parent, false)
            return MainMenuHolder(view)
        }
    }
}