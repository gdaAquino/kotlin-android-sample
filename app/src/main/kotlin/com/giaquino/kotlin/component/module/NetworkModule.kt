package com.giaquino.kotlin.component.module

import android.util.Log
import com.giaquino.kotlin.KotlinApplication
import com.giaquino.kotlin.model.api.adapter.EntityAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import javax.inject.Singleton

/**
 * @author Gian Darren Aquino
 */
@Module class NetworkModule {

    @Singleton @Provides fun providesGson(): Gson {
        return GsonBuilder().registerTypeAdapterFactory(
            EntityAdapterFactory.create()).create()
    }

    @Singleton @Provides fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("OkHttp", it)
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Singleton @Provides fun providesPicasso(application: KotlinApplication,
        client: OkHttpClient): Picasso {
        return Picasso
            .Builder(application)
            .downloader(OkHttp3Downloader(client))
            .build()
    }

    @Singleton @Provides fun providesRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(client)
            .build()
    }

}
