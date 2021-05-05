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
    val results: List<AllTeamData>,
    @SerializedName("userTeamResult")
    val userTeamResult: UserTeamResult
)

data class AllTeamData(
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