package com.raju.dagger.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raju.dagger.databinding.ActivityFirstBinding
import com.raju.dagger.utils.DataManager
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AndroidInjection.inject(this) // instead of getApplication().getComponent().inject(this)

        dataManager.setIntValue("test", 100)
        val readData = dataManager.getIntValue("test", -1)
        Log.d("raju", "readData1: $readData")
        binding.textView.text = "Hello, First Activity, dataManager is $dataManager"

        binding.textView.setOnClickListener {
            Intent(this@FirstActivity, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}