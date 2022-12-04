package com.example.bankofrussia.domain

class GetCurrencyListUseCase(
    private val repository: CurrencyRepository
) {
    operator fun invoke() = repository.getCurrencyList()
}