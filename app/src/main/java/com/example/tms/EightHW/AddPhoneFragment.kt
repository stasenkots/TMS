package com.example.tms.EightHW

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.tms.EightHW.Database.PhoneDB
import com.example.tms.EightHW.Database.entity.Phone
import com.example.tms.EightHW.Database.launchIO
import com.example.tms.EightHW.Database.launchUI
import com.example.tms.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
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
                    editTextLayouts[i].error = "This flield must not be empty"
                else editTextLayouts[i].error = null
            }
        }
        button_add_phone.setOnClickListener {
            val dao = context?.let { PhoneDB.getDataBase(it).phoneDao() }
            if (validateTextFields(editTexts, editTextLayouts)) {
                val phone = Phone(
                    editText_model.text.toString(),
                    editText_os.text.toString(),
                    editText_price.text.toString().toDouble()
                )
                launchIO {
                    try {
                        dao?.insertPhone(phone)
                        launchUI {
                            Toast.makeText(context, "Phone was added", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: SQLiteConstraintException) {
                        launchUI {
                            Toast.makeText(
                                context,
                                "This phone already in list",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
                for (editTextItem in editTexts) {
                    editTextItem.setText("")
                }
            }
        }
    }

    private fun validateTextFields(
        editTexts: List<TextInputEditText?>,
        editTextLayouts: List<TextInputLayout?>
    ): Boolean {
        for ((i, editText) in editTexts.withIndex()) {
            if (editText?.text.isNullOrEmpty()) {
                editTextLayouts[i]?.error = "This field must not be empty"
                return false
            }
        }
        return true
    }
}