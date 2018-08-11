package com.applab.crackinterview.ui.base.mvp.presenter

import com.applab.crackinterview.ui.base.mvp.interactor.MVPInteractor
import com.applab.crackinterview.ui.base.mvp.view.MVPView

/**
 * Created by Arun Antoney.
 */
interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}