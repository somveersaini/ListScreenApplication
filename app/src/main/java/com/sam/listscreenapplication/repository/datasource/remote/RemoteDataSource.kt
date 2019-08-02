package com.sam.listscreenapplication.repository.datasource.remote

import com.sam.listscreenapplication.repository.datasource.DataSource
import com.sam.listscreenapplication.repository.datasource.remote.mapper.RemoteResponseToListDataMapper
import com.sam.listscreenapplication.repository.model.ListScreenData
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    val listApiService: RemoteListApiService,
    val mapper: RemoteResponseToListDataMapper
) : DataSource {

    override fun getListData(): Single<ListScreenData> {
        return listApiService.getListData()
            .map { mapper.responseToModel(it) }
    }


}