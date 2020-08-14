package com.ibrahim.dev.moviedbmvvm.app.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ibrahim.dev.moviedbmvvm.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @BaseUrl
    @Provides
    fun providerBaseUrl(@ApplicationContext context: Context) = context.getString(R.string.base_url)

    @ApiKey
    @Provides
    fun providerApiToken(@ApplicationContext context: Context) = context.getString(R.string.api_key)

    @Provides
    fun providerGson(): Gson = GsonBuilder().create()

    @Provides
    fun providerRetrofit(okHttpClient: OkHttpClient, gson: Gson, @BaseUrl url: String): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

}