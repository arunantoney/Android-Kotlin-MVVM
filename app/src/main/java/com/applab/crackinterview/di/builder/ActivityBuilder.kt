package com.applab.crackinterview.di.builder

import com.applab.crackinterview.ui.main.MainActivity
import com.applab.crackinterview.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Arun Antoney on 29-07-2018.
 */
@Module
  abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity
}