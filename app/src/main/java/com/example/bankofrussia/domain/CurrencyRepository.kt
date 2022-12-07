package com.example.bankofrussia.domain

import androidx.lifecycle.LiveData
import com.example.bankofrussia.domain.entities.Currency

interface CurrencyRepository {

    fun getCurrencyList(): LiveData<List<Currency>>

    fun loadCurrency()
}