package com.anil.telstraassignment.ui.aboutcanada

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anil.telstraassignment.data.ItemAboutCanada

class AboutCanadaViewModel(private val repository: AboutCanadaRepository) : ViewModel() {

    // get about canada data
    fun getAboutCanadaData(isPullRefresh : Boolean): MutableLiveData<ItemAboutCanada>? {
        return repository.getAboutCanadaDataFromAPI(isPullRefresh)
    }

    // get loading state
    fun getLoadingState(): MutableLiveData<Int> {
        return repository.getLoadingState()
    }

    // get error message
    fun getErrorMessage(): MutableLiveData<Int> {
        return repository.getErrorMessage()
    }
}