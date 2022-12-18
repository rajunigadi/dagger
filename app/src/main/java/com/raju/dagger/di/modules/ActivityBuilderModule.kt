package com.raju.dagger.di.modules

import com.raju.dagger.di.scopes.PerActivity
import com.raju.dagger.presentation.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}