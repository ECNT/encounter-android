package com.liuxi.encounter.wxapi

import android.app.Activity
import android.graphics.Bitmap
import android.text.TextUtils


import com.liuxi.encounter.wxapi.wechat.widget.ShareImageHelper
import com.liuxi.encounter.wxapi.wechat.widget.ShareModel
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXImageObject
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject

import java.lang.ref.WeakReference

/**
 * Created by liuxi on 2018/3/22.
 */

class WXShareTask(private var mActivity: WeakReference<Activity>, private val isFriend: Boolean) {


    fun share(model: ShareModel) {

        val webPage = WXWebpageObject()
        webPage.webpageUrl = model.url

        val message = WXMediaMessage()
        message.mediaObject = webPage
        message.title = model.title
        message.description = model.description
        if (!TextUtils.isEmpty(model.imageUrl)) {
            ShareImageHelper.downloadBitmap(mActivity.get()!!, model.imageUrl!!, object : ShareImageHelper.DownloadCallback {
                override fun onSuccess(bitmap: Bitmap?) {
                    if (bitmap != null) {
                        message.setThumbImage(bitmap)
                        send(message)
                    }
                }

                override fun onError() {

                }
            })
        } else {
            send(message)
        }


    }

    fun shareImage(model: ShareModel) {

        val shareObject = WXImageObject()
        shareObject.setImagePath(model.imagePath)
        val mediaMessage = WXMediaMessage()
        mediaMessage.mediaObject = shareObject
        send(mediaMessage)

    }

    private fun send(message: WXMediaMessage) {
        val req = SendMessageToWX.Req()
        req.transaction = buildTransaction("image")
        req.message = message
        req.scene = if (isFriend) SendMessageToWX.Req.WXSceneSession else SendMessageToWX.Req.WXSceneTimeline//好友／朋友圈
        WXHelper.instance.api!!.sendReq(req)
    }

    private fun buildTransaction(type: String?): String {
        return if (type == null) System.currentTimeMillis().toString() else type + System.currentTimeMillis()
    }


}
