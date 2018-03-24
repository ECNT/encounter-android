package com.liuxi.encounter.contract

import android.content.Context
import com.liuxi.encounter.base.mvp.ContractImpl

/**
 * Created by liuxi on 2018/3/24.
 */
class LaunchContract : ContractImpl {

    interface View : ContractImpl.View<Presenter> {

        fun showGuide()

        fun startAnim()
    }

    interface Model : ContractImpl.Model<Presenter> {

        fun needShowGuide(): Boolean

        fun setNeedShowGuide(isShow: Boolean)

        fun isNeedLogin(): Boolean

    }

    interface Presenter : ContractImpl.Presenter<View, Model> {

        fun jump(context: Context)

    }

}