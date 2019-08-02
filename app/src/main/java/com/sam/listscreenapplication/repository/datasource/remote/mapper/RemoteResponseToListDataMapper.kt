package com.sam.listscreenapplication.repository.datasource.remote.mapper

import com.sam.listscreenapplication.repository.datasource.remote.model.ListScreenResponse
import com.sam.listscreenapplication.repository.model.Car
import com.sam.listscreenapplication.repository.model.Celebrity
import com.sam.listscreenapplication.repository.model.ListScreenData
import javax.inject.Inject

class RemoteResponseToListDataMapper @Inject constructor(){
    fun responseToModel(listScreenResponse: ListScreenResponse): ListScreenData{
        val celebrityList = mutableListOf<Celebrity>()
        val carList = mutableListOf<Car>()
        listScreenResponse.celebrities.forEach { (celebrityName, celebrityData) ->
            celebrityList.add(
                Celebrity(
                    celebrityName,
                    celebrityData.height,
                    celebrityData.age,
                    celebrityData.popularity,
                    celebrityData.photo))
        }
        listScreenResponse.cars.forEach { (carName, carData) ->
            carList.add(
                Car(
                    carName,
                    carData.photo
                )
            )
        }
        return ListScreenData(celebrityList, carList)
    }
}