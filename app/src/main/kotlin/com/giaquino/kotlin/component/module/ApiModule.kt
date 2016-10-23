package com.giaquino.kotlin.component.module

import com.giaquino.kotlin.model.api.GithubApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Gian Darren Aquino
 */

@Module class ApiModule {

    @Singleton @Provides fun providesGithubApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }
}
