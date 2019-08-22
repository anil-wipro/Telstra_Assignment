package com.anil.telstraassignment.ui.aboutcanada

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.anil.telstraassignment.R
import com.anil.telstraassignment.data.ItemAboutCanada
import com.anil.telstraassignment.network.ApiInterface
import com.anil.telstraassignment.network.InternetCheck
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AboutCanadaRepository
@Inject
constructor(private val apiInterface: ApiInterface, private val internetCheck: InternetCheck) {

    private val aboutCanadaResult: MutableLiveData<ItemAboutCanada> = MutableLiveData()
    private val loadingState: MutableLiveData<Int> = MutableLiveData()
    private val errorMessage: MutableLiveData<Int> = MutableLiveData()

    // get api data
    fun getAboutCanadaDataFromAPI(): MutableLiveData<ItemAboutCanada> {

        when (internetCheck.isNetworkAvailable()) {

            true -> {
                apiInterface.getAboutCanadaData().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { onRetrieveDataStart() }
                    .doOnTerminate { onRetrieveDataFinish() }
                    .subscribe(
                        { result -> onRetrieveDataSuccess(result) },
                        { error -> onRetrieveDataError(error) }
                    )
            }
            false -> {
                errorMessage.value = R.string.internet_unavailable
            }
        }



        return aboutCanadaResult
    }

    // get loading state
    fun getLoadingState(): MutableLiveData<Int> {
        return loadingState
    }

    // get error message
    fun getErrorMessage(): MutableLiveData<Int> {
        return errorMessage
    }

    private fun onRetrieveDataError(error: Throwable?) {
        errorMessage.value = R.string.something_wrong
    }

    private fun onRetrieveDataSuccess(result: ItemAboutCanada?) {
        aboutCanadaResult.value = result
    }

    private fun onRetrieveDataFinish() {
        loadingState.value = View.GONE
    }

    private fun onRetrieveDataStart() {
        errorMessage.value = null
        loadingState.value = View.VISIBLE
    }

}