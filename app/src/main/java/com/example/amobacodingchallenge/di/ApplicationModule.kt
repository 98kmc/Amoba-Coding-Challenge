package com.example.amobacodingchallenge.di

import com.example.amobacodingchallenge.data.networking.ApiDataManagerRepresentable
import com.example.amobacodingchallenge.data.networking.MockDataManager
import com.example.amobacodingchallenge.domain.repositories.PatientsRepository
import com.example.amobacodingchallenge.domain.repositories.RepositoryRepresentable
import com.example.amobacodingchallenge.domain.use_cases.PatientUseCases
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

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

    @Provides
    @Singleton
    fun providePatientDataManager():
            ApiDataManagerRepresentable {
        return MockDataManager()
    }
}