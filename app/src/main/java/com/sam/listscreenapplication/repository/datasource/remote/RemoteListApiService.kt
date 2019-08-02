package com.sam.listscreenapplication.repository.datasource.remote

import com.sam.listscreenapplication.common.Constants
import com.sam.listscreenapplication.repository.datasource.remote.model.ListScreenResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteListApiService {

    @GET("/${Constants.BIN_KEY}")
    fun getListData(): Single<ListScreenResponse>
}