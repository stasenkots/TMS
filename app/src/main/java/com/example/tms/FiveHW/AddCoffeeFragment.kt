package com.example.tms.FiveHW

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tms.R
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_add_coffee.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddCoffeeFragment : Fragment() {


    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_coffee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_create_coffee_item.setOnClickListener {
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

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddCoffeeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}