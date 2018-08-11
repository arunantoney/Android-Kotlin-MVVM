package com.applab.crackinterview.ui.base.mvp.presenter


import com.applab.crackinterview.ui.base.mvp.interactor.MVPInteractor
import com.applab.crackinterview.ui.base.mvp.view.MVPView
import com.applab.crackinterview.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Arun Antoney.
 */
abstract class BasePresenter<V : MVPView, I : MVPInteractor>
internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable)
    : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}