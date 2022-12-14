package com.example.bankofrussia.domain

import javax.inject.Inject

class LoadCurrencyUseCase @Inject constructor(private val repository: CurrencyRepository) {

    operator fun invoke() =
        repository.loadCurrency()
}