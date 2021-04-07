package ru.geekbrains.mviarchitecture.network.model

import com.google.gson.annotations.SerializedName

data class Valute(
    @SerializedName(value="ID")
    val id: String,
    @SerializedName(value="NumCode")
    val numCode: String,
    @SerializedName(value="CharCode")
    val charCode: String,
    @SerializedName(value="Nominal")
    val nominal: Int,
    @SerializedName(value="Name")
    val name: String,
    @SerializedName(value="Value")
    val value: Double,
    @SerializedName(value="Previous")
    val previous: Double
)