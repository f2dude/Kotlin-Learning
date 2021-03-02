package com.sp.interfaces

import android.util.Log
import com.sp.classes.Person

interface PersonInfoProvider {

    val providerInfo: String

    fun printInfo(person: Person)

    fun defaultInfo() {
        Log.d("PersonInfoProvider", providerInfo)
    }
}