package com.gpc.olddriver.model

import android.widget.ImageView
import com.gpc.olddriver.App
import com.gpc.olddriver.BuildConfig
import com.squareup.picasso.Picasso

/**
 * Created by gupengcheng on 2018/1/31.
 */
class ImageLoader {

    companion object {
        fun setDebugMode() {
            Picasso.with(App.instance).setIndicatorsEnabled(BuildConfig.LOG_DEBUG)
        }

        fun loadImage(imgUrl: String, imgView: ImageView) {
            Picasso.with(App.instance).load(imgUrl).into(imgView)
        }
    }

}