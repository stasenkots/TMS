package com.example.tms.EightHW

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tms.EightHW.CollectionPhones.phones
import com.example.tms.EightHW.CollectionPhones.wasUpdated
import com.example.tms.EightHW.Database.PhoneDB
import com.example.tms.EightHW.Database.entity.Phone
import com.example.tms.EightHW.Database.launchIO
import com.example.tms.EightHW.Database.launchUI
import com.example.tms.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_add_phone.*
import kotlinx.android.synthetic.main.fragment_list_phones.*
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
        val addPhoneFragment = AddPhoneFragment()
        val recyclePhoneFragment = RecyclePhonesFragment()
        val dao = context?.let { PhoneDB.getDataBase(it).phoneDao() }
        button_add_phone.setOnClickListener {
            val editTextLayouts = listOf(editLayout_model, editLayout_os, editLayout_price)
            val editTexts = listOf(editText_model, editText_os, editText_price)
            if (!switchFragment(addPhoneFragment) && validateTextFields(
                    editTexts,
                    editTextLayouts
                )
            ) {
                wasUpdated = true
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
        button_show_phones.setOnClickListener {
            switchFragment(recyclePhoneFragment)
        }
        button_clear_phones.setOnClickListener {
            launchIO {
                dao?.clearPhones()
                wasUpdated = true
                launchUI {
                    Toast.makeText(context, "Phones was cleared", Toast.LENGTH_SHORT).show()
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

    private fun switchFragment(fragment: Fragment): Boolean {
        return if (childFragmentManager.fragments.isEmpty() || (childFragmentManager.fragments[0]::class
                    != fragment::class)
        ) {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            true
        } else false
    }

}