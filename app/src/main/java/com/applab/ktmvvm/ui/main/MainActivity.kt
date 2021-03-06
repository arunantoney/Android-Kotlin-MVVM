package com.applab.ktmvvm.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.applab.ktmvvm.BR
import com.applab.ktmvvm.R
import com.applab.ktmvvm.databinding.ActivityMainBinding
import com.applab.ktmvvm.ui.base.mvvm.BaseActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {


//    @Inject
//    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory
    private var mActivityMainBinding: ActivityMainBinding? = null
    private var mMainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = getViewDataBinding()
        mMainViewModel?.setNavigator(this)
    }

    override fun openHomePage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    override fun getViewModel(): MainViewModel {
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)
        return mMainViewModel as MainViewModel
    }

    override fun getBindingVariable(): Int {
   return BR.viewModel;
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }
}
