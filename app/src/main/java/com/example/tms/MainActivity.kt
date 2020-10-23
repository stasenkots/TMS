package com.example.tms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tms.EightHW.EightActivity
import com.example.tms.FiveHW.FiveActivity
import com.example.tms.NineHW.NineActivity
import com.example.tms.SevenHW.SevenActivity
import com.example.tms.SixHW.SixActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            val intent= Intent(this,MyFirstAppActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent= Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent= Intent(this,FourActivity::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent= Intent(this, FiveActivity::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent= Intent(this, SixActivity::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            val intent= Intent(this, SevenActivity::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent= Intent(this, EightActivity::class.java)
            startActivity(intent)
        }
        button9.setOnClickListener {
            val intent= Intent(this, NineActivity::class.java)
            startActivity(intent)
        }

    }
}