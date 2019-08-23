package com.anil.telstraassignment

import com.anil.telstraassignment.di.NetworkModule
import com.anil.telstraassignment.network.ApiInterface
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkTestModule : NetworkModule() {

    @Provides
    override fun provideBaseUrl(): String = "http://localhost:8080/"

    @Singleton
    @Provides
    override fun provideHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        return client.build()
    }

    @Singleton
    @Provides
    override fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    override fun provideCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    override fun provideRetrofit(baseUrl: String,
                                 converter: GsonConverterFactory,
                                 client: OkHttpClient,
                                 adapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).client(client).addConverterFactory(converter).addCallAdapterFactory(adapterFactory).build()
    }

    @Provides
    override fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}