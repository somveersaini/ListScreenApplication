package com.sam.listscreenapplication.repository.datasource

import com.sam.listscreenapplication.repository.model.ListScreenData
import io.reactivex.Single

interface DataSource{
    fun getListData(): Single<ListScreenData>
}