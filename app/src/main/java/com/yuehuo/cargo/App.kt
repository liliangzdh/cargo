package com.yuehuo.cargo

import android.app.Application
import com.baseHelp.mvvmbase.CommonApplication

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        CommonApplication.init(this)

    }
}