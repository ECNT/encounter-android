package com.liuxi.encounter.utils

import android.text.TextUtils
import com.liuxi.encounter.model.bean.User

/**
 * 账户管理类
 * Created by liuxi on 2018/3/26.
 */
object AccountManager {

    fun getUserId(): String? {

        return getUserData()?.id

    }

    fun isLogin(): Boolean {

        return TextUtils.isEmpty(getUserId())

    }

    fun saveUserData(user: User?) {

        if (user == null) {
            return
        }

        TODO("保存数据，数据库操作")

    }

    fun getUserData(): User? {
        TODO("获取数据，数据库操作")
        return null

    }

}