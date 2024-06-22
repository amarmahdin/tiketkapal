package com.project.tiketpesawat

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class inbox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inbox)

        val btnback5 = findViewById<ImageView>(R.id.btn_back5)
        btnback5.setOnClickListener{
            finish()
        }
    }
}