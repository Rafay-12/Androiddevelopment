package com.ffan.roomdatabaseapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ffan.roomdatabaseapp.R
import com.ffan.roomdatabaseapp.data.local.entities.Car

class CarAdapter(private val carList: List<Car>, private val onEditClick: ((Car) -> Unit)?,
                 private val onDeleteClick: ((Car) -> Unit)?
) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val company: TextView = itemView.findViewById(R.id.companyName)
        val type: TextView = itemView.findViewById(R.id.type)
        val model: TextView = itemView.findViewById(R.id.model)
        val editBtn: Button = itemView.findViewById(R.id.editBtn)
        val deleteBtn : Button = itemView.findViewById(R.id.deleteBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carList[position]

        holder.name.text = car.name
        holder.company.text = car.company
        holder.type.text = car.type
        holder.model.text = car.model
        holder.editBtn.setOnClickListener {
            onEditClick?.let { it1 -> it1(car) }
        }

        holder.deleteBtn.setOnClickListener {
            onDeleteClick?.let { it1 -> it1(car) }
        }
    }

}