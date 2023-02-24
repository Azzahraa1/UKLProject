package com.example.uklproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class GridSepatuAdapter (private val listSepatu: ArrayList<Sepatu>)
    :RecyclerView.Adapter<GridSepatuAdapter.GridViewHolder>(){
    class GridViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.nama)
        var tvHarga: TextView = itemView.findViewById(R.id.harga)
        var imgPhoto: ImageView= itemView.findViewById(R.id.gridsepatu)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
            val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_sepatu,viewGroup, false)
            return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val (name, harga, photo) = listSepatu[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvHarga.text = harga
        holder.itemView.setOnClickListener{ Toast.makeText(holder.itemView.context,"Kamu Memilih "+listSepatu[position].name, Toast.LENGTH_SHORT).show() }


        }

    override fun getItemCount(): Int {
        return listSepatu.size
    }


}


