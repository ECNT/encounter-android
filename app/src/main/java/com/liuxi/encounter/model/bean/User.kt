package com.liuxi.encounter.model.bean

import org.greenrobot.greendao.annotation.Entity

/**
 * Created by liuxi on 2018/3/26.
 */

@Entity
data class User(var id: String,
                var userName: String,
                var password: String)