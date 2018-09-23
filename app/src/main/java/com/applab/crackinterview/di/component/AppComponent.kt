package com.applab.crackinterview.di.component

import android.app.Application
import com.applab.crackinterview.CIApp
import com.applab.crackinterview.di.builder.ActivityBuilder
import com.applab.crackinterview.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Arun Antoney on 29-07-2018.
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class),(AppModule::class),(ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app:CIApp)
}