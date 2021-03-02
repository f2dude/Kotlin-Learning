package com.sp.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.sp.kotlinlearning.databinding.ActivityCollectionsBinding

class CollectionsActivity : AppCompatActivity() {

    private val tag: String = this.javaClass.simpleName
    private val mNewLine = "\n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCollectionsBinding = DataBindingUtil.setContentView(this, R.layout.activity_collections)

        binding.collectionsData.text = collections()
    }

    /**
     * Collections
     */
    private fun collections() : String {
        val builder:StringBuilder = StringBuilder()
        builder.append("-----Arrays-----")
        builder.append(mNewLine)
        Log.d(tag, "-----Arrays-----")
        val interestingThings = arrayOf("Kotlin", "Programming", "Comic books")
        Log.d(tag, "Size of array is ${interestingThings.size}")

        builder.append("Size of array is ${interestingThings.size}")
        builder.append(mNewLine)

        for (interestingThing in interestingThings) {
            Log.d(tag, interestingThing)
            builder.append(interestingThing)
            builder.append(mNewLine)
        }

        //Another way of iterating through array
        interestingThings.forEach { interestingThing -> Log.d(tag, interestingThing) }

        //Another way of iterating through array using index position
        interestingThings.forEachIndexed { index, interestingThing ->
            Log.d(
                tag,
                "$interestingThing is at index $index"
            )
            builder.append("$interestingThing is at index $index")
            builder.append(mNewLine)
        }
        builder.append("-----List-----")
        builder.append(mNewLine)
        Log.d(tag, "-----List-----")
        val anotherThings = listOf("Kotlin", "Programming", "Comic books")//This is immutable
        anotherThings.forEach { anotherThing ->
            Log.d(tag, anotherThing)
            builder.append(anotherThing)
            builder.append(mNewLine)
        }

        Log.d(tag, "-----In reversed order-----")
        builder.append("-----In reversed order-----")
        builder.append(mNewLine)
        anotherThings.asReversed().forEach{anotherThing ->
            Log.d(tag, anotherThing)
            builder.append(anotherThing)
            builder.append(mNewLine)
        }

        Log.d(tag, "-----Map-----")
        builder.append("-----Map-----")
        builder.append(mNewLine)
        val map = mapOf(1 to "a", 2 to "b", 3 to "c")//This is immutable
        map.forEach { (key, value) ->
            Log.d(tag, "$key -> $value")
            builder.append("Key: $key -> Value: $value")
            builder.append(mNewLine)
        }

        val animals = mutableListOf("Cats", "Dogs", "Horses")//This is mutable
        animals.add("Lions")
        Log.d(tag, "-----Using var arg-----")
        greetPerson("Hi", *interestingThings)
        greetPerson("Hi", "Tom", "Harry", "John")
        greetPerson("Hi")//Since the method has vararg, it is not required to pass 2nd parameter

        val cars = mutableMapOf(1 to "Ford", 2 to "Toyota", 3 to "Honda")//This is mutable
        cars[4] = "Tesla"
        return builder.toString()
    }

    /**
     * Function uses var arg
     */
    private fun greetPerson(greeting: String, vararg itemToGreet: String) {
        itemToGreet.forEach { _ -> Log.d(tag, "$greeting $itemToGreet") }
    }
}