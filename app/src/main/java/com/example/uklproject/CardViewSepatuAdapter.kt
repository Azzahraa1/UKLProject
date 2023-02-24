package com.example.uklproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewSepatuAdapter (private val listSepatu: ArrayList<Sepatu>)
    : RecyclerView.Adapter<CardViewSepatuAdapter.CardViewHolder>(){
    class CardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
         var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_harga)
        var btnFav: Button = itemView.findViewById(R.id.btn_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_share)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_sepatu, parent,false)
             return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (name, harga, photo) = listSepatu[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvHarga.text = harga
        holder.btnFav.setOnClickListener { Toast.makeText(holder.itemView.context,"Favorite "+listSepatu[position].name, Toast.LENGTH_SHORT).show()
        holder.btnShare.setOnClickListener { Toast.makeText(holder.itemView.context,"Share "+listSepatu[position].name,Toast.LENGTH_SHORT).show()
            holder.itemView.setOnClickListener{ Toast.makeText(holder.itemView.context,"Kamu Memilih "+listSepatu[position].name, Toast.LENGTH_SHORT).show() }

        }
        }



    }

    override fun getItemCount(): Int {
        return listSepatu.size
}}