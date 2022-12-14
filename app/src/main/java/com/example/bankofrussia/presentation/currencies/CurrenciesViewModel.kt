package com.example.bankofrussia.presentation.currencies

import androidx.lifecycle.ViewModel
import com.example.bankofrussia.domain.GetCurrencyListUseCase
import javax.inject.Inject

class CurrenciesViewModel @Inject constructor(getCurrencyListUseCase: GetCurrencyListUseCase) : ViewModel() {
    val currenciesList = getCurrencyListUseCase()

}