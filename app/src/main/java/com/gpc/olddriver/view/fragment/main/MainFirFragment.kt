package com.gpc.olddriver.view.fragment.main

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.TextView
import com.gpc.olddriver.R
import com.gpc.olddriver.base.BaseFragment
import com.gpc.olddriver.utils.LogUtil
import com.gpc.olddriver.utils.TestUtil
import com.gpc.olddriver.view.fragment.fir.FirItemFragment
import kotlinx.android.synthetic.main.fragment_main_fir.*

/**
 * Created by gupengcheng on 2018/1/31.
 */
class MainFirFragment : BaseFragment() {

    companion object {
        val KEY_TITLE: String = "key_title"

        fun newInstance(title: String): BaseFragment {
            val fragment = MainFirFragment()
            val bundle = Bundle()
            bundle.putString(KEY_TITLE, title)
            fragment.arguments = bundle
            return fragment
        }
    }

    var mTitle: String? = null

    var tabList: ArrayList<String>? = null

    val fragmentMap: HashMap<String, BaseFragment> = HashMap()

    override val TAG: String
        get() = "关注"

    override fun getLayoutId(): Int {
        return R.layout.fragment_main_fir
    }

    override fun initParentData() {
        mTitle = arguments.getString(KEY_TITLE)
        tabList = arrayListOf<String>("推\n荐", "附近", "视频", "旅行", "健身", "读书", "数码",
                "宠物", "美食", "男士穿搭", "影视", "明星")
        val items = listOf("3", "4", "5", "1", "2")
        println("tabList is $tabList, items is $items")

        val  arrays = arrayOf(1,2,3)
        println("arrays is $arrays")
        arrays.forEach { println("arrays item is $it") }

        val arrays2 = Array(5, {i -> (i*i*i).toString() })
        println("arrays2 is $arrays2")
        arrays2.forEach { println("arrays2 item is $it") }

        for (item in items) {
            println("item is $item")
        }

        for (index in items.indices) {
            println("item index is $index ,value is ${items[index]}")
        }

        items.forEach { println("item is $it") }

        when {
            "3" in items -> println("3 in items")
            "4" in items -> println("4 in items")
            "5" in items -> println("5 in items")
            "6" in items -> println("6 in items")
        }

        items.sortedBy { it.toInt() }
                .sortedByDescending { it.toInt() }
                .filter { it.toInt() > 2 }
                .map { it.plus(33) }
                .forEach { println("sort item $it") }

        val testUtil = TestUtil()
        with(testUtil) {
            testWhen(12)
            testWhen("我")
            testWhen(10L)
            testWhen(0)
        }

        val sss = """\nsss...
            |sfdsafasdfa
            |\r\t\n\m
        """.trimMargin()
        println(sss)

        loop@for (i in 1..100) {
            for (j in 190 downTo 101)  {
                println("i $i , j $j")
                if (i == 3) {
                    break@loop
                }
            }
        }

        foo()
    }

    fun foo(){
        val items = listOf("3", "4", "5", "1", "2")
        items.forEach {
            if (it.equals("4")) return@forEach
            println("item is going on $it")
        }

        val asSequence = items.asSequence()
        println("asSequence is class " + asSequence.javaClass)
        asSequence.forEach {
            println("asSequence is $it")
        }
    }

    override fun configView() {
        tabList?.forEachIndexed { index, s ->
            val tView = TextView(mContext)
            tView.setText(s)
            tView.setPadding(30, 0, 30, 0)
            LogUtil.instance.e(TAG, s)
            tView.setTag(s)
            tView.setOnClickListener(View.OnClickListener { tabItemClick(tView.getTag().toString()) })
            layTab.addView(tView)
        } ?: println("tabList is null")
    }

    override fun requestServerData() {

    }

    override fun cancelRequestServer() {

    }

    override fun onResume() {
        super.onResume()
        layContainer.postDelayed(Runnable {
            val itemFragment = FirItemFragment.newInstance("推荐")
            fragmentMap.put("推荐", itemFragment)
            showFragment(itemFragment)
        }, 1000)
    }

    fun tabItemClick(tag: String) {
        LogUtil.instance.e(TAG, "tabItemClick tag = $tag")
        if (fragmentMap.containsKey(tag)) {
            showFragment(fragmentMap[tag])
        } else {
            val itemFragment = FirItemFragment.newInstance(tag)
            fragmentMap.put(tag, itemFragment)
            showFragment(itemFragment)
        }
    }

    fun showFragment(baseFragment: BaseFragment?) {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        if (baseFragment != null && !baseFragment.isAdded) {
            LogUtil.instance.e(TAG, "showFragment add baseFragment")
            fragmentTransaction.add(R.id.layContainer, baseFragment)
        }
        LogUtil.instance.e(TAG, "showFragment add baseFragment ${baseFragment!!.isAdded}")
        hideOtherFragment(fragmentTransaction, baseFragment)
        fragmentTransaction.show(baseFragment)
        fragmentTransaction.commitAllowingStateLoss()
    }

    fun hideOtherFragment(fragmentTransaction: FragmentTransaction, baseFragment: BaseFragment?) {
        LogUtil.instance.e(TAG, "fragmentMap size = ${fragmentMap.size}")

        for ((k, v) in fragmentMap) {
            if (baseFragment != null && baseFragment != v) {
                fragmentTransaction.hide(v)
            }
        }
//        fragmentMap.entries.forEachIndexed { index, mutableEntry ->
//            LogUtil.instance.e(TAG,"hashMap item is ${mutableEntry.value} " +
//                    "baseFragment is $baseFragment | base!=item is ${baseFragment != mutableEntry.value}")
//            if (baseFragment != null && baseFragment != mutableEntry.value) {
//                fragmentTransaction.hide(mutableEntry.value)
//            }
//        }
    }

}