package com.isavit.codey.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.isavit.codey.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val myprog= findViewById<TextView>(R.id.MyPrograms)
        val clickscanrun = findViewById<TextView>(R.id.clickscanrun)
        val notes = findViewById<TextView>(R.id.notes)

        myprog.setOnClickListener {
            var intent = Intent( this, MyPrograms::class.java)
            startActivity(intent)
        }

        clickscanrun.setOnClickListener {
            var intent = Intent( this, ClickScanRun::class.java)
            startActivity(intent)
        }

       notes.setOnClickListener {
            var intent = Intent( this, Notes::class.java)
            startActivity(intent)
        }

    }
}