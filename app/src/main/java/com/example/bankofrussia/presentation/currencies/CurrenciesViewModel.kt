package com.example.bankofrussia.presentation.currencies

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankofrussia.R
import com.example.bankofrussia.data.repository.CurrencyRepositoryImpl
import com.example.bankofrussia.domain.GetCurrencyListUseCase
import com.example.bankofrussia.domain.LoadCurrencyUseCase
import kotlinx.coroutines.launch

class CurrenciesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CurrencyRepositoryImpl(application)
    private val loadCurrencyUseCase = LoadCurrencyUseCase(repository)
    private val getCurrencyListUseCase = GetCurrencyListUseCase(repository)

    val currenciesList = getCurrencyListUseCase()

    fun loadCurrencies(firstDate: String, secondDate: String) {
        viewModelScope.launch {
            loadCurrencyUseCase.invoke(firstDate, secondDate)
        }
    }

    fun makeNotification(context:Context ) {
        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager
        createNotificationChannel(notificationManager)
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Валюта")
            .setContentText("Доллар вырос")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()
        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val notificationChannel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(notificationChannel)
    }

    companion object {
        private const val CHANNEL_ID = "channel_id"
        private const val CHANNEL_NAME = "channel_name"
        private const val NOTIFICATION_ID = 1
    }
}