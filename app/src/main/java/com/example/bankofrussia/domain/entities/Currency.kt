package com.example.bankofrussia.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.sql.Time
import java.time.DayOfWeek

@Parcelize
data class Currency(
    var data: String,
    var value: Float,
    var typeCurrency:TypeCurrency
) : Parcelable

