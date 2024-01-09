package com.mandiri.appmandiri.module

import android.content.Context
import android.content.SharedPreferences
import com.mandiri.appmandiri.helper.SharedPrefHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharePreferenceModule {

    private const val PREF_NAME = "my_preference"

    @Provides
    fun provideSharedPreference(@ApplicationContext appContext: Context): SharedPreferences {
        return appContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideSharedPreferencesHelper(sharedPreferences: SharedPreferences) :SharedPrefHelper {
        return SharedPrefHelper(sharedPreferences)
    }

}