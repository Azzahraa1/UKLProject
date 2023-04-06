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
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class fragment_first : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null
    lateinit var btnDate : Button

    private var namaInput : String =""
    private var emailInput : String =""
    private var passInput : String = ""
    private var tglInput : String =""

    private var btnSave : Button? = null
    private var edtName : TextInputEditText? = null
    private var edtEmail : TextInputEditText? = null
    private var edtPass : TextInputEditText? = null
    private var edtTgl : Button?= null


    private var db : AppDataBase? = null
    private var myRegisterDao : RegisterDao? = null

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
        initLocalDB()
        initView()

//        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
//        nameEditText.addTextChangedListener(
//            object : TextWatcher {
//                override fun beforeTextChanged(
//                    charSequence: CharSequence?,
//                    i: Int,
//                    i1: Int,
//                    i2: Int
//                ) {
//                }
//
//                override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
//                    communicationViewModel!!.setName(charSequence.toString())
//                }
//
//                override fun afterTextChanged(editable: Editable?) {
//
//                }
//            }
//        )
//
//        val EmailEditText = view.findViewById<TextInputEditText>(R.id.textInputTextEmail)
//        EmailEditText.addTextChangedListener(
//            object : TextWatcher {
//                override fun beforeTextChanged(
//                    charSequence: CharSequence?,
//                    i: Int,
//                    i1: Int,
//                    i2: Int
//                ) {
//                }
//
//                override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
//                    communicationViewModel!!.setEmail(charSequence.toString())
//                }
//
//                override fun afterTextChanged(editable: Editable?) {
//
//                }
//            }
//        )
//
//        val PassEditText = view.findViewById<TextInputEditText>(R.id.textInputTextPassword)
//        PassEditText.addTextChangedListener(
//            object : TextWatcher {
//                override fun beforeTextChanged(
//                    charSequence: CharSequence?,
//                    i: Int,
//                    i1: Int,
//                    i2: Int
//                ) {
//                }
//
//                override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
//                    communicationViewModel!!.setPassword(charSequence.toString())
//                }
//
//                override fun afterTextChanged(editable: Editable?) {
//
//                }
//            }
//        )

        btnDate = view.findViewById(R.id.btnDate)
        btnDate.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                btnDate.text = (dayOfMonth.toString()+"\t-\t"+(monthOfYear + 1)+"\t-\t"+year)},
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
    private fun initLocalDB(){
        db = AppDataBase.getAppDataBase(requireActivity())
        myRegisterDao = db?.myRegistDao()
    }

    private fun initView(){
        edtName = activity?.findViewById(R.id.textInputTextName)
        edtEmail = activity?.findViewById(R.id.textInputTextEmail)
        edtPass = activity?.findViewById(R.id.textInputTextPassword)
        edtTgl = activity?.findViewById(R.id.btnDate)
        btnSave = activity?.findViewById(R.id.btnSave)

        btnSave?.setOnClickListener {
            validasiInput()
        }
    }
    override fun onDestroy(){
        super.onDestroy()
//        db?.close()
        edtName = null
        edtEmail = null
        edtPass = null
        edtTgl = null
        btnSave = null
    }

    private fun validasiInput(){
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()
        passInput = edtPass?.text.toString()
        tglInput = edtTgl?.text.toString()

        when{
            namaInput.isEmpty()-> edtName?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty()->edtEmail?.error = "Email tidak boleh kosong"
            passInput.isEmpty()->edtPass?.error = "Password tidak boleh kosong"

            else-> {
                val register = Register(
                    nama = namaInput,
                    email = emailInput,
                    pass = passInput,
                    tgllahir = tglInput
                )
                tambahDataRegister(register)
                Toast.makeText(requireActivity(),"Data Di Simpan", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun tambahDataRegister(register: Register): Job {
        return GlobalScope.launch {
            myRegisterDao?.tambahRegister(register)
        }
    }
    companion object {
        fun newInstance(): fragment_first{
            return fragment_first()
        }
    }
}