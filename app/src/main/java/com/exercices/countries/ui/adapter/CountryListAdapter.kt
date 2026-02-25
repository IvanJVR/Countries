package com.exercices.countries.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exercices.countries.R
import com.exercices.countries.model.ListModel

class CountryListAdapter(private val countryList : List<ListModel>, private val onRowClick: (String) -> Unit): RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contry_list_row, parent, false)
        return CountryListViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: CountryListViewHolder,
        position: Int
    ) {
        val country = countryList[position]
        holder.txtCountryName.text = country.countryName

        holder.itemView.setOnClickListener {
            onRowClick(country.countryName)
        }
    }

    override fun getItemCount(): Int = countryList.size

    class CountryListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtCountryName: TextView = itemView.findViewById(R.id.txtCountryName)
    }
}