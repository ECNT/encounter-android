package com.liuxi.encounter.wxapi.wechat.widget


import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import java.io.ByteArrayOutputStream
import java.io.File

/**
 * Created by liuxi on 2018/3/23.
 */

object ShareImageHelper {

    fun downloadBitmap(context: Context, url: String, downloadInterface: DownloadCallback) {

        val file = File(Environment.getExternalStorageDirectory(), "")
        if (!file.exists()) {
            file.mkdir()
        }
        val imageFile = File(file, "share_image")
//        HttpManager.getInstance().download(url, imageFile.path, object : com.being.base.http.callback.DownloadCallback() {
//            fun onSuccess(imageFile: File?) {
//                var imageFile = imageFile
//
//                var image: Bitmap? = null
//                try {
//                    if (imageFile != null) {
//                        imageFile = ImageUtils.scaleImageFile(context, imageFile, 120, 120)
//                        image = BitmapFactory.decodeFile(imageFile!!.path)
//                    }
//                } catch (e: Exception) {
//
//                }
//
//                if (image == null) {
//                    image = (context.resources.getDrawable(R.drawable.ic_share) as BitmapDrawable).bitmap
//                }
//                downloadInterface.onSuccess(image)
//            }
//
//            fun onFail(statusCode: Int, failDate: File?, error: Throwable?): Boolean {
//                downloadInterface.onError()
//                return false
//            }
//        })

    }


    fun downloadOriginBitmap(context: Context, url: String, downloadInterface: DownloadCallback) {

        val file = File(Environment.getExternalStorageDirectory(), "")
        if (!file.exists()) {
            file.mkdir()
        }
        val imageFile = File(file, "share_image")
//        HttpManager.getInstance().download(url, imageFile.path, object : com.being.base.http.callback.DownloadCallback() {
//            fun onSuccess(imageFile: File) {
//                var image: Bitmap? = null
//                try {
//                    val fileOutputStream = FileOutputStream(imageFile)
//                    image!!.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
//                    fileOutputStream.flush()
//                    fileOutputStream.close()
//                } catch (e: FileNotFoundException) {
//                    e.printStackTrace()
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                } finally {
//                    image!!.recycle()
//                }
//
//                if (image == null) {
//                    image = (context.resources.getDrawable(R.drawable.ic_share) as BitmapDrawable).bitmap
//                }
//                downloadInterface.onSuccess(image)
//            }
//
//            fun onFail(statusCode: Int, failDate: File?, error: Throwable?): Boolean {
//                downloadInterface.onError()
//                return false
//            }
//        })

    }

    interface DownloadCallback {

        fun onSuccess(bitmap: Bitmap?)

        fun onError()
    }

    fun bmtToByteArray(bmp: Bitmap): ByteArray {
        val output = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output)
        bmp.recycle()
        val result = output.toByteArray()
        try {
            output.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }


}
