package com.gpc.olddriver.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.gpc.olddriver.base.BaseFragment

/**
 * Created by gupengcheng on 2018/1/31.
 */
class MainAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val mFragmentList: ArrayList<BaseFragment> = ArrayList()
    val mTitleList: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitleList.get(position)
    }

    fun addFragment(title: String, fragment: BaseFragment) {
        mTitleList.add(title)
        mFragmentList.add(fragment)
        notifyDataSetChanged()
    }

}