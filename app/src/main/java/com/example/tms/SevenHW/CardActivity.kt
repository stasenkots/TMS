package com.example.tms.SevenHW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.tms.R
import kotlinx.android.synthetic.main.activity_card.*

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        overridePendingTransition(R.anim.enter,R.anim.exit)
        YoYo.with(Techniques.ZoomIn)
            .duration(20000)
            .playOn(imageView_cats)
        YoYo.with(Techniques.Wave)
            .duration(20000)
            .playOn(textView_happy_mothers_day)
    }
}