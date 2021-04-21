package com.example.companyaplication.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("average")
    val average: Int,
    @SerializedName("average_double")
    val averageDouble: Int,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("teamId")
    val teamId: String
)