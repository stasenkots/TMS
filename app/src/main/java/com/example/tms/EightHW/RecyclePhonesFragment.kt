package com.example.tms.EightHW

import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.tms.EightHW.CollectionPhones.phones
import com.example.tms.R
import kotlinx.android.synthetic.main.fragment_list_phones.*

class RecyclePhonesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_phones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            with(recycleView_phones) {
                layoutManager = LinearLayoutManager(context)
                adapter = Adapter(phones)
            }
            editText_search_phone.addTextChangedListener{
                recycleView_phones.adapter=Adapter(phones.filter {
                    it.model.contains(editText_search_phone.text.toString())
                })
            }
        }

    }


