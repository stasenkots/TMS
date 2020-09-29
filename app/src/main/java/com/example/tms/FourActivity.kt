package com.example.tms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tms.countries.*
import kotlinx.android.synthetic.main.activity_four.*
import kotlinx.coroutines.InternalCoroutinesApi

class FourActivity : AppCompatActivity() {
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)
        val viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        val layoutsToCountries= mapOf(
            minsk_country_layout to viewModel.countries["MinskCountry"],
            brest_country_layout to viewModel.countries["BrestCountry"],
            gomel_country_layout to viewModel.countries["GomelCountry"],
            grondo_country_layout to viewModel.countries["GrodnoCountry"]
            )
        button_start.setOnClickListener {
            for ((layout,country) in  layoutsToCountries){
                setObserver(layout,country)
            }
            viewModel.winner.observe(this, Observer {winnerData->
                Toast.makeText(this, "${winnerData.name} is winner", Toast.LENGTH_LONG).show()
            })
            button_start.isEnabled = false
            button_start.visibility =View.GONE
            viewModel.findWinnerInReapingCrop()
        }

    }
    private fun setObserver(layout: LinearLayout,country: Country?) {
        for (textView in layout.children) {
            textView as TextView
            when (textView.text.toString().substringBefore(" ")) {
                "potato" -> country?.potato?.observe(this, Observer { potatoData ->
                    textView.text = "potato - $potatoData"
                })
                "cabbage" -> country?.cabbage?.observe(this, Observer { cabbageData ->
                    textView.text = "cabbage - $cabbageData"
                })
                "beet" -> country?.beet?.observe(this, Observer { beetData ->
                    textView.text = "beet - $beetData"
                })
            }

        }
    }
}
