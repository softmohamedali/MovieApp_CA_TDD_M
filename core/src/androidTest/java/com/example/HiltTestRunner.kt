package com.example

import android.app.Application
import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner

//TODO
//note whenyou wnt to use this runner dont forget to change the runner inside build.gradle
//testInstrumentationRunner "your pakage"

class HiltTestRunner:AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl,HiltTestRunner::class.java.name, context)
    }
}