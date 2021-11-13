package com.saigyouji.cloudmusic.view.fragment.MainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.saigyouji.cloudmusic.R
import com.saigyouji.cloudmusic.view.adapter.MainPagerAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [MainPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainPageFragment : Fragment() {

    private lateinit var toolbar: android.widget.Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var mainViewPager : ViewPager2
    private lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)
        drawerLayout = view.findViewById(R.id.dl_main_drawer)
        mainViewPager = view.findViewById(R.id.vp_main_pager)

        val list = listOf(MainPageMusicFragment.newInstance())
        mainPagerAdapter = MainPagerAdapter(activity as FragmentActivity, list)
        mainViewPager.adapter = mainPagerAdapter

        setToolbar(view)


        return view
    }
    private fun setToolbar(view : View)
    {
        toolbar = view.findViewById(R.id.toolbar_main)

        ViewCompat.setOnApplyWindowInsetsListener(toolbar){v, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                v.setPadding(0, insets.top, 0, 0)
            }
            WindowInsetsCompat.CONSUMED
        }
        toolbar.setNavigationIcon(R.drawable.ic_main_menu)
        toolbar.setNavigationOnClickListener { drawerLayout.open() }
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment MusicFragment.
         */
        @JvmStatic
        fun newInstance(): MainPageFragment = MainPageFragment()
    }
}