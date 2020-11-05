package com.olehmesh.repository.di.components

import com.olehmesh.repository.KeyedDataSource
import com.olehmesh.repository.di.modules.NetworkModule
import com.olehmesh.repository.di.scopes.ApiScope
import dagger.Component

@ApiScope
@Component(modules = [NetworkModule::class])
interface AppComponent {

    //fun inject(mainFragment: MainFragment)
    fun inject(keyedDataSource: KeyedDataSource)
}