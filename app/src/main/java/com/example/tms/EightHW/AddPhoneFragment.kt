package com.example.tms.EightHW

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.tms.R
import kotlinx.android.synthetic.main.fragment_add_phone.*



class AddPhoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val editTextLayouts = listOf(editLayout_model, editLayout_os, editLayout_price)
        val editTexts = listOf(editText_model, editText_os, editText_price)
        for ((i, editTextItem) in editTexts.withIndex()) {
            editTextItem?.addTextChangedListener {
                if (editTextItem.text.isNullOrEmpty())
                    editTextLayouts[i].error = "This flied must not be empty"
                else editTextLayouts[i].error = null
            }
        }
    }
}