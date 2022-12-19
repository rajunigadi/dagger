package com.raju.dagger.di.modules

import com.raju.dagger.di.scopes.PerActivity
import com.raju.dagger.presentation.activities.FirstActivity
import com.raju.dagger.presentation.activities.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindFirstActivity(): FirstActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindSecondActivity(): SecondActivity
}