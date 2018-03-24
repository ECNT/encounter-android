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
    interface View<in T> {
        fun setPresenter(presenter: T)
    }

    /**
     * T1->View  T2->Model
     * all Presenter need implement this interface
     */
    interface Presenter<in T1, in T2> {
        fun start()

        fun setView(view: T1)

        fun setModel(model: T2)
    }

    /**
     * all Model/Data need implement this interface
     */
    interface Model<in T> {
        fun setPresenter(presenter: T)
    }

}