package com.anil.telstraassignment.di

import com.anil.telstraassignment.BuildConfig
import com.anil.telstraassignment.network.ApiInterface
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideBaseUrl(): String = BuildConfig.HOST

    @Singleton
    @Provides
    open fun provideHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        return client.build()
    }

    @Singleton
    @Provides
    open fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    open fun provideCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    internal open fun provideRetrofit(
        baseUrl: String,
        converter: GsonConverterFactory,
        client: OkHttpClient,
        adapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).client(client).addConverterFactory(converter)
            .addCallAdapterFactory(adapterFactory).build()
    }

    @Provides
    internal open fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

}