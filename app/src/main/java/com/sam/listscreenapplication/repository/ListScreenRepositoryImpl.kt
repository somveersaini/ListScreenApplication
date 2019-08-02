package com.sam.listscreenapplication.repository

import com.sam.listscreenapplication.repository.datasource.remote.RemoteDataSource
import com.sam.listscreenapplication.repository.model.ListScreenData
import io.reactivex.Single
import javax.inject.Inject

class ListScreenRepositoryImpl @Inject constructor(val remoteDataSource: RemoteDataSource) : ListScreenRepository{

    override fun getListScreenData() : Single<ListScreenData> {
        return remoteDataSource.getListData()
    }
}