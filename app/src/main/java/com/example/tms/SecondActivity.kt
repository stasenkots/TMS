package com.example.tms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        buttonLoad.setOnClickListener {
            val url: String = editText.text.toString()
            if (url.isNotEmpty()) {
                Picasso.get().load(url).into(image)
            }
        }
    }
}