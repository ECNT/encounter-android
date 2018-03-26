package com.liuxi.encounter.view.widget

import android.content.Context
import android.net.Uri
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

/**
 * web imageView
 *
 * Created by liuxi on 2018/3/26.
 */
class ZZImageView(context: Context?) : SimpleDraweeView(context) {

    override fun setImageURI(uriString: String?) {
        super.setImageURI(uriString)
    }

    override fun setImageURI(uri: Uri?, callerContext: Any?) {
        super.setImageURI(uri, callerContext)
    }

    override fun setImageURI(uriString: String?, callerContext: Any?) {
        super.setImageURI(uriString, callerContext)
    }

    /**
     * 支持Gif／常规图
     */
    fun setMultiURI(uriString: String?) {
        val uri = if (uriString != null) Uri.parse(uriString) else null
        setURI(uri)
    }

    /**
     * 支持Gif／常规图
     */
    fun setURI(uri: Uri?) {
        controller = Fresco.newDraweeControllerBuilder()
                .setOldController(controller)
                .setAutoPlayAnimations(true)
                .setUri(uri)
                .build()
    }

    override fun setActualImageResource(resourceId: Int) {
        super.setActualImageResource(resourceId)
    }

    override fun setActualImageResource(resourceId: Int, callerContext: Any?) {
        super.setActualImageResource(resourceId, callerContext)
    }

}