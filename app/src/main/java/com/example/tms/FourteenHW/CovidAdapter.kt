package com.example.tms.FourteenHW

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

import com.example.tms.FourteenHW.entity.Country
import com.example.tms.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_covid.view.*

class CovidAdapter(private val list:List<Country?>) : RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

    class CovidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.item_covid_name
        private val date = itemView.item_covid_date
        private val flag = itemView.item_covid_flag
        private val totalRecovered = itemView.item_covid_recovered
        private val totalConfirmed = itemView.item_covid_confirmed
        private val totalDeath = itemView.item_covid_death
        fun bind(country: Country) {
            name.text = country.country
            date.text = country.date
            totalRecovered.text = "Recovered:"+country.totalRecovered.toString()
            totalConfirmed.text="Confirmed:"+country.totalConfirmed.toString()
            totalDeath.text="Death: "+country.totalDeaths.toString()
            Picasso.get().load(country.flagUrl).into(flag)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid, parent,false)
        return CovidViewHolder(view)

    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        list[position]?.let { holder.bind(it) }
    }
}