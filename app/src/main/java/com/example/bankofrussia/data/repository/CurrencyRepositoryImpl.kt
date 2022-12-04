package com.example.bankofrussia.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.bankofrussia.data.database.AppDatabase
import com.example.bankofrussia.data.mapper.CurrencyMapper
import com.example.bankofrussia.data.network.ApiFactory
import com.example.bankofrussia.domain.CurrencyRepository
import com.example.bankofrussia.domain.entities.Currency

class CurrencyRepositoryImpl(private val application: Application) : CurrencyRepository {

    private val currencyListDao = AppDatabase.getInstance(application).currencyListDao()
    private val apiService = ApiFactory.apiService

    private val mapper = CurrencyMapper()

    override fun getCurrencyList(): LiveData<List<Currency>> =
        Transformations.map(currencyListDao.getCurrencyItems()) { it ->
            it.map { currencyDBModel ->
                mapper.mapCurrencyDBModelToCurrency(currencyDBModel)
            }
        }

    override suspend fun loadCurrency(firstDate: String, secondDate: String) {
        val valuteContainer = apiService.getCurrencyList(firstDate, secondDate)
        currencyListDao.insertCurrencyList(
            mapper.mapValuteContainerToListValute(valuteContainer)
        )
    }
}