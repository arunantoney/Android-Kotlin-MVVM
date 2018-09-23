package com.applab.ktmvvm.ui.base.mvp.interactor

import com.applab.ktmvvm.data.preference.PreferenceHelper


/**
 * Created by Arun Antoney.
 */
open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper

    constructor(preferenceHelper: PreferenceHelper) : this() {
        this.preferenceHelper = preferenceHelper
    }

    override fun isUserLoggedIn() :Boolean{
         return true;
    }

    override fun performUserLogout() = preferenceHelper.let {

    }

}