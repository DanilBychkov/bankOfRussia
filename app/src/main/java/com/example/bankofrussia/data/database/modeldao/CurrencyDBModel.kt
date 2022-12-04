package com.example.bankofrussia.data.database.modeldao

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "currency_items")
data class CurrencyDBModel(
    @PrimaryKey()
    val id: Int,
    var data: String,
    var value: Float,
    var typeCurrency:String
)

