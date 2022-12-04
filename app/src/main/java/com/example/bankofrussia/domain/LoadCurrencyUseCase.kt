package com.example.bankofrussia.domain

class LoadCurrencyUseCase(private val repository: CurrencyRepository) {

    suspend operator fun invoke(firstDate: String, secondDate: String) =
        repository.loadCurrency(firstDate, secondDate)
}