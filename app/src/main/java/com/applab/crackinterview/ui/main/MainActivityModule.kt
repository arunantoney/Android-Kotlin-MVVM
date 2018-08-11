package com.applab.crackinterview.ui.main

import android.arch.lifecycle.ViewModelProvider
import com.applab.crackinterview.ViewModelProviderFactory
import com.applab.crackinterview.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Arun Antoney on 30-07-2018.
 */
@Module
class MainActivityModule {

    @Provides
    internal fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

    @Provides
    internal fun provideMainViewModel( schedulerProvider: SchedulerProvider,compositeDisposable: CompositeDisposable): MainViewModel {
        return MainViewModel( schedulerProvider,compositeDisposable)
    }
}