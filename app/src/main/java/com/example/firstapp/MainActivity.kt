package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val userEmail = intent.getStringExtra("user_email")
        if (userEmail != null) {
            val userName = parseEmailToName(userEmail)
            displayUserName(userName)
        }
    }

    private fun displayUserName(userName: Any) {
        val userNameTextView: TextView = findViewById(R.id.llName)
        userNameTextView.text = userName.toString()
    }

    private fun parseEmailToName(userEmail: String): Any {
        val parts = userEmail.split("@")[0].split(".")
        return parts.joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
    }
}