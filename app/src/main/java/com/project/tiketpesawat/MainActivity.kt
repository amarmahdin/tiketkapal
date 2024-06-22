package com.project.tiketpesawat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.project.tiketpesawat.databinding.ActivityLoginBinding
import com.project.tiketpesawat.databinding.ActivitySignupBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databasesign: databasesign

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databasesign = databasesign(this)

        binding.loginButton.setOnClickListener{
            val loginuser = binding.loginuser.text.toString()
            val loginpass = binding.loginpass.text.toString()
            loginDatabase(loginuser, loginpass)
        }
        binding.signupRedirect.setOnClickListener{
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loginDatabase(username: String, password: String){
        val userExists = databasesign.readUser(username, password)
        if (userExists){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, halamanutama::class.java).apply {
                putExtra("NAMA", username)
            }
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}