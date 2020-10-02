package com.example.tms.FiveHW

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_add_coffee.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.add_coffee)
        }
        button_show_collection.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.show_collection)
        }
    }
}
