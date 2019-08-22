package com.anil.telstraassignment.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class InternetCheck
@Inject constructor(private val context: Application) {

    fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected

    }
}