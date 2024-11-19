package com.ejemplo.testintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next)

        val nombre = intent.getStringExtra("NAME")
        val tvGreeting = findViewById<TextView>(R.id.tvMessage)
        tvGreeting.apply { text = getString(R.string.base, nombre) }
    }
}