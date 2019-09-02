package com.anil.telstraassignment.ui.aboutcanada

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.anil.telstraassignment.data.ApiResponseHandler

class AboutCanadaViewModel(private val repository: AboutCanadaRepository) : ViewModel() {

    private val fetchDataTrigger = MutableLiveData<Boolean>()

    // observed lazily and permit functional composition and delegation
    private val users: LiveData<ApiResponseHandler> = Transformations.switchMap(fetchDataTrigger) {
        repository.getAboutCanadaDataFromAPI()
    }

    // load data at the very first time
    init {
        refreshAboutCanadaData()
    }

    // we set value of this mutable live data as true while need to fetch data from server
    fun refreshAboutCanadaData() {
        fetchDataTrigger.value = true
    }

    // get about canada data from live data
    fun getAboutCanadaData(): LiveData<ApiResponseHandler> = users

}