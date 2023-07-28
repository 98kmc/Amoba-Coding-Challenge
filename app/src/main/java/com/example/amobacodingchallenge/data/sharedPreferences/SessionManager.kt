package com.example.amobacodingchallenge.data.sharedPreferences

import android.content.SharedPreferences
import javax.inject.Inject

class SessionManager @Inject constructor(
    private val sharePrefers: SharedPreferences
) {

    fun saveAuthToken(token: String) = sharePrefers
        .edit()
        .putString(TOKEN_KEY, token)
        .apply()

    fun getAuthToken(): String? = sharePrefers.getString(TOKEN_KEY, null)

    companion object {
        const val TOKEN_KEY = "tokenKey"
    }
}