package com.example.uklproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pass = findViewById<EditText>(R.id.password)
        val email = findViewById<EditText>(R.id.email)
        val btnLoginActivity = findViewById<Button>(R.id.btnLogin)

        btnLoginActivity.setOnClickListener {
            val strEmail = email.text.toString()
            val strPass = pass.text.toString()
            if (strEmail.isNotBlank()&& strPass.isNotBlank()){
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("email", strEmail)
                startActivity(intent)
            }

        }


    }
}