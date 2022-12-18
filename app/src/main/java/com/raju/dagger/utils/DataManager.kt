package com.raju.dagger.utils

import android.content.SharedPreferences

class DataManager(private val sharedPreferences: SharedPreferences) {

    fun getBooleanValue(key: String, def: Boolean): Boolean =
        sharedPreferences.getBoolean(key, def)

    fun setBooleanValue(key: String, value: Boolean) =
        sharedPreferences.edit()?.putBoolean(key, value)?.apply()

    fun getStringValue(key: String, default: String): String =
        sharedPreferences.getString(key, default) ?: run { "" }

    fun setStringValue(key: String, value: String) =
        sharedPreferences.edit()?.putString(key, value)?.apply()

    fun getLongValue(key: String, default: Long): Long =
        sharedPreferences.getLong(key, default)

    fun setLongValue(key: String, value: Long) =
        sharedPreferences.edit()?.putLong(key, value)?.apply()

    fun getIntValue(key: String, default: Int): Int =
        sharedPreferences.getInt(key, default)

    fun setIntValue(key: String, value: Int) =
        sharedPreferences.edit()?.putInt(key, value)?.apply()
}