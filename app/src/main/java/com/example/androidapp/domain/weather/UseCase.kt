package com.example.androidapp.domain.weather

import com.example.androidapp.data.Repos

object UseCase {

    private val repo = Repos

    suspend fun getWeather(currency: String = "5.0", cur: String = "3.0"): String{

        val v = repo.getWeather(lat, lon)
        return v.toString()
    }
}