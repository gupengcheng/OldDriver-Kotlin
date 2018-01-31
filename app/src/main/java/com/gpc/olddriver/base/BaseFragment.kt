package com.gpc.olddriver.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umeng.analytics.MobclickAgent

/**
 * Created by gupengcheng on 2018/1/31. 所有Fragment的基类
 */
abstract class BaseFragment : Fragment() {

    var mContext: Context? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(getLayoutId(), container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = context
        initParentData()
        configView()
        requestServerData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cancelRequestServer()
    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onPageStart(TAG)
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPageEnd(TAG)
    }

    // 定义一个必须实现的TAG
    abstract val TAG: String

    abstract fun getLayoutId(): Int

    abstract fun initParentData()

    abstract fun configView()

    abstract fun requestServerData()

    abstract fun cancelRequestServer()

}