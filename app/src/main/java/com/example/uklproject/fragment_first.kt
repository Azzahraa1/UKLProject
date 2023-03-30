package com.example.uklproject

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class fragment_first : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null
    private lateinit var tvDatePicker : TextInputLayout
    private lateinit var btnDatePicker : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        communicationViewModel =
            ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
        nameEditText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence?,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
                    communicationViewModel!!.setName(charSequence.toString())
                }

                override fun afterTextChanged(editable: Editable?) {

                }
            }
        )

        val EmailEditText = view.findViewById<TextInputEditText>(R.id.textInputTextEmail)
        EmailEditText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence?,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
                    communicationViewModel!!.setEmail(charSequence.toString())
                }

                override fun afterTextChanged(editable: Editable?) {

                }
            }
        )

        val PassEditText = view.findViewById<TextInputEditText>(R.id.textInputTextPassword)
        PassEditText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence?,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
                    communicationViewModel!!.setPassword(charSequence.toString())
                }

                override fun afterTextChanged(editable: Editable?) {

                }
            }
        )

//        tvDatePicker = view.findViewById(R.id.textInputTextTglLahir)
//        btnDatePicker = view.findViewById(R.id.btnTglLhir)
//
//        val myCalendar = Calendar.getInstance()
//        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->
//            myCalendar.set(Calendar.YEAR, year)
//            myCalendar.set(Calendar.MONTH, month)
//            myCalendar.set(Calendar.DAY_OF_MONTH, dayofmonth)
//            updateLabel(myCalendar)
//        }
//        btnDatePicker.setOnClickListener {
//                DatePickerDialog(requireActivity(), datePicker, myCalendar.get(Calendar.YEAR),
//                myCalendar.get(Calendar.MONTH),
//                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
//        }
//    }
//    private fun updateLabel(mycalendar : Calendar){
//        val myformat = "dd-MM-yyyy"
//        val sdf = SimpleDateFormat(myformat, Locale.UK)
//        tvDatePicker.editText?.setText(sdf.format(mycalendar.time))
//    }


    }
    companion object {
        fun newInstance(): fragment_first{
            return fragment_first()
        }
    }
}