package com.example.ejemplorecyclerview.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorecyclerview.Equipo
import com.example.ejemplorecyclerview.R

class EquipoAdapter(
        private val equiposLista:List<Equipo>,
        private val onClickListener: (Equipo) -> Unit
    ) : RecyclerView.Adapter<EquipoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EquipoViewHolder(
            layoutInflater.inflate(
                R.layout.item_equipos,parent,false))
    }

    override fun getItemCount(): Int = equiposLista.size

    override fun onBindViewHolder(holder: EquipoViewHolder, position: Int) {
        val itemEquipo = equiposLista[position]
        holder.render(itemEquipo,onClickListener)
    }
}