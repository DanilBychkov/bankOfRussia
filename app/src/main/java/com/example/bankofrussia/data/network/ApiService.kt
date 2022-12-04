package com.example.bankofrussia.data.network

import com.example.bankofrussia.data.network.modeldto.ValuteContainer
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("scripts/XML_dynamic.asp")
    suspend fun getCurrencyList(
        @Query(QUERY_PARAM_FIRST_DAY) dateReq1:String =DEFAULT_FIRST_DAY,
        @Query(QUERY_PARAM_SECOND_DAY) dateReq2:String =DEFAULT_SECOND_DAY,
        @Query(QUERY_PARAM_CURRENCY) currency:String =DEFAULT_CURRENCY
    ) :  ValuteContainer

    companion object {
        const val QUERY_PARAM_FIRST_DAY = "date_req1"
        const val QUERY_PARAM_SECOND_DAY = "date_req2"
        const val QUERY_PARAM_CURRENCY = "VAL_NM_RQ"
        const val DEFAULT_FIRST_DAY = "02/03/2001"
        const val DEFAULT_SECOND_DAY = "14/03/2001"
        const val DEFAULT_CURRENCY = "R01235"
    }
}