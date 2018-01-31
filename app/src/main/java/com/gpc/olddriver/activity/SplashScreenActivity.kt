package com.gpc.olddriver.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import com.gpc.olddriver.R
import com.gpc.olddriver.base.BaseActivity
import com.gpc.olddriver.utils.LogUtil

class SplashScreenActivity : BaseActivity() {

    override val TAG: String
        get() = "闪屏"

    companion object {
        fun startActivity(context: Context? = null) {
            val intent = Intent()
            intent.setClass(context, SplashScreenActivity::class.java)
            context?.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash_screen
    }

    override fun initParentData() {
        LogUtil.instance.d(TAG, "initParentData")
    }

    override fun configView() {
        Handler().postDelayed(Runnable {
            MainActivity.startActivity(mContext)
            finish()
        }, 3000)
    }

    override fun requestServerData() {

    }

    override fun cancelRequestServer() {

    }

}
