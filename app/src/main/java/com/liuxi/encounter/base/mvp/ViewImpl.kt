package com.liuxi.encounter.base.mvp

/**
 *
 * base view
 *
 * Created by liuxi on 2018/3/24.
 */
interface ViewImpl<in T> {

    fun setPresenter(presenter: T)

}