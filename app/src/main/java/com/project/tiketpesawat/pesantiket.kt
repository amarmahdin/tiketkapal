package com.project.tiketpesawat

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.tiketpesawat.data.AppDatabase
import com.project.tiketpesawat.data.entity.User
import java.text.SimpleDateFormat
import java.util.*

class pesantiket : AppCompatActivity() {

    private lateinit var namapenumpang: EditText
    private lateinit var Keberangkatan: EditText
    private lateinit var Tujuan: EditText
    private lateinit var Tglberangkat: EditText
    private lateinit var Wktberangkat: EditText
    private lateinit var btnpesan: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesantiket)

        val btnback2 = findViewById<ImageView>(R.id.btn_back2)
        btnback2.setOnClickListener{
            finish()
        }

        namapenumpang = findViewById(R.id.nama_penumpang)
        Keberangkatan = findViewById(R.id.keberangkatan)
        Tujuan = findViewById(R.id.tujuan)
        Tglberangkat = findViewById(R.id.tgl_berangkat)
        Wktberangkat = findViewById(R.id.wkt_berangkat)
        btnpesan = findViewById(R.id.btn_pesan)

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayofmonth)
            upadateLable(myCalendar)
        }
        Tglberangkat.setOnClickListener{
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){
            val id = intent.getInt("id",0)
            val user = database.UserDao().get(id)

            namapenumpang.setText(user.namapenumpang)
            Keberangkatan.setText(user.Keberangkatan)
            Tujuan.setText(user.Tujuan)
            Tglberangkat.setText(user.Tglberangkat)
            Wktberangkat.setText(user.Wktberangkat)
        }

        btnpesan.setOnClickListener{
            if (namapenumpang.text.isNotEmpty() && Keberangkatan.text.isNotEmpty() && Tujuan.text.isNotEmpty() &&
                Tglberangkat.text.isNotEmpty() && Wktberangkat.text.isNotEmpty()) {
                if (intent!=null){
                    database.UserDao().update(
                        // Coding Edit Data
                        User(
                            intent.getInt("id",0),
                            namapenumpang.text.toString(),
                            Keberangkatan.text.toString(),
                            Tujuan.text.toString(),
                            Tglberangkat.text.toString(),
                            Wktberangkat.text.toString()
                        )
                    )
                }else {
                    // Coding tambah data
                    database.UserDao().insertAll(
                        User(
                            null,
                            namapenumpang.text.toString(),
                            Keberangkatan.text.toString(),
                            Tujuan.text.toString(),
                            Tglberangkat.text.toString(),
                            Wktberangkat.text.toString()
                        )
                    )
                }
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Silahkan isi semua data yang valid",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    private fun upadateLable(mycalander: Calendar){
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        Tglberangkat.setText(sdf.format(mycalander.time))
    }
}