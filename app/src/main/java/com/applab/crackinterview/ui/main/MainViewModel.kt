package com.applab.crackinterview.ui.main

import com.applab.crackinterview.ui.base.mvvm.BaseViewModel
import com.applab.crackinterview.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Arun Antoney on 30-07-2018.
 */
class MainViewModel @Inject internal constructor(s:SchedulerProvider, c:CompositeDisposable) : BaseViewModel<MainNavigator>(s,c) {


}