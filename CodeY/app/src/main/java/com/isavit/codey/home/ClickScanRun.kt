package com.isavit.codey.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.isavit.codey.R

class ClickScanRun : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_scan_run)

        val button2 = findViewById<ImageButton>(R.id.imageButton2)
        button2.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)

        }
    }
}