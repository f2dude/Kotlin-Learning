package com.sp.classes

import android.text.TextUtils
import android.util.Log

class Person(val firstName: String = "Peter", val lastName: String = "Parker") {

    private val tag: String = this.javaClass.simpleName

    init {
        Log.d(tag, "init 1")
    }

    constructor() : this("Peter", "Parker") {
        Log.d(tag, "Secondary constructor $firstName $lastName")
    }

    init {
        Log.d(tag, "init 2")
    }

    var nickName: String? = null
        set(value) {
            field = value
            Log.d(tag, "The new nick name is $value")
        }
        get() {
            Log.d(tag, "The returned value is $field")
            return field
        }

    fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname" //Elvis operator
        Log.d(tag, "$firstName ($nickNameToPrint) $lastName")
    }
}