package com.applab.crackinterview.ui.base.mvvm

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection

/**
 * Created by Arun Antoney on 29-07-2018.
 */
abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel<*>> : Fragment(), BindingInteractor<V>, BaseView {
    private var mActivity: BaseActivity<*, *>? = null
    private var mRootView: View? = null
    private var mViewModel: V? = null
    private var mViewDataBinding: T? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context as BaseActivity<*, *>?
            this.mActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    fun getBaseActivity(): BaseActivity<*, *>? {
        return mActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    private fun performDI() {
        AndroidSupportInjection.inject(this);
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false)
        mRootView = mViewDataBinding?.getRoot()
        return mRootView
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding?.executePendingBindings()
    }

    override fun showLoading() {
        mActivity?.showLoading();
    }

    override fun hideLoading() {
        mActivity?.hideLoading()
    }

    override fun hideKeyboard() {
        mActivity?.hideKeyboard()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }


}