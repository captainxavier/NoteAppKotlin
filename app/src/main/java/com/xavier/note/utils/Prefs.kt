package com.xavier.note.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class Prefs(activity:Activity) {
//    private var PRIVATE_MODE = 0
    private val PREF_NAME = "NoteApp"
//    val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)




}