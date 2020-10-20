package com.example.tms.EightHW

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms.EightHW.CollectionPhones.phones
import com.example.tms.EightHW.Database.PhoneDB
import com.example.tms.EightHW.Database.launchIO
import com.example.tms.EightHW.Database.launchUI
import com.example.tms.R
import kotlinx.android.synthetic.main.fragment_show_phones.*


class RecyclePhonesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_phones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = context?.let { PhoneDB.getDataBase(it).phoneDao() }
        launchIO {
            phones = dao?.getAllPhones() ?: listOf()
        }
        with(recycleView_phones) {
            layoutManager = LinearLayoutManager(context)
            adapter = Adapter(phones)
        }
        editText_search_phone.addTextChangedListener {
            recycleView_phones.adapter = Adapter(phones.filter {
                it.model.contains(editText_search_phone.text.toString())
            })
        }
        button_clear_phones.setOnClickListener {
            launchIO {
                dao?.clearPhones()
                launchUI {
                    findNavController().popBackStack()
                    Toast.makeText(context, "Phones was cleared", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

    }

}



