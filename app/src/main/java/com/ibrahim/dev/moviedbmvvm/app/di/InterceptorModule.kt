package com.ibrahim.dev.moviedbmvvm.app.di

import android.content.Context
import com.ibrahim.dev.moviedbmvvm.app.utils.Utils.hasNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File

@Module
@InstallIn(ApplicationComponent::class)
class InterceptorModule {

    @Provides
    fun providerInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun providerCache(fileCache: File) = Cache(fileCache, 10 * 1000 * 1000) //10MB Cache

    @Provides
    fun providerCacheFile(@ApplicationContext context: Context) =
        File(context.cacheDir, "okhttp_cache")

    @Provides
    fun providerOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache,
        @ApplicationContext context: Context
    ) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasNetwork(context))
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                    ).build()
                chain.proceed(request)
            }
            .build()


}