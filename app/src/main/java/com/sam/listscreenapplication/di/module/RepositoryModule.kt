package com.sam.listscreenapplication.di.module

import dagger.Binds
import dagger.Module
import com.sam.listscreenapplication.repository.ListScreenRepository
import com.sam.listscreenapplication.repository.ListScreenRepositoryImpl


@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindDataRepository(listScreenRepository: ListScreenRepositoryImpl): ListScreenRepository
}