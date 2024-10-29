package com.example.classassignment1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var studentIdInput: EditText
    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var hobbySports: CheckBox
    private lateinit var hobbyMovie: CheckBox
    private lateinit var hobbyMusic: CheckBox
    private lateinit var acceptBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentIdInput = findViewById(R.id.studentIdInput)
        nameInput = findViewById(R.id.nameInput)
        emailInput = findViewById(R.id.emailInput)
        phoneInput = findViewById(R.id.phoneInput)
        hobbySports = findViewById(R.id.hobbySports)
        hobbyMovie = findViewById(R.id.hobbyMovie)
        hobbyMusic = findViewById(R.id.hobbyMusic)
        acceptBox = findViewById(R.id.acceptBox)

        val submitButton: Button = findViewById(R.id.submitButton)
        submitButton.setOnClickListener { checkFields() }
    }

    private fun checkFields() {
        if (TextUtils.isEmpty(studentIdInput.text.toString().trim())) {
            showToast("Please enter your Student ID")
            return
        }

        if (TextUtils.isEmpty(nameInput.text.toString().trim())) {
            showToast("Please enter your Name")
            return
        }

        if (TextUtils.isEmpty(emailInput.text.toString().trim())) {
            showToast("Please enter your Email")
            return
        }

        if (TextUtils.isEmpty(phoneInput.text.toString().trim())) {
            showToast("Please enter your Phone Number")
            return
        }

        if (!hobbySports.isChecked && !hobbyMovie.isChecked && !hobbyMusic.isChecked) {
            showToast("Please select at least one hobby")
            return
        }

        if (!acceptBox.isChecked) {
            showToast("Please accept the terms and conditions")
            return
        }

        // If all fields are filled
        showToast("Form submitted successfully!")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}