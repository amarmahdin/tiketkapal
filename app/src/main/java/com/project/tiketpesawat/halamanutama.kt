package com.project.tiketpesawat

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class halamanutama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halamanutama)

        // Program Login
        val output = findViewById<TextView>(R.id.usernamehl)
        val message = intent.getStringExtra("NAMA")
        output.text = message

        // Program Logout
        val btnlogout = findViewById<ImageView>(R.id.btn_logout)

        btnlogout.setOnClickListener {
            Toast.makeText(this, "Logout Succesful", Toast.LENGTH_SHORT).show()
            val logout_intent = Intent(this@halamanutama, MainActivity::class.java)
            startActivity(logout_intent)
            finish()
        }

        // Program Info
        val btninfo = findViewById<ImageView>(R.id.btn_info)

        btninfo.setOnClickListener{
            val info_intent = Intent(this@halamanutama, info::class.java).apply{

            }
            startActivity(info_intent)
        }

        // Program Inbox
        val btninbox = findViewById<ImageView>(R.id.btn_inbox)

        btninbox.setOnClickListener{
            val inbox_intent = Intent(this@halamanutama, inbox::class.java).apply{

            }
            startActivity(inbox_intent)
        }

        val btnticket = findViewById<ImageView>(R.id.btn_ticket)

        btnticket.setOnClickListener{
            val ticket_intent = Intent(this@halamanutama, halamanlist::class.java).apply{

            }
            startActivity(ticket_intent)
        }
    }
}
