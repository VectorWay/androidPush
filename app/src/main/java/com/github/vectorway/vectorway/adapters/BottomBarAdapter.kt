package com.github.vectorway.vectorway.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.github.vectorway.vectorway.adapters.SmartFragmentStatePagerAdapter

class BottomBarAdapter(fragmentManager: FragmentManager?) : SmartFragmentStatePagerAdapter(fragmentManager) {
    private val fragments: MutableList<Fragment> = ArrayList()

    fun addFragments(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}