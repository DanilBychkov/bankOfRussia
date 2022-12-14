package com.example.bankofrussia.presentation

import android.app.Application
import com.example.bankofrussia.di.DaggerApplicationComponent


class CurrencyApp:Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}