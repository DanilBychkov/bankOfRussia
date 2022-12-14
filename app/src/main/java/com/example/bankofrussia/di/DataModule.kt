package com.example.bankofrussia.di

import android.app.Application
import com.example.bankofrussia.data.database.AppDatabase
import com.example.bankofrussia.data.database.CurrencyListDao
import com.example.bankofrussia.data.repository.CurrencyRepositoryImpl
import com.example.bankofrussia.domain.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @Binds
    fun bindCurrencyRepository(impl: CurrencyRepository): CurrencyRepositoryImpl

    companion object{

        @Provides
        fun provideCurrencyListDao(
            application: Application
        ):CurrencyListDao{
            return AppDatabase.getInstance(application.applicationContext).currencyListDao()
        }

    }

}