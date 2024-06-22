package com.project.tiketpesawat.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.tiketpesawat.R

class androidadapter (val listOS: ArrayList<OSandroid>, val listener: MyClickListener) : RecyclerView.Adapter<androidadapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameplane: TextView = itemView.findViewById(R.id.nameplane)
        var imgplane: ImageView = itemView.findViewById(R.id.imgplane)
        var price: TextView = itemView.findViewById(R.id.price)
        var point:TextView = itemView.findViewById(R.id.point)

        init {
            itemView.setOnClickListener{
                val position = adapterPosition
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ListViewHolder(View)
    }

    override fun getItemCount(): Int {
        return listOS.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listOS = listOS[position]
        Glide.with(holder.itemView.context)
            .load(listOS.Imgplane)
            .apply(RequestOptions().override(50,50))
            .into(holder.imgplane)

        holder.nameplane.text = listOS.Nameplane
        holder.price.text = listOS.Price
        holder.point.text = listOS.Point
    }

    interface MyClickListener{
        fun onClick(position: Int)
    }
}

