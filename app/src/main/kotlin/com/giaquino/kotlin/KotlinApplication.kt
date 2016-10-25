package com.giaquino.kotlin

import android.app.Application
import com.giaquino.kotlin.component.ApplicationComponent
import com.giaquino.kotlin.component.DaggerApplicationComponent
import com.giaquino.kotlin.component.module.AppModule

/**
 * @author Gian Darren Aquino
 */
class KotlinApplication : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}

