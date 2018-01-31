package com.gpc.olddriver.utils

import android.util.Log
import com.gpc.olddriver.BuildConfig

/**
 * Created by gupengcheng on 2018/1/30.
 */
class LogUtil {

    companion object {
        val instance: LogUtil = LogUtil()
    }

    fun d(tag: String = toString(), message: String) {
        if (BuildConfig.LOG_DEBUG) {
            Log.d(tag, message)
        }
    }

    fun e(tag: String = this.toString(), message: String) {
        if (BuildConfig.LOG_DEBUG) {
            Log.e(tag, message)
        }
    }

    fun v(tag: String = this.toString(), message: String) {
        if (BuildConfig.LOG_DEBUG) {
            Log.v(tag, message)
        }
    }

    fun i(tag: String = this.toString(), message: String) {
        if (BuildConfig.LOG_DEBUG) {
            Log.i(tag, message)
        }
    }

}