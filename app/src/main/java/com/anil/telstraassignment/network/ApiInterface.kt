package com.anil.telstraassignment.network

import com.anil.telstraassignment.data.ItemAboutCanada
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getAboutCanadaData(): Observable<ItemAboutCanada>
}