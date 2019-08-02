package com.sam.listscreenapplication.di

import android.app.Application
import com.sam.listscreenapplication.ListScreenApplication
import com.sam.listscreenapplication.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        RemoteModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        UiModule::class
    )
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: ListScreenApplication)
}