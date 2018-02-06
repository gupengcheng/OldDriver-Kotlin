package com.gpc.olddriver.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.gpc.olddriver.R
import com.gpc.olddriver.model.ImageLoader
import com.gpc.olddriver.utils.LogUtil
import kotlinx.android.synthetic.main.item_fir.view.*

/**
 * Created by gupengcheng on 2018/1/31.
 */
class FirItemAdapter(val imgList: ArrayList<String>) : RecyclerView.Adapter<FirItemAdapter.FirItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FirItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_fir, parent, false)
        return FirItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirItemViewHolder?, position: Int) {
        LogUtil.instance.e("FirItemAdapter","onBindViewHolder ${imgList.get(position)}")
        ImageLoader.loadImage(imgList.get(position), holder!!.imgView)
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    class FirItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView = view.imgView
    }

}