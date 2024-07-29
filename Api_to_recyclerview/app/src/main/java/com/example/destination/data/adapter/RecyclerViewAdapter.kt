package com.example.destination.data.adapter

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.destination.R
import com.example.destination.data.model.Destination

class RecyclerViewAdapter(private val mList: List<Destination>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = this.itemView.findViewById(R.id.name)
        val description: TextView = this.itemView.findViewById(R.id.description)
        val image: ImageView = this.itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.destination_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destination = mList[position]

        holder.name.text = destination.name
        val descriptionText = SpannableStringBuilder().apply {
            append("Description:\n", StyleSpan(Typeface.BOLD), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            append(destination.description)
        }
        holder.description.text = descriptionText
        Glide.with(holder.image.context).load(destination.image).into(holder.image)
    }

    }