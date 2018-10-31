package com.github.vectorway.vectorway

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.github.vectorway.vectorway.adapters.BottomBarAdapter
import com.github.vectorway.vectorway.fragments.MembersFragment
import com.github.vectorway.vectorway.fragments.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setLogo(R.drawable.logo)
        title = getText(R.string.title_news)
        toolbar.setTitleTextColor(R.color.colorPrimary)
        toolbar.setTitleMargin(70,1,1,1)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        viewPager.setPagingEnabled(false)
        val pagerAdapter = BottomBarAdapter(supportFragmentManager)
        val fragmentMembers = MembersFragment()
        val fragmentNews = NewsFragment()
        pagerAdapter.addFragments(fragmentNews)
        pagerAdapter.addFragments(fragmentMembers)
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = 0
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {  item ->
        when (item.itemId) {
            R.id.navigation_news -> {
                 viewPager.currentItem = 0
                title = getText(R.string.title_news)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_members -> {
                viewPager.currentItem = 1
                title = getText(R.string.title_members)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}

