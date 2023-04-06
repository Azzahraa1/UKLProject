package com.example.uklproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RegisterAdapter(private val context: Context, private val items: ArrayList<Register>)
    :RecyclerView.Adapter<RegisterAdapter.ViewHolder>(){
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        private var txtName : TextView = itemView.findViewById(R.id.txtName)
        private var txtEmail : TextView =itemView.findViewById(R.id.txtEmail)
        private var txtTgl : TextView = itemView.findViewById(R.id.txtTgl)

        fun bindItem(item: Register){
            txtName.text = item.nama
            txtEmail.text = item.email
            txtTgl.text = item.tgllahir

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder (LayoutInflater.from(context).inflate(R.layout.register_item,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

}