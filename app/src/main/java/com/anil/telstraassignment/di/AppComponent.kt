package com.anil.telstraassignment.di

import android.app.Application
import com.anil.telstraassignment.network.ApiInterface
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun getApplication(): Application

    fun getApiInterface(): ApiInterface
}