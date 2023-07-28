package com.example.amobacodingchallenge.domain.use_cases

import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable.PatientUseCasesRepresentable
import com.example.amobacodingchallenge.domain.repositories.RepositoryRepresentable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class PatientUseCases @Inject constructor(
    private val repository: RepositoryRepresentable.PatientsRepositoryRepresentable
) : PatientUseCasesRepresentable {
    override fun getAllPatients(): Flow<Resource<List<Patient>>> = flow {
        try {
            emit(Resource.Loading())
            val patientList = repository.fetchAllPatients()
            emit(Resource.Success(patientList))
        } catch (error: IOException) {
            emit(Resource.Failure("No internet Access"))
        } catch (error: Exception) {
            emit(Resource.Failure(error.message.toString()))
        }
    }

//    override fun getPatientById(patientId: String): Flow<Resource<Patient>> = flow {
//        try {
//            emit(Resource.Loading())
//            val patient = repository.fetchPatientById(patientId)
//            emit(Resource.Success(patient))
//        } catch (error: IOException) {
//            emit(Resource.Failure("No internet Access"))
//        } catch (error: Exception) {
//            emit(Resource.Failure(error.message.toString()))
//        }
//    }
}