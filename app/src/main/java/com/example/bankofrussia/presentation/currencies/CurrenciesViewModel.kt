package com.example.bankofrussia.presentation.currencies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.bankofrussia.data.repository.CurrencyRepositoryImpl
import com.example.bankofrussia.domain.GetCurrencyListUseCase

class CurrenciesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CurrencyRepositoryImpl(application)
    private val getCurrencyListUseCase = GetCurrencyListUseCase(repository)

    val currenciesList = getCurrencyListUseCase()

}