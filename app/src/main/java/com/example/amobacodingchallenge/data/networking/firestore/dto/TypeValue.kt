package com.example.amobacodingchallenge.data.networking.firestore.dto

data class IntegerValue (
    val integerValue: Int? = null,
)

data class StringValue (
    val stringValue: String? = null,
)

data class MapValue<T> (
    val mapValue: Fields<T>? = null
)

data class Fields<T> (
    val fields: T? = null
)