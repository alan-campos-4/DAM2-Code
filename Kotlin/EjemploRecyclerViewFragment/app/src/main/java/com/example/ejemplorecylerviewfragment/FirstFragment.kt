package com.example.ejemplorecylerviewfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // getting the employeelist
        val employelist = Constants.getEmployeeData()
        // Assign employeelist to ItemAdapter
        val itemAdapter = Adapter(employelist)

        // Set the LayoutManager that this RecyclerView will use.
        val recyclerView: RecyclerView =view.findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        // adapter instance is set to the recyclerview to inflate the items.
        recyclerView.adapter = itemAdapter
    }

}