package com.example.companyaplication

import android.app.Application
import com.example.companyaplication.network.NetworkClient
import com.example.companyaplication.repository.AllTeamsRepository
import com.example.companyaplication.repository.MyCompanyRepository

class App: Application() {

    companion object{
        lateinit var instance: App
        private set
        lateinit var allTeamsRepository: AllTeamsRepository
        private set
        lateinit var myCompanyRepository: MyCompanyRepository
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
        allTeamsRepository= AllTeamsRepository(NetworkClient())
        myCompanyRepository= MyCompanyRepository(NetworkClient())
    }
}