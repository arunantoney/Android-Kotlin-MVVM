package com.applab.ktmvvm.ui.base.mvvm

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.applab.ktmvvm.util.CommonUtil
import dagger.android.AndroidInjection

/**
 * Created by Arun Antoney on 29-07-2018.
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(), BaseView,BindingInteractor<V> ,BaseFragment.Callback{


    private  var mViewModel: V? = null;
    private  var mViewDataBinding: T?=null;
    private  var mProgressDialog: ProgressDialog?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        performDI();
        super.onCreate(savedInstanceState)
        performDB();
    }

    private fun performDB() {
        mViewDataBinding = DataBindingUtil.setContentView<T>(this, getLayoutId())
        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        mViewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding?.executePendingBindings()

    }

    fun getViewDataBinding(): T? {
        return mViewDataBinding
    }

    private fun performDI() {
        AndroidInjection.inject(this)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if ( mProgressDialog!!.isShowing()) {
            mProgressDialog?.cancel()
        }
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {
    }
}