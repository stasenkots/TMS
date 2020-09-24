package com.example.tms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        buttonFlag.setOnClickListener {
            val intent= Intent(this,FlagsActivity::class.java)
            startActivity(intent)
        }
        buttonAnimation.setOnClickListener {
            val intent= Intent(this,Animation::class.java)
            startActivity(intent)

        }
    }
}