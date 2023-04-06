package com.example.uklproject

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment_second : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null
    private var listMyRegister: RecyclerView?= null
    private var db : AppDataBase?= null
    private var myRegistDao : RegisterDao? = null
    private var listRegist: kotlin.collections.List<Register>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDb()
        initView()
//        txtName = view.findViewById(R.id.textViewName)
//        txtEmail = view.findViewById(R.id.textViewEmail)
//        communicationViewModel!!.name.observe(requireActivity(), Observer{ s ->txtName!!.text = s})
//        communicationViewModel!!.email.observe(requireActivity(), Observer{s ->txtEmail!!.text = s})
    }

    private fun initView(){
        listMyRegister = activity?.findViewById(R.id.listMyRegister)
        ambilData()
    }
    private fun ambilData(){
        listRegist = ArrayList()
        myRegistDao?.ambilData()?.observe(requireActivity()){
            r -> listRegist = r
            when{
                listRegist?.size == 0 -> tampilToast("Belum ada Data")
                else -> {
                    tampilData()
                }
            }
        }

    }
    private fun tampilData(){
        listMyRegister?.layoutManager = LinearLayoutManager(activity)
        listMyRegister?.adapter = RegisterAdapter(requireActivity(),listRegist!! as ArrayList<Register>)
    }
    private fun tampilToast(message:String){
        Toast.makeText(requireActivity(),message,Toast.LENGTH_SHORT).show()
    }

    private fun initLocalDb(){
        db = AppDataBase.getAppDataBase(requireActivity())
        myRegistDao = db?.myRegistDao()
    }



    companion object {

        fun newInstance(): fragment_second{
            return fragment_second()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listMyRegister = null
    }
}