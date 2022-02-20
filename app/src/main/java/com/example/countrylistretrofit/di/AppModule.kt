package com.example.countrylistretrofit.di

import com.example.countrylistretrofit.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainActivityViewModel()
    }
}