package com.example.tms.FiveHW

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms.FiveHW.CoffeeStore.coffeeCollection
import com.example.tms.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_show_collection.*

class ShowCollectionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (coffee in coffeeCollection){
           addItem(coffee)
        }
    }
    private fun addItem(coffee: Coffee) {
        val viewManager = LinearLayoutManager(context)
        val viewAdapter = MyAdapter()
        recycleView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter=viewAdapter
        }

    }


}