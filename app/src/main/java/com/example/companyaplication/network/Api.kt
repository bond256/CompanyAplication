package com.example.companyaplication.network

import com.example.companyaplication.model.AllTeamsModelApi
import com.example.companyaplication.model.MyCompanyModelApi
import com.example.companyaplication.model.MyTeamModelApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface Api {

    @GET("/d1877370-b414-4ca0-8e7a-c55d8d6c4bac")
    fun getMyTeam(): Single<MyTeamModelApi>


    @GET("/21c2ea7b-9c93-4a0f-8883-2706e07790fa")
    fun getMyCompany(): Single<MyCompanyModelApi>


    @GET("/21f1a59c-7db1-4e09-9846-b4e3fbcbd513")
    fun getAllTeams(): Single<AllTeamsModelApi>

}