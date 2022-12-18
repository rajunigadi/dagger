package com.raju.dagger.di.components

import android.app.Application
import com.raju.dagger.MyApp
import com.raju.dagger.di.modules.ActivityBuilderModule
import com.raju.dagger.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(myApp: MyApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}