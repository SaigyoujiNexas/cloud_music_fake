package com.saigyouji.cloudmusic.view.fragment.MainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saigyouji.cloudmusic.R
import com.saigyouji.cloudmusic.dataRemote.menuData.MenuItem
import com.saigyouji.cloudmusic.view.adapter.MainMenuAdapter
import com.saigyouji.cloudmusic.view.adapter.MainMenuComparator

class MainPageMusicFragment: Fragment() {

    private lateinit var itemList: List<MenuItem>
    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: MainMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_music, container, false)
        menuRecyclerView = view.findViewById(R.id.rv_main_menu)
        menuAdapter = MainMenuAdapter(MainMenuComparator())
        initMenuListItem()
        menuRecyclerView.layoutManager = LinearLayoutManager(context)
        menuRecyclerView.adapter = menuAdapter
        menuAdapter.submitList(itemList)

        return view
    }


    private fun initMenuListItem()
    {
        val menu1 = MenuItem(R.mipmap.music_icn_local, R.string.local_music, R.string.default_zero)
        val menu2 = MenuItem(R.mipmap.music_icn_recent, R.string.recently_played, R.string.default_zero)
        val menu3 = MenuItem(R.mipmap.music_icn_dld, R.string.download_manager, R.string.default_zero)
        val menu4 = MenuItem(R.mipmap.music_icn_myradio, R.string.my_radio, R.string.default_zero)
        val menu5 = MenuItem(R.mipmap.music_icn_my_collections, R.string.my_collections, R.string.default_zero)
        itemList = listOf(menu1, menu2, menu3, menu4, menu5)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment MusicFragment.
         */
        @JvmStatic
        fun newInstance(): MainPageMusicFragment = MainPageMusicFragment()
    }
}