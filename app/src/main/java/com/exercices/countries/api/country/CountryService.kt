package com.exercices.countries.api.country

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {
    @GET("v3.1/name/{countryName}")
    suspend fun getCountryInfo(
        @Path("countryName") countryName : String
    ):List<CountryResponse>
}