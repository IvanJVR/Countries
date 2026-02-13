package com.exercices.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryInfoAdapter (private val countryInfo: List<CountryModel>) : RecyclerView.Adapter<CountryInfoAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_info, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtValue : TextView = itemView.findViewById(R.id.txtValue)
        val txtLabel : TextView = itemView.findViewById(R.id.txtLabel)
    }
}