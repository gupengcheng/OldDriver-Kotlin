package com.gpc.olddriver

import android.app.Application

/**
 * Created by gupengcheng on 2018/1/29.
 */
class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}