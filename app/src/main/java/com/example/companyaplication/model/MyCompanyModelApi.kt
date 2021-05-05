package com.example.companyaplication.model


import com.google.gson.annotations.SerializedName

data class MyCompanyModelApi(
    @SerializedName("metric")
    val metric: String,
    @SerializedName("period")
    val period: String,
    @SerializedName("programId")
    val programId: String,
    @SerializedName("programName")
    val programName: String,
    @SerializedName("results")
    val results: List<MyCompanyData>,
    @SerializedName("userTeamResult")
    val userTeamResult: UserTeamResult
)


data class MyCompanyData(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("average")
    val average: Int,
    @SerializedName("average_double")
    val averageDouble: Int,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_double")
    val totalDouble: Int,
    @SerializedName("userId")
    val userId: String
)