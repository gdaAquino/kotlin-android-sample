package com.giaquino.kotlin.component.module

import com.giaquino.kotlin.KotlinApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Gian Darren Aquino
 */
@Module class AppModule {

    val application: KotlinApplication

    constructor(application: KotlinApplication) {
        this.application = application
    }

    @Provides @Singleton fun providesApplication(): KotlinApplication {
        return application
    }
}