package com.sam.listscreenapplication.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sam.listscreenapplication.viewmodel.CustomViewModelFactory
import com.sam.listscreenapplication.di.ViewModelKey
import com.sam.listscreenapplication.viewmodel.ListScreenViewModel


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListScreenViewModel::class)
    abstract fun bindListScreenViewModel(forcastViewModel: ListScreenViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory
}
