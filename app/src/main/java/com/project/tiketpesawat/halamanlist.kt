package com.project.tiketpesawat

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tiketpesawat.recycle.OSandroid
import com.project.tiketpesawat.recycle.androidadapter
import com.project.tiketpesawat.recycle.datagambar

class halamanlist : AppCompatActivity(),androidadapter.MyClickListener {

    private lateinit var rcvosandroid:RecyclerView
    private var list: ArrayList<OSandroid> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halamanlist)

        val btnback1 = findViewById<ImageView>(R.id.btn_back1)
        btnback1.setOnClickListener{
            finish()
        }

        rcvosandroid = findViewById(R.id.gambar)
        rcvosandroid.setHasFixedSize(true)

        list.addAll(datagambar.listData)
        showRecycler()

    }
    private fun showRecycler(){
        rcvosandroid.layoutManager = LinearLayoutManager(this)
        rcvosandroid.adapter = androidadapter(list, this@halamanlist)
    }

    override fun onClick(position: Int) {
        when(position){
            0 -> {
                val intent = Intent(this, pesantiket::class.java)
                startActivity(intent)
            }
            1 -> {
                val intent = Intent(this, pesantiket::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, pesantiket::class.java)
                startActivity(intent)
            }
            3 -> {
                val intent = Intent(this, pesantiket::class.java)
                startActivity(intent)
            }
            4 -> {
                val intent = Intent(this, pesantiket::class.java)
                startActivity(intent)
            }
            5 -> {
                val intent = Intent(this, pesantiket::class.java)
                startActivity(intent)
            }
            6 -> {
                val intent = Intent(this, pesantiket::class.java)
                startActivity(intent)
            }
        }
    }

}