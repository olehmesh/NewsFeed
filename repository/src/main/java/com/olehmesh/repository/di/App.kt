package com.olehmesh.repository.di

import android.app.Application
import com.olehmesh.repository.di.components.AppComponent
import com.olehmesh.repository.di.components.DaggerAppComponent
import com.olehmesh.repository.di.modules.NetworkModule

class App : Application() {

    companion object {

        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }

}