package com.sp.classes


enum class EntityType {
    EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

interface IdProvider {
    fun getId(): String
}


class Entity private constructor(val id: String) {

    //Companion objects are used to access private entities

    companion object Factory {
        fun create() = Entity("id")
    }

//    companion object Factory : IdProvider {
//
//        const val id = "id"
//        fun create() = Entity(getId())
//
//        override fun getId(): String {
//            return "123"
//        }
//    }
}