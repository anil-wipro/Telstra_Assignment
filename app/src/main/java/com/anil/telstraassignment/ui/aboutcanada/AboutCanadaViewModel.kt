package com.anil.telstraassignment.ui.aboutcanada

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.anil.telstraassignment.data.ItemAboutCanada

class AboutCanadaViewModel(private val repository: AboutCanadaRepository) : ViewModel() {

    // get about canada data
    fun getAboutCanadaData(): MutableLiveData<ItemAboutCanada>? {
        return repository.getAboutCanadaDataFromAPI()
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