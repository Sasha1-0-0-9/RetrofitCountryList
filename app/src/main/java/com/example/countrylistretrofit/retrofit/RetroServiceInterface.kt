package com.example.countrylistretrofit.retrofit

import com.example.countrylistretrofit.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("v3.1/all")
    fun getCountryList(): Call<List<Country>>
}