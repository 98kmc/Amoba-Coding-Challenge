package com.example.amobacodingchallenge.data.authentication

import android.content.Context
import com.example.amobacodingchallenge.R

class SessionManager(context: Context) {

    private var sharePrefers = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    fun saveAuthToken(token: String) = sharePrefers
        .edit()
        .putString(TOKEN_KEY, token)
        .apply()

    fun getAuthToken(): String? = sharePrefers.getString(TOKEN_KEY, null)

    companion object {
        const val TOKEN_KEY = "tokenKey"
    }
}