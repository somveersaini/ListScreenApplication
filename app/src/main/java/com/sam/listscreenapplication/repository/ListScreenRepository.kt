package com.sam.listscreenapplication.repository

import com.sam.listscreenapplication.repository.model.ListScreenData
import io.reactivex.Single

interface ListScreenRepository {
    fun getListScreenData() : Single<ListScreenData>
}