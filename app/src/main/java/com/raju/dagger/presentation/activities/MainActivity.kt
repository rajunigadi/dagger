package com.raju.dagger.presentation.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raju.dagger.R
import com.raju.dagger.utils.DataManager
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this) // instead of getApplication().getComponent().inject(this)

        dataManager.setIntValue("test", 100)
        val readData = dataManager.getIntValue("test", -1)
        Log.d("raju", "readData: $readData")
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}