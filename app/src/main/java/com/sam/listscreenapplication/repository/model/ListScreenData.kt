package com.sam.listscreenapplication.repository.model

data class ListScreenData(
    val celebrities: List<Celebrity>,
    val cars: List<Car>
)

data class Celebrity(
    val name: String,
    val height: String,
    val age: Int,
    val popularity: Int,
    val photo: String
) : ListScreenItem


data class Car(
    val name: String,
    val photo: String
) : ListScreenItem

data class Section(
    val name: String
): ListScreenItem

interface ListScreenItem