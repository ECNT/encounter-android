package com.liuxi.encounter.contract

import com.liuxi.encounter.base.mvp.ContractImpl

/**
 * Created by liuxi on 2018/3/24.
 */
class MainContract : ContractImpl {

    interface Presenter : ContractImpl.Presenter<View, Model> {

    }

    interface Model : ContractImpl.Model<Presenter> {

    }


    interface View : ContractImpl.View<Presenter> {

    }

}