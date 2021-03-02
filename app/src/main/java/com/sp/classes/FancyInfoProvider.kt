package com.sp.classes

class FancyInfoProvider : BasicInfoProvider() {

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "Fancy Info Provider"
}