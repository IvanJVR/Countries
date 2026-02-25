package com.exercices.countries.api.country

data class CountryResponse(
    val name: Name?,
    val capital: List<String>?,
    val population: Int?,
    val area: Int?,
    val region: String?,
    val subregion: String?
)

data class Name(
    val common: String,
    val official: String
)