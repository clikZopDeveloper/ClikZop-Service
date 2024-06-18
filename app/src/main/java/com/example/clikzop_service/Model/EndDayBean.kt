package com.example.clikzop_service.Model


import com.google.gson.annotations.SerializedName

data class EndDayBean(
    @SerializedName("data")
    val `data`: List<Any>,
    @SerializedName("error")
    val error: Boolean, // false
    @SerializedName("msg")
    val msg: String // Day ended successfully.
)