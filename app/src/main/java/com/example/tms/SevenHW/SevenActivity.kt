package com.example.tms.SevenHW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.tms.R
import kotlinx.android.synthetic.main.activity_seven.*

class SevenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven)
        button_seven_activity.setOnClickListener {
            startActivity(Intent(this,CardActivity::class.java))
        }
    }
}