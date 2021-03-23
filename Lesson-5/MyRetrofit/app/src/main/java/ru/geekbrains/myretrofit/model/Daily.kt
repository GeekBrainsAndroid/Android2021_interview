package ru.geekbrains.myretrofit.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Daily(
    @SerializedName(value="Date")
    val date: Date,
    @SerializedName(value="PreviousDate")
    val previousDate: Date,
    @SerializedName(value="PreviousURL")
    val previousUrl: String,
    @SerializedName(value="Timestamp")
    val timestamp: String,
    @SerializedName(value="Valute")
    val valute: Map<String, Valute>
)