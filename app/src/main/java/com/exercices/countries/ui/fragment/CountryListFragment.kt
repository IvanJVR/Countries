package com.exercices.countries.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.exercices.countries.ui.adapter.CountryListAdapter
import com.exercices.countries.model.ListModel
import com.exercices.countries.R
import com.exercices.countries.api.country.RetrofitClient
import com.exercices.countries.model.CountryModel
import kotlinx.coroutines.launch
import com.exercices.countries.utils.formatArea
import com.exercices.countries.utils.formatPopulation
import androidx.navigation.fragment.findNavController


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

        rv.adapter = CountryListAdapter(countries,
            onRowClick = {countryName ->
                //fetchCountryDetails(countryName)
                val action =
                    CountryListFragmentDirections
                        .actionCountryListFragmentToCountryDetailsFragment(countryName)

                findNavController().navigate(action)
            })
    }
}