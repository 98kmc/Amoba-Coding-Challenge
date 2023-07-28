package com.example.amobacodingchallenge.di

import android.content.Context
import android.content.SharedPreferences
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.data.networking.ApiDataManagerRepresentable
import com.example.amobacodingchallenge.data.networking.MockDataManager
import com.example.amobacodingchallenge.data.sharedPreferences.SessionManager
import com.example.amobacodingchallenge.domain.repositories.PatientsRepository
import com.example.amobacodingchallenge.domain.repositories.RepositoryRepresentable
import com.example.amobacodingchallenge.domain.use_cases.PatientUseCases
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideSharePreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun provideSessionManager(sharedPreferences: SharedPreferences): SessionManager =
        SessionManager(sharedPreferences)

    @Provides
    @Singleton
    fun providePatientUseCases(repository: RepositoryRepresentable.PatientsRepositoryRepresentable):
            UseCasesRepresentable.PatientUseCasesRepresentable {
        return PatientUseCases(repository)
    }

    @Provides
    @Singleton
    fun providePatientRepository(dataManager: ApiDataManagerRepresentable):
            RepositoryRepresentable.PatientsRepositoryRepresentable {
        return PatientsRepository(dataManager)
    }

//    @Provides
//    @Singleton
//    fun providePatientDataManager():
//            ApiDataManagerRepresentable {
//        return MockDataManager()
//    }
}