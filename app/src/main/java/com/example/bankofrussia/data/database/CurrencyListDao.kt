package com.example.bankofrussia.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

import com.example.bankofrussia.data.database.modeldao.CurrencyDBModel


@Dao
interface CurrencyListDao {

    @Query("SELECT * FROM currency_items")
    fun getCurrencyItems(): LiveData<List<CurrencyDBModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyList(currencyList:List<CurrencyDBModel>)
}