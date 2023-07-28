package com.example.amobacodingchallenge.data.networking.firestore.dto

import com.example.amobacodingchallenge.common.Utils
import com.example.amobacodingchallenge.domain.entities.Patient

data class Document<T> (
    val name: String? = null,
    val fields: Fields<T>? = null,
    val createTime: String? = null,
    val updateTime: String? = null
) {

    companion object {
        fun Document<PatientDTO>.toPatientObject(): Patient {
            return Patient(
                id = Utils.getIdFromDocumentName(name),
                name = fields?.fields?.name?.stringValue ?: "",
                image = fields?.fields?.image?.stringValue ?: ""
            )
        }
    }

}
