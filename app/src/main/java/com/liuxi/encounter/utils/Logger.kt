package com.liuxi.encounter.utils

import android.util.Log

/**
 * Created by liuxi on 2018/3/22.
 */
object Logger {
    private val TAG: String = "encounter"
    fun d(str: String) {
        Log.d(TAG, str)
    }
}