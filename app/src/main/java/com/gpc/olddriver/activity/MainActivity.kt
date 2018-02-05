package com.gpc.olddriver.activity

import android.content.Context
import android.content.Intent
import com.gpc.olddriver.R
import com.gpc.olddriver.base.BaseFragmentActivity
import com.gpc.olddriver.view.adapter.MainAdapter
import com.gpc.olddriver.view.fragment.main.MainFirFragment
import com.gpc.olddriver.view.fragment.main.MainSecFragment
import com.gpc.olddriver.view.fragment.main.MainThirFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by gupengcheng on 2018/1/30.
 */
class MainActivity : BaseFragmentActivity() {

    override val TAG: String
        get() = "首页"

    var mMainAdapter: MainAdapter? = null
    var mTabList: List<String>? = null

    companion object {
        fun startActivity(context: Context? = null) {
            val intent = Intent()
            intent.setClass(context, MainActivity::class.java)
            context?.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initParentData() {
        val tabArray = resources.getStringArray(R.array.main_tab)
        mTabList = tabArray.asList()
    }

    override fun configView() {
        mMainAdapter = MainAdapter(supportFragmentManager)
        viewpagerMain.adapter = mMainAdapter
        viewpagerMain.offscreenPageLimit = 2
        tabMain.setupWithViewPager(viewpagerMain)

        mTabList?.forEachIndexed { index, s ->
            when {
                index == 0 -> mMainAdapter?.addFragment(s, MainFirFragment.newInstance(s))
                index == 1 -> mMainAdapter?.addFragment(s, MainSecFragment.newInstance(s))
                index == 2 -> mMainAdapter?.addFragment(s, MainThirFragment.newInstance(s))
            }
        }
    }

    override fun requestServerData() {

    }

    override fun cancelRequestServer() {

    }

}