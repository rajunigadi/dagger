package com.raju.dagger.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raju.dagger.databinding.ActivityFirstBinding
import com.raju.dagger.di.scopes.PerActivity
import com.raju.dagger.utils.DataManager
import dagger.Binds
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import javax.inject.Named

class FirstActivity : AppCompatActivity(), HasAndroidInjector {

    private lateinit var binding: ActivityFirstBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    @Named("data_manager_1")
    lateinit var dataManager: DataManager

    //@Inject
    //@Named("ActivityContext")
    //lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AndroidInjection.inject(this) // instead of getApplication().getComponent().inject(this)

        dataManager.setIntValue("test", 100)
        val readData = dataManager.getIntValue("test", -1)
        Log.d("FirstActivity", "readData: $readData")
        binding.textView.text = "Hello, First Activity, dataManager is $dataManager"
        //binding.textView.text = "Hello, First Activity, context is $context"

        binding.textView.setOnClickListener {
            Intent(this@FirstActivity, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}