package com.liuxi.encounter.wxapi

import android.app.Activity
import android.os.Bundle

import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler

class WXEntryActivity : Activity(), IWXAPIEventHandler {
    // IWXAPI 是第三方app和微信通信的openapi接口
    private var api: IWXAPI? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        api = WXHelper.api
        api!!.handleIntent(intent, this)
    }

    override fun onReq(baseReq: BaseReq) {

    }

    override fun onResp(baseResp: BaseResp) {
        if (baseResp is SendAuth.Resp) {

        }
        when (baseResp.errCode) {
            0 //用户同意
            -> if (baseResp is SendAuth.Resp) {
                WXHelper.bind(this@WXEntryActivity, baseResp)
            }
            -4 //用户拒绝授权
            -> if (baseResp is SendAuth.Resp) {

            }
            -2 //用户取消
            -> if (baseResp is SendAuth.Resp) {

            }
        }
        finish()
    }

}
