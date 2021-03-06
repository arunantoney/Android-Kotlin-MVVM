package com.applab.ktmvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by Arun Antoney on 30-07-2018.
 */
class ViewModelProviderFactory<V:Any>() : ViewModelProvider.Factory {

    private lateinit var viewModel: V

    constructor(viewModel: V) : this() {
        this.viewModel = viewModel

    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
            return  viewModel as T;
        }
        throw IllegalArgumentException("Unknown class name")
    }
}