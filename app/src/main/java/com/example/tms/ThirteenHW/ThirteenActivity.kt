package com.example.tms.ThirteenHW

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tms.R
import com.google.android.material.textfield.TextInputEditText

class ThirteenActivity : AppCompatActivity() {
    private val editText by lazy {
        findViewById<TextInputEditText>(R.id.inputText_fibonacci)
    }
    private val textView by lazy {
        findViewById<TextView>(R.id.textView_fibonacci)
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thriteen)
        findViewById<Button>(R.id.button_fibonacci).setOnClickListener {
            val index=
            if (editText.text.toString().isBlank())0
            else editText.text.toString().toInt()
            textView.text = Fibonacci.getNumber(index).toString()
        }


    }
}