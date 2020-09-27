package com.example.tms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tms.countries.*
import kotlinx.android.synthetic.main.activity_four.*

class FourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)
        val viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        button_start.setOnClickListener {
            setObserver(MinskCountry,minsk_country_layout)
            setObserver(BrestCountry,brest_country_layout)
            setObserver(GrodnoCountry,grondo_country_layout)
            setObserver(GomelCountry,gomel_country_layout)
            viewModel.winner.observe(this, Observer {winnerData->
                Toast.makeText(this, "${winnerData.name} is winner", Toast.LENGTH_LONG).show()
            })
            button_start.isEnabled = false
            button_start.isVisible = false
            viewModel.findWinnerInReapingCrop()
        }

    }
    private fun setObserver(country: Country, layout: LinearLayout) {
        for (textView in layout.children) {
            textView as TextView
            when (textView.text.toString().substringBefore(" ")) {
                "potato" -> country.potato.observe(this, Observer { potatoData ->
                    textView.text = "potato - $potatoData"
                })
                "cabbage" -> country.cabbage.observe(this, Observer { cabbageData ->
                    textView.text = "cabbage - $cabbageData"
                })
                "beet" -> country.beet.observe(this, Observer { beetData ->
                    textView.text = "beet - $beetData"
                })
            }

        }
    }
}
