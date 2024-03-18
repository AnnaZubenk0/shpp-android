package com.example.firstapp

import android.content.Context

class SharedPreferenceManager(
    private val context: Context
) : PreferenceManager {

    private val prefs =
        context.getSharedPreferences(PreferenceManager.DATA_STORE_NAME, Context.MODE_PRIVATE)

    override fun saveUser(user: User) {
        val editor = prefs.edit()
        editor.putString(PreferenceManager.KEY_NAME_LOGIN, user.email)
        editor.apply()
    }

    override fun getLogin(): String {
        return prefs.getString(PreferenceManager.KEY_NAME_LOGIN, null) ?: ""
    }

    override fun clearLogin() {
        val editor = prefs.edit()
        editor.remove(PreferenceManager.KEY_NAME_LOGIN)
        editor.apply()
    }
}