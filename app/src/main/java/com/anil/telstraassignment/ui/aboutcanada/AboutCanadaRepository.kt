package com.anil.telstraassignment.ui.aboutcanada

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.anil.telstraassignment.data.ItemAboutCanada
import com.anil.telstraassignment.network.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AboutCanadaRepository
@Inject
constructor(private val apiInterface: ApiInterface) {

    private val aboutCanadaResult: MutableLiveData<ItemAboutCanada> = MutableLiveData()

    fun getAboutCanadaDataFromAPI(): MutableLiveData<ItemAboutCanada> {

        apiInterface.getAboutCanadaData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveDataStart() }
            .doOnTerminate { onRetrieveDataFinish() }
            .subscribe(
                { result -> onRetrieveDataSuccess(result) },
                { error -> onRetrieveDataError(error) }
            )

        return aboutCanadaResult
    }

    private fun onRetrieveDataError(error: Throwable?) {
        Log.d("Hello", error.toString())
    }

    private fun onRetrieveDataSuccess(result: ItemAboutCanada?) {
        aboutCanadaResult.value = result
    }

    private fun onRetrieveDataFinish() {
    }

    private fun onRetrieveDataStart() {
    }

}