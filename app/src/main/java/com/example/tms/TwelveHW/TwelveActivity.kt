package com.example.tms.TwelveHW

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toDrawable
import com.example.tms.R

class TwelveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twelve)
        val sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightManager=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        val textViewLightSensor=findViewById<TextView>(R.id.textView_light_sensor)
        sensorManager.registerListener(object :SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onSensorChanged(event: SensorEvent?) {
                val light=event?.values?.get(0)?:0.0f
               textViewLightSensor.text= getString(R.string.luxlights,light)
                if (light>=300.0f){
                    textViewLightSensor.background=resources.getColor(R.color.green,theme).toDrawable()
                }
                else{
                    textViewLightSensor.background=resources.getColor(R.color.red,theme).toDrawable()
                }
            }
        },lightManager,1)

    }
}