package com.liuxi.encounter.model.data

import android.content.Context
import android.content.SharedPreferences
import com.liuxi.encounter.base.BaseApp
import com.liuxi.encounter.utils.AccountManager

/**
 * SharePreferences Utils
 * Created by liuxi on 2018/3/26.
 */
object SPUtils {
    private const val USER = "user_"
    private const val COMMOM = "common"

    /**
     * 存储用户数据
     */
    fun getUserSP(): SharedPreferences {
        return BaseApp.getSharedPreferences("$USER${AccountManager.getUserId()}"
                , Context.MODE_PRIVATE)
    }

    /**
     * 存储公共数据
     */
    fun getCommonSP(): SharedPreferences {
        return BaseApp.getSharedPreferences(COMMOM, Context.MODE_PRIVATE)
    }

    /**
     * 对shared preferences数据存储的简单封装
     */
    fun <T> put(key: String, t: T, isUser: Boolean = false) {

        var editor = when (isUser) {
            true -> getUserSP().edit()
            false -> getCommonSP().edit()
        }
        when (t) {
            is String -> editor.putString(key, t)
            is Int -> editor.putInt(key, t)
            is Long -> editor.putLong(key, t)
            is Boolean -> editor.putBoolean(key, t)
            is Float -> editor.putFloat(key, t)
        }
        editor.apply()

    }


}