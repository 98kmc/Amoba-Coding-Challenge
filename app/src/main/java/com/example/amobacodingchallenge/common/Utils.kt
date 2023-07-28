package com.example.amobacodingchallenge.common

class Utils {

    companion object{
        fun getIdFromDocumentName(documentName: String?): String {
            if (documentName.isNullOrEmpty()) return ""
            val lastSlashPosition = documentName.lastIndexOf("/")
            return documentName.substring(lastSlashPosition + 1)
        }
    }
}