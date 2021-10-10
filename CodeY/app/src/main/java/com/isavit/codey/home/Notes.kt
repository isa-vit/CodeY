package com.isavit.codey.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.isavit.codey.R

class Notes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val button3 = findViewById<ImageButton>(R.id.imageButton3)
        button3.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)

        }
    }
}