package com.gpc.olddriver.view.fragment.fir

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.gpc.olddriver.R
import com.gpc.olddriver.base.BaseFragment
import com.gpc.olddriver.utils.LogUtil
import com.gpc.olddriver.view.adapter.FirItemAdapter
import com.gpc.olddriver.view.fragment.main.MainFirFragment
import kotlinx.android.synthetic.main.fragment_fir_item.*

/**
 * Created by gupengcheng on 2018/1/31.
 */
class FirItemFragment : BaseFragment() {

    companion object {
        val KEY_TITLE: String = "key_title"

        fun newInstance(title: String): BaseFragment {
            val fragment = FirItemFragment()
            val bundle = Bundle()
            bundle.putString(KEY_TITLE, title)
            fragment.arguments = bundle
            LogUtil.instance.e("FirItemFragment", "$fragment")
            return fragment
        }
    }

    var mAdapter: FirItemAdapter? = null

    val mImgList: ArrayList<String> = ArrayList()

    var mTitle: String? = null

    val testImgUrl: String = "http://n.sinaimg.cn/news/1_img/upload/cf3881ab/w1000h648/20180130/El6q-fyqzcxi1992362.jpg"

    override val TAG: String
        get() = "FirItem"

    override fun getLayoutId(): Int {
        return R.layout.fragment_fir_item
    }

    override fun initParentData() {
        mTitle = arguments.getString(MainFirFragment.KEY_TITLE)
    }

    override fun configView() {
        mAdapter = FirItemAdapter(mImgList)
        rcvFirItem.layoutManager = LinearLayoutManager(mContext)
        rcvFirItem.adapter = mAdapter
    }

    override fun requestServerData() {
        mImgList.add(testImgUrl)
        mImgList.add(testImgUrl)
        mImgList.add(testImgUrl)
        mImgList.add(testImgUrl)
        mImgList.add(testImgUrl)
        mImgList.add(testImgUrl)
        LogUtil.instance.e(TAG, "requestServerData ${mImgList.size}")
        mAdapter?.notifyDataSetChanged()
    }

    override fun cancelRequestServer() {

    }

}