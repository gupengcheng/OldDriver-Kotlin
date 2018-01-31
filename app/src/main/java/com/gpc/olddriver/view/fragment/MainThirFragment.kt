package com.gpc.olddriver.view.fragment

import com.gpc.olddriver.R
import com.gpc.olddriver.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_fir.*

/**
 * Created by gupengcheng on 2018/1/31.
 */
class MainThirFragment:BaseFragment() {

    companion object {
        fun newInstance(): BaseFragment {
            return MainThirFragment()
        }
    }

    override val TAG: String
        get() = "商城"

    override fun getLayoutId(): Int {
        return R.layout.fragment_main_fir
    }

    override fun initParentData() {

    }

    override fun configView() {
        tvName.setText(TAG)
    }

    override fun requestServerData() {

    }

    override fun cancelRequestServer() {

    }

}