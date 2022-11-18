package com.example.recutp3.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserServiceApiBuilder {
    private const val baseUrl = "https://randomuser.me/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): UserService {
        return retrofit.create(UserService::class.java)
    }
}