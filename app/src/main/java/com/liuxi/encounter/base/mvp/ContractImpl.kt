package com.liuxi.encounter.base.mvp

/**
 *
 * mvp standard
 *
 * Created by liuxi on 2018/3/24.
 */
interface ContractImpl {

    /**
     * all view need implement this interface
     */
    interface View : ViewImpl<Presenter> {

    }

    /**
     * all Presenter need implement this interface
     */
    interface Presenter : PresenterImpl<View, Model> {

    }

    /**
     * all Model/Data need implement this interface
     */
    interface Model : ModelImpl<Presenter> {

    }

}