package com.example.bankofrussia.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.bankofrussia.data.database.AppDatabase
import com.example.bankofrussia.data.mapper.CurrencyMapper
import com.example.bankofrussia.data.workers.LoadDataWorker
import com.example.bankofrussia.domain.CurrencyRepository
import com.example.bankofrussia.domain.entities.Currency

class CurrencyRepositoryImpl(private val application: Application) : CurrencyRepository {

    private val currencyListDao =
        AppDatabase.getInstance(application.applicationContext).currencyListDao()
    private val mapper = CurrencyMapper()

    override fun getCurrencyList(): LiveData<List<Currency>> =
        Transformations.map(currencyListDao.getCurrencyItems()) {
            it.map { currencyDBModel ->
                mapper.mapCurrencyDBModelToCurrency(currencyDBModel)
            }
        }

    override fun loadCurrency() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork("A", ExistingWorkPolicy.REPLACE, LoadDataWorker.makeRequest())
    }
}