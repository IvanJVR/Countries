package com.exercices.countries.utils

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

fun Long?.formatPopulation(): String{
    if(this == null) return "0"

    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    formatter.maximumFractionDigits = 0

    return formatter.format(this)
}

fun Int?.formatPopulation(): String{
    if(this == null) return "0"

    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    formatter.maximumFractionDigits = 0

    return formatter.format(this)
}

fun Double?.formatArea(): String{
    if(this == null) return "00.00"
    val decimalFormat = DecimalFormat("#,##0.00")
    return decimalFormat.format(this)
}

fun Int?.formatArea(): String{
    if(this == null) return "00.00"
    val decimalFormat = DecimalFormat("#,##0.00")
    return decimalFormat.format(this)
}