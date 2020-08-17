package com.ibrahim.dev.moviedbmvvm.di

import com.ibrahim.dev.moviedbmvvm.data.network.TvShowApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class TvShowApiModule {

    @Provides
    fun providerTvShowApi(retrofit: Retrofit): TvShowApi = retrofit.create(TvShowApi::class.java)

}
