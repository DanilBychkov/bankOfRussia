package com.example.bankofrussia.data.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.bankofrussia.R

class Notification {

    fun makeNotification(context: Context) {
        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager
        createNotificationChannel(notificationManager)
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(context.getString(R.string.app_name))
            .setContentText(context.getString(R.string.USD_Currency_Grow))
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()
        notificationManager.notify(ID, notification)
    }

    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val notificationChannel = NotificationChannel(
            ID.toString(),
            NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(notificationChannel)
    }

    companion object {
        const val CHANNEL_ID = "1"
        const val ID = 1
        const val NAME = "NOTIFICATION_CURRENCY"
    }
}