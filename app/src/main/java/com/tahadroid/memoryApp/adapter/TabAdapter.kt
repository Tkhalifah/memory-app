package com.tahadroid.memoryApp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.tahadroid.memoryApp.pojo.MyTab
import java.util.*

class TabAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {
    var myTabList: MutableList<MyTab> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return myTabList[position].baseFragment
    }

    fun addTab(tab: MyTab) {
        myTabList.add(tab)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return myTabList[position].category.mCategoryName
    }

    override fun getCount(): Int {
        return myTabList.size
    }
}