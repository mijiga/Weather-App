package com.steve.interview.dvt.weather.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.steve.interview.dvt.weather.api.WeatherAPI
import com.steve.interview.dvt.weather.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(@ApplicationContext context: Context): WeatherAPI {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .client(
                OkHttpClient()
                    .newBuilder()
                    .cache(Cache(File(context.cacheDir, "offlineCache"), 10 * 1024 * 1024))
                    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                    .build()
            )
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        return retrofit.create(WeatherAPI::class.java)
    }

    @Singleton
    @Provides
    fun providesSharePreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(context.applicationContext.toString(), AppCompatActivity.MODE_PRIVATE)
    }


}