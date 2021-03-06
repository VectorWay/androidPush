package com.github.vectorway.vectorway.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

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