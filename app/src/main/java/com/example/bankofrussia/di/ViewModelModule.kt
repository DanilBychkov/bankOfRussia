package com.example.bankofrussia.di

import androidx.lifecycle.ViewModel
import com.example.bankofrussia.di.viewmodelkeys.MainActivityViewModelKey
import com.example.bankofrussia.presentation.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @MainActivityViewModelKey(MainActivityViewModelKey::class)
    fun bindMainActivityViewModel(viewModel: MainActivityViewModel):ViewModel
}