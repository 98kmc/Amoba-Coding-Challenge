package com.example.amobacodingchallenge.di

import android.content.Context
import com.example.amobacodingchallenge.data.authentication.AuthInterceptor
import com.example.amobacodingchallenge.data.networking.AuthApiRepresentable
import com.example.amobacodingchallenge.data.networking.FirestoreApiRepresentable
import com.example.amobacodingchallenge.di.config.ApiConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): HttpLoggingInterceptor {
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(@ApplicationContext context: Context) =
        AuthInterceptor(context)

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideFirestoreApiRepresentable(
        retrofitBuilder: Retrofit.Builder
    ): FirestoreApiRepresentable =
        retrofitBuilder
            .baseUrl(ApiConfig.FIRESTORE_BASE_URL)
            .build()
            .create(FirestoreApiRepresentable::class.java)

    @Singleton
    @Provides
    fun provideAuthApiRepresentable(
        retrofitBuilder: Retrofit.Builder
    ): AuthApiRepresentable =
        retrofitBuilder
            .baseUrl(ApiConfig.FIRESTORE_BASE_URL)
            .build()
            .create(AuthApiRepresentable::class.java)


}