package com.raju.dagger.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.raju.dagger.utils.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContexts(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideDataManager(sharedPreferences: SharedPreferences): DataManager =
        DataManager(sharedPreferences)
}