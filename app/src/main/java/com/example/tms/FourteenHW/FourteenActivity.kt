package com.example.tms.FourteenHW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tms.R

class FourteenActivity : AppCompatActivity() {


    private lateinit var viewModel:CovidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourteen)
        viewModel=ViewModelProvider(this).get(CovidViewModel::class.java)
        val processBar=findViewById<ProgressBar>(R.id.fourteen_activity_progressBar)
        viewModel.getListCounties()
        viewModel.listCountries.observe(this) {
            Log.e("AAA", it.size.toString())
            val recyclerView = findViewById<RecyclerView>(R.id.recycle_covid)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@FourteenActivity)
                adapter = CovidAdapter(it)
                hasFixedSize()
                visibility = View.VISIBLE
            }
            processBar.visibility = View.GONE
        }
    }

    override fun onStop() {
       viewModel.compositeDisposable.dispose()
        super.onStop()
    }
}
