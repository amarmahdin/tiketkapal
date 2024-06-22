package com.project.tiketpesawat

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.tiketpesawat.adapter.UserAdapter
import com.project.tiketpesawat.data.AppDatabase
import com.project.tiketpesawat.data.entity.User

class info : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val btnback4 = findViewById<ImageView>(R.id.btn_back4)
        btnback4.setOnClickListener{
            finish()
        }

        recyclerView = findViewById(R.id.list_penumpang)
        fab = findViewById(R.id.fab)

        database = AppDatabase.getInstance(applicationContext)
        adapter = UserAdapter(list)
        adapter.setDialog(object : UserAdapter.Dialog {

            override fun onClick(position: Int) {
                val dialog = AlertDialog.Builder(this@info)
                dialog.setTitle(list[position].namapenumpang)
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener{dialog, which ->
                    if (which==0){
                        // Coding Ubah
                        val intent = Intent(this@info, pesantiket::class.java)
                        intent.putExtra("id", list[position].uid)
                        startActivity(intent)
                    }else if (which==1){
                        // Coding Hapus
                        database.UserDao().delete(list[position])
                        getdata()
                    } else {
                        // Coding Batal
                        dialog.dismiss()
                    }
                })
                val dialogView = dialog.create()
                dialogView.show()
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, RecyclerView.VERTICAL))

        fab.setOnClickListener{
            startActivity(Intent(this, pesantiket::class.java))
        }
        }

        override fun onResume() {
            super.onResume()
            getdata()
        }

        @SuppressLint("NotifyDataSetChange")
        fun getdata(){
            list.clear()
            list.addAll(database.UserDao().getAll())
            adapter.notifyDataSetChanged()
        }
    }

