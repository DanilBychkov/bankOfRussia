package com.example.bankofrussia.di.viewmodelkeys

import androidx.lifecycle.ViewModel
import com.example.bankofrussia.presentation.MainActivityViewModel
import dagger.MapKey
import kotlin.reflect.KClass


@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class MainActivityViewModelKey(val value:KClass<MainActivityViewModelKey>)
