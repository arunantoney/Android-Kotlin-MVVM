package com.applab.crackinterview.ui.base.mvvm

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.applab.crackinterview.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by Arun Antoney on 29-07-2018.
 */
abstract class BaseViewModel<N>(protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : ViewModel(),BaseViewModelInteractor<N> {
    private var mNavigator: WeakReference<N>? = null
    private val mIsLoading = ObservableBoolean(false)

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    override fun getCompositeDisposables(): CompositeDisposable {
        return compositeDisposable;
    }

    override fun getNavigator():N? {
      return mNavigator?.get()
    }

    override fun getIsLoading(): ObservableBoolean {
       return mIsLoading;
    }

    override fun setNavigator( navigator:N) {
        this.mNavigator = WeakReference(navigator)
    }

    override fun setIsLoading(isLoading: Boolean) {
       mIsLoading.set(isLoading);
    }

    override fun getScheduleProvider(): SchedulerProvider {
        return schedulerProvider;
    }
}