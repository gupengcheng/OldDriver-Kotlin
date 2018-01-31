package com.gpc.olddriver.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gpc.olddriver.utils.LogUtil
import com.umeng.analytics.MobclickAgent

/**
 * Created by gupengcheng on 2018/1/29. 所有需要继承AppCompatActivity类的基类
 */
abstract class BaseActivity : AppCompatActivity() {

    var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        LogUtil.instance.e(TAG, "onCreate")

        mContext = this
        initParentData()
        configView()
        requestServerData()
    }

    override fun onResume() {
        super.onResume()
        LogUtil.instance.e(TAG, "onResume")
        MobclickAgent.onPageStart(TAG)
        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        LogUtil.instance.e(TAG, "onPause")
        MobclickAgent.onPageEnd(TAG)
        MobclickAgent.onPause(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.instance.e(TAG, "onDestroy")
        cancelRequestServer()
    }

    // 定义一个必须实现的TAG
    abstract val TAG: String

    abstract fun getLayoutId(): Int

    abstract fun initParentData()

    abstract fun configView()

    abstract fun requestServerData()

    abstract fun cancelRequestServer()

}