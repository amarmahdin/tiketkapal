package com.project.tiketpesawat.adapter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.tiketpesawat.R
import com.project.tiketpesawat.data.entity.User

class UserAdapter (var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog) {
        this.dialog = dialog
    }

    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var namapenumpang: TextView
        var Keberangkatan: TextView
        var Tujuan: TextView
        var Tglberangkat: TextView
        var Wktberangkat: TextView

        init {
            namapenumpang = view.findViewById(R.id.nama_penumpang)
            Keberangkatan = view.findViewById(R.id.keberangkatan)
            Tujuan = view.findViewById(R.id.tujuan)
            Tglberangkat = view.findViewById(R.id.tgl_berangkat)
            Wktberangkat = view.findViewById(R.id.wkt_berangkat)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_pesantiket, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.namapenumpang.text = list[position].namapenumpang
            holder.Keberangkatan.text = list[position].Keberangkatan
            holder.Tujuan.text = list[position].Tujuan
            holder.Tglberangkat.text = list[position].Tglberangkat
            holder.Wktberangkat.text = list[position].Wktberangkat
        }
    }
