package com.liuxi.encounter.base

/**
 * Created by liuxi on 2018/3/24.
 */
interface ViewImpl<in T> {

    fun setPresenter(presenter: T)


}