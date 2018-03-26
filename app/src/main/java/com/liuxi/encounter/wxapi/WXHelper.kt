package com.liuxi.encounter.wxapi

import android.app.Activity
import android.content.Context
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

/**
 * 微信核心工具类
 * Created by liuxi on 2018/3/14.
 */

object WXHelper {

    lateinit var api: IWXAPI

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

}
