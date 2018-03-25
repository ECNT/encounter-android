package com.liuxi.encounter.view.activity

import android.animation.Animator
import android.os.Bundle
import com.liuxi.encounter.R
import com.liuxi.encounter.base.BaseActivity
import com.liuxi.encounter.contract.LaunchContract
import com.liuxi.encounter.presenter.LaunchPresenter
import kotlinx.android.synthetic.main.activity_launch.*

/**
 * Created by liuxi on 2018/3/22.
 */
class LaunchActivity : BaseActivity(), LaunchContract.View {

    private lateinit var mPresenter: LaunchContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        var presenter = LaunchPresenter()
        presenter.setView(this)
        setPresenter(presenter)
        mPresenter.start()
    }

    override fun setPresenter(presenter: LaunchContract.Presenter) {
        mPresenter = presenter
    }

    /**
     * 用户引导
     */
    override fun showGuide() {


    }

    /**
     * 启动动画
     */
    override fun startAnim() {

        animationView.setAnimation("animation1.json")
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                mPresenter.jump(this@LaunchActivity)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {

            }

        })
        animationView.loop(false)
        animationView.playAnimation()
    }
}