package com.applab.ktmvvm.di.module

import android.app.Application
import android.content.Context
import com.applab.ktmvvm.data.preference.AppPreferenceHelper
import com.applab.ktmvvm.data.preference.PreferenceHelper
import com.applab.ktmvvm.di.PreferenceInfo
import com.applab.ktmvvm.util.AppConstants
import com.applab.ktmvvm.util.SchedulerProvider
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