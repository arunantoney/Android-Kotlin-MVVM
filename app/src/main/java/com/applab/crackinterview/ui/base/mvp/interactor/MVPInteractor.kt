package com.applab.crackinterview.ui.base.mvp.interactor

/**
 * Created by Arun Antoney.
 */
interface MVPInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()

}