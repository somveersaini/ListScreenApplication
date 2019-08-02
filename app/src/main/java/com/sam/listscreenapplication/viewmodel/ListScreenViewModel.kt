package com.sam.listscreenapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sam.listscreenapplication.repository.ListScreenRepository
import com.sam.listscreenapplication.repository.model.ListScreenData
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListScreenViewModel @Inject constructor() : ViewModel() {

    private val viewStateLiveData = MutableLiveData<ListScreenViewState>()

    @Inject
    lateinit var repository: ListScreenRepository

    fun getListScreenViewState() = viewStateLiveData


    fun fetchListScreenData() {
        if (viewStateLiveData.value == null) {
            viewStateLiveData.postValue(LoadingState)
            val listScreenDataSingle = repository.getListScreenData()
            listScreenDataSingle.subscribeOn(Schedulers.io())
                .subscribeWith(object : DisposableSingleObserver<ListScreenData>() {
                    override fun onSuccess(listScreenData: ListScreenData) {
                        viewStateLiveData.postValue(
                            SuccessState(listScreenData)
                        )
                    }

                    override fun onError(error: Throwable) {
                        viewStateLiveData.postValue(ErrorState(error.message ?: " "))
                    }
                })

        }
    }
}
