package com.ejemplo.ejemplofragmento

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = bundleOf(
            ARG_PARAM1 to "Datos del primer parámetro",
            ARG_PARAM2 to "Datos del segundo parámetro" )

        supportFragmentManager.commit{
            setReorderingAllowed(true)
            //add<FirstFragment>(R.id.fragmentContainer)
            add<FirstFragment>(R.id.fragmentContainer, args = bundle)
        }
    }
}