package com.ejemplo.testintent

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val et = findViewById<EditText>(R.id.etNombre)
        val btn = findViewById<Button>(R.id.btn)
        btn.setBackgroundColor(Color.RED)
        btn.setOnClickListener {
            if (et.text.any()) {
                val intent = Intent(this@MainActivity, NextActivity::class.java)
                intent.putExtra("NAME", et.text.toString())
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "El EditText está vacío", Toast.LENGTH_SHORT).show()
            }
        }
    }
}