package com.example.companyaplication.model


import com.google.gson.annotations.SerializedName

data class UserTeamResult(
    val average: Int,
    val displayName: String,
    val rank: Int,
    val teamId: String
)