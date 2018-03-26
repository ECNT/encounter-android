package com.liuxi.encounter.utils

import android.app.Activity
import com.liuxi.encounter.R
import com.liuxi.encounter.wxapi.WXShareTask
import com.liuxi.encounter.wxapi.wechat.widget.ShareModel
import com.liuxi.encounter.wxapi.widget.ShareDialog
import java.lang.ref.WeakReference
import java.util.*

/**
 * Created by liuxi on 2018/3/23.
 */


/**
 * 分享图片对话框
 *
 * @param activity
 * @param model
 */
fun shareImage(activity: WeakReference<Activity>, model: ShareModel) {
    val contentList = ArrayList<ShareDialog.ActionItem>()
    val wechatSessionItem = ShareDialog.ActionItem(activity.get()!!.getString(R.string.wechat_session),
            R.drawable.share_wechat,
            object : ShareDialog.ActionItemCallBack {
                override fun actionCallBack() {
                    WXShareTask(activity, true).share(model)
                }
            })
    contentList.add(wechatSessionItem)
    val timelineItem = ShareDialog.ActionItem(activity.get()!!.getString(R.string.wechat_timeline),
            R.drawable.share_moment,
            object : ShareDialog.ActionItemCallBack {
                override fun actionCallBack() {
                    WXShareTask(activity, false).share(model)
                }
            })
    contentList.add(timelineItem)


    ShareDialog.show(activity.get()!!, contentList).show()
}


