package com.gpc.olddriver.utils

/**
 * Created by gupengcheng on 2018/2/7.
 */
class TestUtil {

    fun testWhen(a: Any) {
        when (a) {
            11 -> println("a is 11")
            12 -> println("a is 12")
            is Long -> println("a is Long value")
            is String -> println("a is String value")
            else -> println("a is invalid value")
        }
    }

}