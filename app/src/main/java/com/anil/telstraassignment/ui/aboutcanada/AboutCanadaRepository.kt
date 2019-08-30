package com.anil.telstraassignment.ui.aboutcanada

import androidx.lifecycle.MutableLiveData
import com.anil.telstraassignment.R
import com.anil.telstraassignment.data.ApiResponseHandler
import com.anil.telstraassignment.data.ApiState
import com.anil.telstraassignment.data.ItemAboutCanada
import com.anil.telstraassignment.network.ApiInterface
import com.anil.telstraassignment.network.InternetCheck
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AboutCanadaRepository
@Inject
constructor(private val apiInterface: ApiInterface, private val internetCheck: InternetCheck) {

    private val aboutCanadaResult: MutableLiveData<ApiResponseHandler> = MutableLiveData()

    // get api data
    fun getAboutCanadaDataFromAPI(isPullRefresh: Boolean): MutableLiveData<ApiResponseHandler> {
        when (internetCheck.isNetworkAvailable()) {
            true -> {
                apiInterface.getAboutCanadaData().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { onRetrieveDataStart(isPullRefresh) }
                    .subscribe(
                        { result -> onRetrieveDataSuccess(result) },
                        { onRetrieveDataError() }
                    )
            }
            false -> {
                aboutCanadaResult.value = ApiResponseHandler(ApiState.ERROR, R.string.internet_unavailable, null)
            }
        }
        return aboutCanadaResult
    }

    private fun onRetrieveDataError() {
        aboutCanadaResult.value = ApiResponseHandler(ApiState.ERROR, R.string.something_wrong, null)
    }

    private fun onRetrieveDataSuccess(result: ItemAboutCanada?) {
        aboutCanadaResult.value = ApiResponseHandler(ApiState.SUCCESS, null, result)
    }

    private fun onRetrieveDataStart(isPullRefresh: Boolean) {
        aboutCanadaResult.value = ApiResponseHandler(ApiState.LOADING(isPullRefresh), null, null)
    }

}