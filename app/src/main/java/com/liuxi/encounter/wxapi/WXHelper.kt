package com.liuxi.encounter.wxapi

import android.app.Activity
import android.content.Context
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

/**
 * Created by liuxi on 2018/3/14.
 */

class WXHelper private constructor() {

    var api: IWXAPI? = null
        private set

    fun register(context: Context) {
        if (api != null) {
            return
        }
        api = WXAPIFactory.createWXAPI(context, WXConstants.APP_KEY, false)
        api!!.registerApp(WXConstants.APP_KEY)
    }


    /**
     * 绑定授权账号
     *
     * @param resp
     */

    fun bind(activity: Activity, resp: SendAuth.Resp) {
        val code = resp.code

    }

    companion object {
        private lateinit var sMInstance: WXHelper

        val instance: WXHelper
            get() {
                if (sMInstance == null) {
                    synchronized(WXHelper::class.java) {
                        if (sMInstance == null) {
                            sMInstance = WXHelper()
                        }
                    }

                }
                return sMInstance
            }
    }

}
