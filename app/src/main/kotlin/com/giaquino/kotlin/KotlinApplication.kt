package com.giaquino.kotlin

import android.app.Application
import android.content.Context
import com.giaquino.kotlin.component.ApplicationComponent
import com.giaquino.kotlin.component.DaggerApplicationComponent
import com.giaquino.kotlin.component.module.AppModule

/**
 * @author Gian Darren Aquino
 */
class KotlinApplication : Application() {

    companion object {

        fun component(context: Context): ApplicationComponent {
            return (context.applicationContext as KotlinApplication).component
        }
    }

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

}

