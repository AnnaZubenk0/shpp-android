package com.example.firstapp

interface PreferenceManager {
    companion object {
        const val DATA_STORE_NAME = "myapp.pref"
        const val KEY_NAME_LOGIN = "myapp.login"
    }

    fun saveUser(user: User)
    fun getLogin(): String
    fun clearLogin()
}