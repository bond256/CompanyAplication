package com.example.companyaplication.model


import com.google.gson.annotations.SerializedName

data class AllTeamsModelApi(
    @SerializedName("metric")
    val metric: String,
    @SerializedName("period")
    val period: String,
    @SerializedName("programId")
    val programId: String,
    @SerializedName("programName")
    val programName: String,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("userTeamResult")
    val userTeamResult: UserTeamResult
)