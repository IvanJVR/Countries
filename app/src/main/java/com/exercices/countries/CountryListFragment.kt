package com.exercices.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CountryListFragment : Fragment() {
    private lateinit var rv : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = view.findViewById(R.id.rViewCountryList)

        val countryNamesList = resources.getStringArray(R.array.countries_array)

        val countries = ArrayList<ListModel>()

        for(countryName in countryNamesList){
            countries.add(ListModel(countryName))
        }

        rv.adapter = CountryListAdapter(countries)
    }
}