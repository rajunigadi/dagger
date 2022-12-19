package com.raju.dagger.presentation.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raju.dagger.databinding.ActivitySecondBinding
import com.raju.dagger.utils.DataManager
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import javax.inject.Named

class SecondActivity : AppCompatActivity(), HasAndroidInjector {

    private lateinit var binding: ActivitySecondBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    @Named("data_manager_2")
    lateinit var dataManager: DataManager

    //@Inject
    //@Named("ActivityContext")
    //lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AndroidInjection.inject(this) // instead of getApplication().getComponent().inject(this)

        val readData = dataManager.getIntValue("test", -1)
        Log.d("SecondActivity", "readData: $readData")
        binding.textView.text = "Hello, Second Activity, dataManager is $dataManager"
        //binding.textView.text = "Hello, First Activity, context is $context"
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}