package com.raju.dagger.di.modules

import android.app.Activity
import android.content.Context
import com.raju.dagger.di.scopes.PerActivity
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class ActivityModule {

    @Binds
    @PerActivity
    @Named("ActivityContext")
    abstract fun activityContext(activity: Activity): Context
}
