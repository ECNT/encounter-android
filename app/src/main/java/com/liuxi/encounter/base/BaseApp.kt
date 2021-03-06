package com.liuxi.encounter.base

import android.app.Application
import com.liuxi.encounter.wxapi.WXHelper

/**
 * Created by liuxi on 2018/3/25.
 */
object BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initApp()
    }

    private fun initApp() {
        WXHelper.register(applicationContext)
    }

}