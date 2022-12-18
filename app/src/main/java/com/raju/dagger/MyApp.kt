package com.raju.dagger

import android.app.Application
import android.util.Log
import com.raju.dagger.di.components.AppComponent
import com.raju.dagger.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        buildDaggerComponent()
        Log.d("MyApp", "onCreate()")
    }

    override fun androidInjector(): AndroidInjector<Any> = activityInjector

    private fun buildDaggerComponent() {
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }
}