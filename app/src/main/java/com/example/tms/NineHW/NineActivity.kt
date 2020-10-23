package com.example.tms.NineHW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms.NineHW.mappers.map
import com.example.tms.NineHW.recycle.Adapter
import com.example.tms.NineHW.retrofit.RetrofitFactory
import com.example.tms.R
import com.example.tms.launchIO
import com.example.tms.launchUI
import kotlinx.android.synthetic.main.activity_nine.*

class NineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine)
        val retrofit = RetrofitFactory().getRetrofit()
        launchIO {
            val response = retrofit.getCryptoCurrenciesAsync().await()
            if (response.isSuccessful) {
                val cryptoCurrencies = response.body()?.data?.map { map(it) }
                launchUI {
                    recycleView_crypto_currency.adapter = Adapter(cryptoCurrencies ?: listOf())
                    recycleView_crypto_currency.layoutManager = LinearLayoutManager(this)
                    progressBar_nine_hw.visibility = View.GONE
                    recycleView_crypto_currency.visibility = View.VISIBLE
                }
            }
            else{
                launchUI {
                    Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
