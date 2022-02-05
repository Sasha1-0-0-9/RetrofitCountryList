package com.example.countrylistretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylistretrofit.model.Country
import com.example.countrylistretrofit.retrofit.RetroInstance
import com.example.countrylistretrofit.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var liveDataList: MutableLiveData<List<Country>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<Country>> {
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getCountryList()
        call.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<Country>>,
                response: Response<List<Country>>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }
}