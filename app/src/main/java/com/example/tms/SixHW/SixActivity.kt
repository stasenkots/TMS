package com.example.tms.SixHW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.tms.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_six.*


const val KEY_LOGIN="login"
class SixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six)
        editText_login.addTextChangedListener { login ->
            if (login.isNullOrEmpty())
                textInputLayout_login.error = getString(R.string.login_cannot_be_empty)
            else textInputLayout_login.error = null
            changeButtonIsEnabledProperty()
        }
        editText_password.addTextChangedListener { password ->
            if (password?.length ?: 0 < 8)
                textInputLayout_password.error =
                    getString(R.string.password_length_must_be_not_less_than_8_chars)
            else textInputLayout_password.error = null
            changeButtonIsEnabledProperty()

        }
        button_sign_up.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(resources.getString(R.string.sign_up))
                .setMessage(resources.getString(R.string.you_are_registered))
                .setNeutralButton(resources.getString(R.string.ok)) { _, _ ->

                }
                .setPositiveButton(resources.getString(R.string.sign_in)) { _, _ ->
                    val intent = Intent(this, SignInActivity::class.java)
                    intent.putExtra(KEY_LOGIN, editText_login.text.toString())
                    startActivity(intent)
                }
                .setIcon(R.drawable.login)
                .show()
        }
    }

    private fun changeButtonIsEnabledProperty(){
        button_sign_up.isEnabled = (
                textInputLayout_password.error==null
                && textInputLayout_login.error==null
                        && !editText_login.text.isNullOrEmpty()
                        && !editText_password.text.isNullOrEmpty()
                )
    }

}