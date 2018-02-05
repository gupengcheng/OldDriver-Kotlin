package com.gpc.olddriver.view.fragment.main

import android.os.Bundle
import android.widget.TextView
import com.gpc.olddriver.R
import com.gpc.olddriver.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_fir.*

/**
 * Created by gupengcheng on 2018/1/31.
 */
class MainThirFragment : BaseFragment() {

    companion object {
        fun newInstance(title: String): BaseFragment {
            val fragment = MainThirFragment()
            val bundle = Bundle()
            bundle.putString(MainFirFragment.KEY_TITLE, title)
            fragment.arguments = bundle
            return fragment
        }
    }

    var mTitle: String? = null

    override val TAG: String
        get() = "商城"

    override fun getLayoutId(): Int {
        return R.layout.fragment_main_fir
    }

    override fun initParentData() {
        mTitle = arguments.getString(MainFirFragment.KEY_TITLE)
    }

    override fun configView() {
        val tabList = arrayListOf<String>("推荐", "附近", "视频", "旅行", "健身", "读书", "数码",
                "宠物", "美食", "男士穿搭", "影视", "明星")
        tabList.forEachIndexed { index, s ->
            val tView = TextView(mContext)
            tView.setText(s)
            tView.setPadding(30, 0, 30, 0)
            layTab.addView(tView)
        }
    }

    override fun requestServerData() {

    }

    override fun cancelRequestServer() {

    }

}