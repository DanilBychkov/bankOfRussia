package com.example.bankofrussia.domain

class LoadCurrencyUseCase(private val repository: CurrencyRepository) {

    operator fun invoke() =
        repository.loadCurrency()
}