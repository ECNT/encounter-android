package com.liuxi.encounter.base.mvp

/**
 * base model
 *
 * Created by liuxi on 2018/3/24.
 */
interface ModelImpl<in T> {

    fun setPresenter(presenter: T)

}