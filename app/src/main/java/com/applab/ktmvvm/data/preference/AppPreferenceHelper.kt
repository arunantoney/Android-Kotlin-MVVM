package com.applab.ktmvvm.data.preference

import android.content.Context
import com.applab.ktmvvm.di.PreferenceInfo

/**
 * Created by Arun Antoney on 29-07-2018.
 */
class AppPreferenceHelper constructor(context:Context,@PreferenceInfo private val prefName:String  ): PreferenceHelper{

    companion object {
        private val APP_VERSION="APP_VERSION";
    }
    override fun getCurrentAppVersion(): String {
        return mPref.getString(APP_VERSION,"1.0");
    }

    private val mPref=context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
}