package com.example.layoutandroid

import android.graphics.drawable.AnimationDrawable
import android.view.View

private lateinit var rocketAnimation : AnimationDrawable

class AnimationApply {

    companion object{

        @JvmStatic
        fun animationBackground(view : View,resource : Int){
            view.apply {
                setBackgroundResource(resource)
                rocketAnimation = background as AnimationDrawable
            }
            view.setOnClickListener { rocketAnimation.start() }
        }
    }

}