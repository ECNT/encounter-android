package com.liuxi.encounter.base.mvp

/**
 * base presenter
 *
 * Created by liuxi on 2018/3/24.
 */

interface PresenterImpl<in T1, in T2> {

    fun start()

    fun setView(view: T1)

    fun setModel(model: T2)
}