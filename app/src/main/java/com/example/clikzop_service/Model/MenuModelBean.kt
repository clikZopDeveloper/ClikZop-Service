package com.example.clikzop_service.Model


import com.google.gson.annotations.SerializedName

data class MenuModelBean(

    @SerializedName("indexId")
    val indexId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("subTitle")
    val subTitle: String,

    val drawableId: Int
) {

}