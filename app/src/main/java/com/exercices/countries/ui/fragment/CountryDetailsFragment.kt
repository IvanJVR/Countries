package com.exercices.countries.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.exercices.countries.R
import com.exercices.countries.api.country.RetrofitClient
import com.exercices.countries.model.CountryModel
import com.exercices.countries.ui.adapter.CountryInfoAdapter
import com.exercices.countries.utils.formatArea
import com.exercices.countries.utils.formatPopulation
import kotlinx.coroutines.launch

class CountryDetailsFragment : Fragment() {

    private lateinit var rv: RecyclerView
    private val args: CountryDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv =  view.findViewById(R.id.rViewCountryDetails)

        fetchCountryDetails(args.countryName)
    }

    fun fetchCountryDetails(countryName: String){
        lifecycleScope.launch {
            try{
                val response = RetrofitClient.instance.getCountryInfo(countryName)
                val countryInfo = listOf(
                    CountryModel("Nombre", response[0].name?.common?: "N/A"),
                    CountryModel("Capital", response[0].capital?.firstOrNull()?: "N/A"),
                    CountryModel("Población", response[0].population.formatPopulation()),
                    CountryModel("Subregión", response[0].subregion?: "N/A"),
                    CountryModel("Área", response[0].area.formatArea())
                )

                rv.adapter = CountryInfoAdapter(countryInfo)
            } catch (e: Exception){

            }
        }
    }

}