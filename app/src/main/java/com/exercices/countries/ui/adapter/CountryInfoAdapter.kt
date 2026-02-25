package com.exercices.countries.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exercices.countries.R
import com.exercices.countries.model.CountryModel

class CountryInfoAdapter (private val countryInfo: List<CountryModel>) : RecyclerView.Adapter<CountryInfoAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.country_info, parent, false)
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val countryInfo = countryInfo[position]
        holder.txtValue.text = countryInfo.value
        holder.txtLabel.text = countryInfo.label
    }

    override fun getItemCount(): Int = countryInfo.size

    class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtValue : TextView = itemView.findViewById(R.id.txtValue)
        val txtLabel : TextView = itemView.findViewById(R.id.txtLabel)
    }
}