package com.exercices.countries

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.exercices.countries.CountryInfoAdapter.CountryViewHolder

class CountryListAdapter(private val countryList : List<ListModel>): RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder>() {
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

        TODO("Hacer evento onClick")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class CountryListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtCountryName: TextView = itemView.findViewById(R.id.txtCountryName)
    }
}