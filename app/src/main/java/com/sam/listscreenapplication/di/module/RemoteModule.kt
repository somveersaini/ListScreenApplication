package com.sam.listscreenapplication.di.module

import com.sam.listscreenapplication.common.Constants
import com.sam.listscreenapplication.repository.datasource.DataSource
import com.sam.listscreenapplication.repository.datasource.remote.RemoteDataSource
import com.sam.listscreenapplication.repository.datasource.remote.RemoteListApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun providerListScreenApiService(): RemoteListApiService {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return Retrofit
            .Builder()
            .client(httpClient.build())
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteListApiService::class.java)
    }

    @Provides
    fun provideRemoteDataSource(remoteDataSource: RemoteDataSource): DataSource = remoteDataSource
}