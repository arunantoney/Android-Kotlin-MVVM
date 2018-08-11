package com.applab.crackinterview.di.builder

import com.applab.crackinterview.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Arun Antoney on 29-07-2018.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity
}