package com.example.tms

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animation.*

class Animation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        imageAnimation.setBackgroundResource(R.drawable.animation)
        val animation = imageAnimation.background as AnimationDrawable
        buttonStart.setOnClickListener {
            animation.start()
        }
        buttonStop.setOnClickListener {
            animation.stop()
        }

    }
}