package com.example.clikzop_service.Model


import com.google.gson.annotations.SerializedName

data class deee(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("msg")
    val msg: String
) {
    data class Data(
        @SerializedName("allocated_request")
        val allocatedRequest: AllocatedRequest,
        @SerializedName("attendance")
        val attendance: Boolean,
        @SerializedName("complaints")
        val complaints: Complaints
    ) {
        data class AllocatedRequest(
            @SerializedName("accepted")
            val accepted: String,
            @SerializedName("pending")
            val pending: String,
            @SerializedName("rejected")
            val rejected: String
        )

        data class Complaints(
            @SerializedName("completed")
            val completed: String,
            @SerializedName("pending")
            val pending: String,
            @SerializedName("processing")
            val processing: String,
            @SerializedName("rejected")
            val rejected: String
        )
    }
}