package com.applab.ktmvvm.ui.base.mvvm

import android.databinding.ObservableBoolean
import com.applab.ktmvvm.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Arun Antoney on 29-07-2018.
 */
interface BaseViewModelInteractor<N> {
    fun getCompositeDisposables():CompositeDisposable
    fun getScheduleProvider():SchedulerProvider
    fun getNavigator():N?
    fun getIsLoading():ObservableBoolean
    fun setNavigator( navigator:N)
    fun setIsLoading(isLoading:Boolean);
}