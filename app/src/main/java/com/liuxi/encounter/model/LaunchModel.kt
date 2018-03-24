package com.liuxi.encounter.model

import com.liuxi.encounter.contract.LaunchContract

/**
 * Created by liuxi on 2018/3/24.
 */
class LaunchModel : LaunchContract.Model {

    private var presenter: LaunchContract.Presenter? = null

    override fun setPresenter(presenter: LaunchContract.Presenter) {
        this.presenter = presenter
    }

    override fun needShowGuide(): Boolean {
        return true
    }

    override fun setNeedShowGuide(isShow: Boolean) {

    }

    override fun isNeedLogin(): Boolean {
        return true
    }
}
