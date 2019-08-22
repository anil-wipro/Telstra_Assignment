package com.anil.telstraassignment.di

import android.app.Application
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun getApplication(): Application

}