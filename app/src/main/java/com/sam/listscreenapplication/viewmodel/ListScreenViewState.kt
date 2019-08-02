package com.sam.listscreenapplication.viewmodel

import com.sam.listscreenapplication.repository.model.ListScreenData

sealed class ListScreenViewState

data class SuccessState(val listScreenData: ListScreenData) : ListScreenViewState()

object LoadingState : ListScreenViewState()

data class ErrorState(val errorMessage: String) : ListScreenViewState()