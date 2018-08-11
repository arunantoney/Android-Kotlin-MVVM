package com.applab.crackinterview.di.module

import android.app.Application
import android.content.Context
import com.applab.crackinterview.data.preference.AppPreferenceHelper
import com.applab.crackinterview.data.preference.PreferenceHelper
import com.applab.crackinterview.di.PreferenceInfo
import com.applab.crackinterview.util.AppConstants
import com.applab.crackinterview.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Arun Antoney on 29-07-2018.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(context: Application): Context = context

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

}