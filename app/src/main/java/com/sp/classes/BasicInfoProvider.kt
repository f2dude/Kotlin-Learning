package com.sp.classes

import android.util.Log
import com.sp.interfaces.PersonInfoProvider
import com.sp.interfaces.SessionInfoProvider

open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {

    private val tag: String = this.javaClass.simpleName
    protected open val sessionIdPrefix: String = "Session"

    override val providerInfo: String
        get() = "BasicInfoProvider Default"

    override fun printInfo(person: Person) {
        Log.d(tag, "BasicInfoProvider")
        person.printInfo()
    }

    override fun defaultInfo() {
        super.defaultInfo()
        Log.d(tag, "Additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }

    fun checkTypes(infoProvider: PersonInfoProvider) {
        if (infoProvider !is SessionInfoProvider) {
            Log.d(tag, "not a Session info provider")
        } else {
            Log.d(tag, "is a session info provider")
            infoProvider.getSessionId()//Compiler performs a smart cast
        }
    }
}