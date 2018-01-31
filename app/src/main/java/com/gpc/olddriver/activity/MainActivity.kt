package com.gpc.olddriver.activity

import android.content.Context
import android.content.Intent
import android.view.View
import com.gpc.olddriver.R
import com.gpc.olddriver.base.BaseFragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by gupengcheng on 2018/1/30.
 */
class MainActivity : BaseFragmentActivity() {

    override val TAG: String
        get() = "首页"

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

    }

    override fun configView() {
        btnSplashScreen.setOnClickListener(View.OnClickListener { SplashScreenActivity.startActivity(mContext) })
    }

    override fun requestServerData() {

    }

    override fun cancelRequestServer() {

    }

}