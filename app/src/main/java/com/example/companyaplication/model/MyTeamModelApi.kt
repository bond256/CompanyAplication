package com.example.companyaplication.model


import com.google.gson.annotations.SerializedName

data class MyTeamModelApi(
    @SerializedName("metric")
    val metric: String,
    @SerializedName("period")
    val period: String,
    @SerializedName("programId")
    val programId: String,
    @SerializedName("programName")
    val programName: String,
    @SerializedName("results")
    val results: List<Any>,
    @SerializedName("teamId")
    val teamId: String,
    @SerializedName("teamName")
    val teamName: String,
    @SerializedName("userResult")
    val userResult: Any
)