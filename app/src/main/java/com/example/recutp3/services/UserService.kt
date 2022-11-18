package com.example.recutp3.services

import com.example.recutp3.models.UserResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UserService {

    @GET("api")
    fun getUsers(@Query("results") results: Int) : Call<UserResults>

    @GET("api")
    fun getUsersSeeded(@Query("results") results: Int, @Query("seed") seed: String) : Call<UserResults>
}