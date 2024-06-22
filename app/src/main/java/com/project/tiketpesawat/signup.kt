package com.project.tiketpesawat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Database
import com.project.tiketpesawat.databinding.ActivitySignupBinding

class signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var databasesign: databasesign

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databasesign = databasesign(this)

        binding.signupButton.setOnClickListener{
            val signuser = binding.signuser.text.toString()
            val signpass = binding.signpass.text.toString()
            signupDatabase(signuser, signpass)
        }

        binding.loginRedirect.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signupDatabase(username: String, passwoard: String){
        val insertedRowId = databasesign.insertUser(username, passwoard)
        if (insertedRowId != -1L){
            Toast.makeText(this, "Signup Succesful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }
}