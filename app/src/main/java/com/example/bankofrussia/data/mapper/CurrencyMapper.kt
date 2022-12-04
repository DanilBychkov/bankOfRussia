package com.example.bankofrussia.data.mapper

import com.example.bankofrussia.data.database.modeldao.CurrencyDBModel
import com.example.bankofrussia.data.network.modeldto.Valute
import com.example.bankofrussia.data.network.modeldto.ValuteContainer
import com.example.bankofrussia.domain.entities.Currency
import com.example.bankofrussia.domain.entities.TypeCurrency

class CurrencyMapper {

    fun mapValuteContainerToListValute(valuteContainer: ValuteContainer): List<CurrencyDBModel> {
        val result = mutableListOf<CurrencyDBModel>()
        var lastCurrency = valuteContainer.valute[0].value
        for ((index, valute) in valuteContainer.valute.withIndex()) {
            if (index == 0)
                continue

            val type = if (valute.value > lastCurrency)
                TypeCurrency.INCREASE
            else
                TypeCurrency.DECREASE

            lastCurrency = valute.value
            result.add(valute.mapValuteDtoToCurrencyDb(valuteContainer.valute.size-index, type))
        }
        return result
    }

    fun mapCurrencyDBModelToCurrency(currencyDBModel: CurrencyDBModel): Currency {
        val typeCurrency = when (currencyDBModel.typeCurrency) {
            TypeCurrency.INCREASE.name -> TypeCurrency.INCREASE
            TypeCurrency.DECREASE.name -> TypeCurrency.DECREASE
            else -> throw RuntimeException(UNKNOWN_TYPE)
        }
        return Currency(currencyDBModel.data, currencyDBModel.value, typeCurrency)
    }

    fun Valute.mapValuteDtoToCurrencyDb(newId: Int, newTypeCurrency: TypeCurrency) =
        CurrencyDBModel(
            id = newId,
            data = this.date,
            value = this.value.replace(",", ".").toFloat(),
            typeCurrency = newTypeCurrency.name
        )

    companion object {
        const val UNKNOWN_TYPE = ""
    }
}