package com.applab.ktmvvm.ui.base.mvp.interactor

/**
 * Created by Arun Antoney.
 */
interface MVPInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()

}