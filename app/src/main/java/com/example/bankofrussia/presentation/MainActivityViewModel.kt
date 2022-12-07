package com.example.bankofrussia.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.bankofrussia.data.repository.CurrencyRepositoryImpl
import com.example.bankofrussia.domain.LoadCurrencyUseCase

class MainActivityViewModel(application: Application):AndroidViewModel(application) {

    private val repository = CurrencyRepositoryImpl(application)
    private val loadCurrencyUseCase = LoadCurrencyUseCase(repository)

    fun loadCurrencies() {
        loadCurrencyUseCase.invoke()
    }
}