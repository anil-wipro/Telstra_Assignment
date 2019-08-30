package com.anil.telstraassignment.ui.aboutcanada

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anil.telstraassignment.data.ApiResponseHandler

class AboutCanadaViewModel(private val repository: AboutCanadaRepository) : ViewModel() {

    private var aboutCanadaResult: MutableLiveData<ApiResponseHandler> = MutableLiveData()

    // get about canada response
    fun getAboutCanadaData(isPullRefresh: Boolean): LiveData<ApiResponseHandler>? {
        if (isPullRefresh) {
            aboutCanadaResult = repository.getAboutCanadaDataFromAPI(isPullRefresh)
            return aboutCanadaResult
        } else {
            if (aboutCanadaResult.value != null)
                aboutCanadaResult = repository.getAboutCanadaDataFromAPI(isPullRefresh)
        }
        return aboutCanadaResult
    }
}