package com.applab.ktmvvm.ui.main

import android.arch.lifecycle.ViewModelProvider
import com.applab.ktmvvm.ViewModelProviderFactory
import com.applab.ktmvvm.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Arun Antoney on 30-07-2018.
 */
@Module
class MainActivityModule {

    @Provides
    internal fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory =
         ViewModelProviderFactory(mainViewModel)


    @Provides
    internal fun provideMainViewModel( schedulerProvider: SchedulerProvider,compositeDisposable: CompositeDisposable): MainViewModel =
         MainViewModel( schedulerProvider,compositeDisposable)

}