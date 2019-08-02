package com.sam.listscreenapplication.di.module

import com.sam.listscreenapplication.ui.ListScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun contributeListScreenFragment(): ListScreenFragment
}