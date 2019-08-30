package com.anil.telstraassignment

import com.anil.telstraassignment.di.AppComponent
import com.anil.telstraassignment.di.AppModule
import com.anil.telstraassignment.di.DaggerAppComponent

class UiTestMyApplication : MyApplication() {

    companion object {
        private lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this))
            .networkModule(NetworkTestModule())
        .build()
    }
}