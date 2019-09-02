package com.anil.telstraassignment.ui.aboutcanada

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.anil.telstraassignment.data.ApiResponseHandler

class AboutCanadaViewModel(private val repository: AboutCanadaRepository) : ViewModel() {

    private val fetchDataTrigger = MutableLiveData<Boolean>()

    private val users: LiveData<ApiResponseHandler> = Transformations.switchMap(fetchDataTrigger) {
        repository.getAboutCanadaDataFromAPI()
    }

    init {
        refreshAboutCanadaData()
    }

    fun refreshAboutCanadaData() {
        fetchDataTrigger.value = true
    }

    fun getAboutCanadaData(): LiveData<ApiResponseHandler> = users

}