package com.liuxi.encounter.wxapi

import android.app.Activity
import com.tencent.mm.opensdk.modelmsg.SendAuth
import java.lang.ref.WeakReference

/**
 * Created by liuxi on 2018/3/13.
 */

class WXAuthTask(internal var mActivity: WeakReference<Activity>) {

    fun auth() {
        val req = SendAuth.Req()
        req.scope = WXConstants.SCOPE
        val api = WXHelper.instance.api
        api!!.sendReq(req)

    }

}
