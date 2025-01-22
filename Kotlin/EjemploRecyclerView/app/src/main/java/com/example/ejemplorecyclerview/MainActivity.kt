package com.example.ejemplorecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemplorecyclerview.adapter.EquipoAdapter
import com.example.ejemplorecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initRecyclerView(){
        //val manager = GridLayoutManager(this, 1)
        val manager = LinearLayoutManager(this)
        binding.recyclerLaLiga.layoutManager = manager
        binding.recyclerLaLiga.adapter = EquipoAdapter(
            EquipoProvider.listaEquipos) { equipo -> onItemSelected(equipo)  }
    }
    private fun onItemSelected(equipo: Equipo){
        Toast.makeText(
            this,
            equipo.equipo,
            Toast.LENGTH_SHORT
        ).show()
    }
}