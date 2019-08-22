package com.anil.telstraassignment

import android.app.Application
import com.anil.telstraassignment.di.AppComponent
import com.anil.telstraassignment.di.AppModule
import com.anil.telstraassignment.di.DaggerAppComponent

class MyApplication : Application() {

    companion object {
        private lateinit var appComponent: AppComponent
        fun getAppComponent() = appComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}