package com.sam.listscreenapplication.repository.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class ListScreenResponse(
    @SerializedName("celebrities")
    val celebrities: Map<String, Celebrity>,

    @SerializedName("cars")
    val cars: Map<String, Car>
)

data class Celebrity(
    @SerializedName("height")
    val height: String,

    @SerializedName("age")
    val age: Int,

    @SerializedName("popularity")
    val popularity: Int,

    @SerializedName("photo")
    val photo: String
)


data class Car(
    @SerializedName("photo")
    val photo: String
)