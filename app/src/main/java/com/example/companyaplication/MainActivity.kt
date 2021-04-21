package com.example.companyaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.companyaplication.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment,MainFragment())
            .commit()
    }
}