package com.example.bankofrussia.presentation

import androidx.lifecycle.ViewModel
import com.example.bankofrussia.domain.LoadCurrencyUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val loadCurrencyUseCase: LoadCurrencyUseCase
):ViewModel() {

    fun loadCurrencies() {
        loadCurrencyUseCase.invoke()
    }
}