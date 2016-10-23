package com.giaquino.kotlin.component

import com.giaquino.kotlin.component.module.ApiModule
import com.giaquino.kotlin.component.module.AppModule
import com.giaquino.kotlin.component.module.NetworkModule
import com.giaquino.kotlin.ui.main.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author Gian Darren Aquino
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, NetworkModule::class))
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}
