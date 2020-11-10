package com.example.tms.TenHW

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import com.example.tms.R
import com.example.tms.launchAsync
import com.example.tms.launchIO
import kotlinx.android.synthetic.main.notification_layout.*
import kotlinx.coroutines.*
const val DURATION="duration"
class TenActivity : AppCompatActivity(){
    private lateinit var timePicker:TimePicker

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ten)
        val buttonStart=findViewById<Button>(R.id.button_hwten_start)
        timePicker=findViewById(R.id.timePicker_hwten)
        timePicker.setIs24HourView(true)
        timePicker.minute=0
        timePicker.hour=0
        val intent= Intent(this,TimerService::class.java)
        buttonStart.setOnClickListener {
            val duration=timePicker.hour*60+timePicker.minute
            intent.putExtra(DURATION,duration)
            startService(intent)
        }
    }


}