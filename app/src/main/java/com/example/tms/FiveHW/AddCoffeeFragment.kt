package com.example.tms.FiveHW

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tms.FiveHW.CoffeeStore.coffeeCollection
import com.example.tms.R
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_add_coffee.*



class AddCoffeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_coffee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_create_coffee_item.setOnClickListener {
            if(
                editText_sort_of_coffee.text.isBlank()
                || editText_price_of_coffee.text.isBlank()
                || editText_image_url_of_coffee.text.isBlank()
            ){
                Toast.makeText(context, "Please,enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            coffeeCollection.add(Coffee(
                editText_sort_of_coffee.text.toString(),
                editText_price_of_coffee.text.toString().toDouble(),
                editText_image_url_of_coffee.text.toString()
            ))
            Toast.makeText(context, "Coffee added", Toast.LENGTH_SHORT).show()
            editText_sort_of_coffee.text.clear()
            editText_price_of_coffee.text.clear()
            editText_image_url_of_coffee.text.clear()

        }
    }

}