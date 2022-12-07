package com.example.bankofrussia.data.workers

import android.content.Context
import androidx.work.*
import com.example.bankofrussia.data.database.AppDatabase
import com.example.bankofrussia.data.mapper.CurrencyMapper
import com.example.bankofrussia.data.network.ApiFactory
import kotlinx.coroutines.delay
import com.example.bankofrussia.data.notifications.Notification
import com.example.bankofrussia.domain.entities.TypeCurrency
import java.time.LocalDateTime

class LoadDataWorker(var context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {

    private val currencyListDao = AppDatabase.getInstance(context).currencyListDao()
    private val apiService = ApiFactory.apiService

    private val mapper = CurrencyMapper()


    override suspend fun doWork(): Result {
        while (true) {
            val valuteContainer =
                apiService.getCurrencyList(getFirstDayToLoad(), getSecondDayToLoad())
            val listValue = mapper.mapValuteContainerToListValute(valuteContainer)

            if (mapper.mapCurrencyDBModelToCurrency(listValue.last()).typeCurrency == TypeCurrency.INCREASE)
                Notification().makeNotification(context)

            currencyListDao.insertCurrencyList(
                listValue
            )
            delay(MILLIS_IN_DAY)
        }
    }

    private fun getSecondDayToLoad() = LocalDateTime.now().minusDays(1).formatToSpecialString()

    private fun getFirstDayToLoad() = LocalDateTime.now().minusDays(31).formatToSpecialString()

    private fun LocalDateTime.formatToSpecialString() =
        "${this.dayOfMonth.toString().padStart(2, '0')}/${
            this.month.value.toString().padStart(2, '0')
        }/${this.year}"

    companion object {
        private const val MILLIS_IN_DAY: Long = 86400000

        fun makeRequest() = OneTimeWorkRequestBuilder<LoadDataWorker>().build()
    }
}
