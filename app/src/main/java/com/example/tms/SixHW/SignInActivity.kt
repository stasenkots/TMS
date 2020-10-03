package com.example.tms.SixHW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tms.R
import kotlinx.android.synthetic.main.activity_my_first_app.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val login=intent.getStringExtra("login")
        textView_sixhw.text="Hello $login"
    }
}