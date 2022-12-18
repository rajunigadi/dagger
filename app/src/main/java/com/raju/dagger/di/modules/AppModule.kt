package com.raju.dagger.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.raju.dagger.utils.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
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
    @Named("shared_pref_1")
    fun provideSharedPreferences1(context: Context): SharedPreferences =
        context.getSharedPreferences("shared_pref_1", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    @Named("shared_pref_2")
    fun provideSharedPreferences2(context: Context): SharedPreferences =
        context.getSharedPreferences("shared_pref_2", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    @Named("data_manager_1")
    fun provideDataManager1(@Named("shared_pref_1") sharedPreferences: SharedPreferences): DataManager =
        DataManager(sharedPreferences)

    @Provides
    @Singleton
    @Named("data_manager_2")
    fun provideDataManager2(@Named("shared_pref_2") sharedPreferences: SharedPreferences): DataManager =
        DataManager(sharedPreferences)
}