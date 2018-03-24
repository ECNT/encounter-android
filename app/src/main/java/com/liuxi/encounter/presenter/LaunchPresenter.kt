package com.liuxi.encounter.presenter

import android.content.Context
import android.content.Intent
import com.liuxi.encounter.contract.LaunchContract
import com.liuxi.encounter.model.LaunchModel
import com.liuxi.encounter.view.activity.MainActivity

/**
 * Created by liuxi on 2018/3/24.
 */
class LaunchPresenter : LaunchContract.Presenter {
    private lateinit var mView: LaunchContract.View
    private lateinit var mModel: LaunchContract.Model

    init {
        mModel = LaunchModel()
    }

    override fun start() {
        if (mModel.needShowGuide()) {
            mView.showGuide()
            mView.startAnim()
            mModel.setNeedShowGuide(false)
        }
    }

    override fun setView(view: LaunchContract.View) {
        mView = view
    }

    override fun setModel(model: LaunchContract.Model) {
        mModel = model
    }

    /**
     * 前往首页
     */
    override fun jump(context: Context) {
        context.startActivity(Intent(context, MainActivity::class.java))
    }

}