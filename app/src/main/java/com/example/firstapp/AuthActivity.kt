package com.example.firstapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class AuthActivity : AppCompatActivity() {

    private val preferenceManager by lazy { SharedPreferenceManager(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
//        auto login
//       if (preferenceManager.getLogin().isNotBlank()) {
//            val email = preferenceManager.getLogin()
//            startMainActivity(email)
//            finish()
//            return
//        }
        val registerButton: Button = findViewById(R.id.buttonRegister)

        registerButton.setOnClickListener {
            registerButtonClicked()
        }
    }

    private fun registerButtonClicked() { 
        val emailEditText: EditText = findViewById(R.id.editTextEmail)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)
        // Receive data when button is clicked
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // check, if not empty
        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (EmailValidator.isValidEmail(email)) {
                val user = User(email, password)
                preferenceManager.saveUser(user)
                startMainActivity(email)
            } else {
                // incorrect format message
                Toast.makeText(this, R.string.incorrect_email_input, Toast.LENGTH_SHORT).show()
            }
        } else {
            // incorrect format message
            Toast.makeText(this, R.string.fill_all_input_fields, Toast.LENGTH_SHORT).show()
        }
    }

    private fun startMainActivity(email: String) {
        val enterSlideAnimation = R.anim.slide_in_collapse
        val exitSlideAnimation = R.anim.slide_out_expand
        val activityOptions = ActivityOptions.makeCustomAnimation(this, enterSlideAnimation, exitSlideAnimation)

        val intent = Intent(this@AuthActivity, MainActivity::class.java)
        intent.putExtra("user_email", email)
        startActivity(intent, activityOptions.toBundle())
        finish()
    }
}