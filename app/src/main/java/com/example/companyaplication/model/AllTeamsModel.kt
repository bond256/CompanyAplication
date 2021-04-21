package com.example.companyaplication.model


import com.google.gson.annotations.SerializedName

data class AllTeamsModel(
    val metric: String,
    val period: String,
    val programId: String,
    val programName: String,
    val results: List<Result>,
    val userTeamResult: UserTeamResult
)