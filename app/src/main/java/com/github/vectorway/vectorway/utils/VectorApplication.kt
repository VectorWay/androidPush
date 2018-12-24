package com.github.vectorway.vectorway.utils

import android.app.Application
import android.content.Context

class VectorApplication: Application(){
    init {
        instance = this
    }
    companion object {
        private var instance: VectorApplication? = null

        fun getContext(): Context {
            return instance!!.applicationContext
        }
    }

}