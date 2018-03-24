package com.liuxi.encounter.base

/**
 * Created by liuxi on 2018/3/24.
 */
abstract class ContractImpl {
    interface View : ViewImpl<Presenter> {

    }

    interface Presenter : PresenterImpl {

    }

    interface Model : ModelImpl<Presenter> {

    }

}