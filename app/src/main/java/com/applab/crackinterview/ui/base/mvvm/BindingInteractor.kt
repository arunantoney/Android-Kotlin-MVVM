package com.applab.crackinterview.ui.base.mvvm

import android.support.annotation.LayoutRes

/**
 * Created by Arun Antoney on 29-07-2018.
 */
interface BindingInteractor<V> {

     fun getViewModel(): V

     fun getBindingVariable(): Int

    @LayoutRes
     fun getLayoutId(): Int

}