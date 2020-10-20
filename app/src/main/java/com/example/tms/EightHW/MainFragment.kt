package com.example.tms.EightHW


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_to_add_phone_fragment.setOnClickListener {
           val nav=findNavController()
            nav.navigate(R.id.action_fragment_main_to_fragment_add_phone)

        }
        button_to_show_phones_fragment.setOnClickListener {
           val nav=findNavController()
            nav.navigate(R.id.action_fragment_main_to_fragment_show_phones)

        }


    }






}