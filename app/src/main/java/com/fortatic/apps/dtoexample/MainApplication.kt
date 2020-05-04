package com.fortatic.apps.dtoexample

import android.app.Application
import timber.log.Timber

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Tree())
        }
    }
}
class Tree: Timber.DebugTree(){
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, "$tag FATAL", message, t)
    }
}