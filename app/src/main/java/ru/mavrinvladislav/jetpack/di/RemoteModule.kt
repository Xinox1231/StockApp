package ru.mavrinvladislav.jetpack.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mavrinvladislav.jetpack.common.RemoteConstants
import ru.mavrinvladislav.jetpack.data.remote.ApiService

@Module
interface RemoteModule {

    companion object {

        @Provides
        @ApplicationScope
        fun provideRetrofit(
            okHttpClient: OkHttpClient
        ) = Retrofit.Builder()
            .baseUrl(RemoteConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        @Provides
        @ApplicationScope
        fun provideOkHttpClient(
            loggingInterceptor: HttpLoggingInterceptor
        ) = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        @Provides
        @ApplicationScope
        fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        @Provides
        @ApplicationScope
        fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
    }
}