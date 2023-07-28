package com.example.amobacodingchallenge.di

import android.content.Context
import com.example.amobacodingchallenge.common.Constants
import com.example.amobacodingchallenge.data.authentication.firestore_auth.AuthInterceptor
import com.example.amobacodingchallenge.data.networking.retrofit_services.FirebaseRetrofitService.*
import com.example.amobacodingchallenge.data.sharedPreferences.SessionManager
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
    fun provideAuthInterceptor(sessionManager: SessionManager) =
        AuthInterceptor(sessionManager)

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
    fun provideFirestoreRetrofitService(
        retrofitBuilder: Retrofit.Builder
    ): FirestoreRetrofitService =
        retrofitBuilder
            .baseUrl(Constants.FIRESTORE_BASE_URL)
            .build()
            .create(FirestoreRetrofitService::class.java)

    @Singleton
    @Provides
    fun provideFirebaseAuthRetrofitService(
        retrofitBuilder: Retrofit.Builder
    ): FirebaseAuthRetrofitService =
        retrofitBuilder
            .baseUrl(Constants.FIRESTORE_BASE_URL)
            .build()
            .create(FirebaseAuthRetrofitService::class.java)


}