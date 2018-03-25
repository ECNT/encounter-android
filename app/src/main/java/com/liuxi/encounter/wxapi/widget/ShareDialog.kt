package com.liuxi.encounter.wxapi.widget

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.GridView
import android.widget.SimpleAdapter
import android.widget.TextView

import com.liuxi.encounter.R
import com.lx.kotlin.reader.utils.DeviceUtils

import java.util.ArrayList
import java.util.HashMap

/**
 * Created by liuxi on 2018/3/23.
 */

class ShareDialog(context: Context) : Dialog(context, R.style.DialogTransparent) {

    interface ActionItemCallBack {
        fun actionCallBack()
    }

    class ActionItem(var mTitle: String, var mImage: Int, var mCallBack: ActionItemCallBack)

    companion object {

        val IMAGE_KEY = "itemImage"
        val TITLE_KEY = "itemTitle"

        fun show(context: Context, actionList: List<ActionItem>): Dialog {
            val dialog = ShareDialog(context)

            val contentList = ArrayList<HashMap<String, Any>>()
            for (i in actionList.indices) {
                val actionItem = actionList[i]
                val contentItem = HashMap<String, Any>()
                contentItem[IMAGE_KEY] = actionItem.mImage
                contentItem[TITLE_KEY] = actionItem.mTitle
                contentList.add(contentItem)
            }
            val layout = LayoutInflater.from(context).inflate(R.layout.share_content, null)
            val cancelButton = layout.findViewById<View>(R.id.cancel_button) as TextView
            cancelButton.setOnClickListener { dialog.cancel() }
            val simpleAdapter = SimpleAdapter(context, contentList, R.layout.share_item_cell,
                    arrayOf(IMAGE_KEY, TITLE_KEY), intArrayOf(R.id.share_item_cell_image, R.id.share_item_cell_title))
            val gridView = layout.findViewById<GridView>(R.id.gridView)
            gridView.numColumns = actionList.size
            gridView.adapter = simpleAdapter
            gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                dialog.cancel()
                val actionItem = actionList[position]
                actionItem.mCallBack.actionCallBack()
            }
            dialog.setContentView(layout)
            dialog.setCanceledOnTouchOutside(true)
            dialog.window!!.attributes.windowAnimations = R.style.DialogAnimationSlideBottom
            dialog.window!!.setGravity(Gravity.BOTTOM)
            val params = dialog.window!!.attributes
            params.width = DeviceUtils.getWidth(context)
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            dialog.window!!.attributes = params
            dialog.show()
            return dialog
        }
    }


}
