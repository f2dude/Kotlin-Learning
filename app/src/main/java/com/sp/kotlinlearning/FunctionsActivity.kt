package com.sp.kotlinlearning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sp.kotlinlearning.databinding.ActivityFunctionsBinding

class FunctionsActivity : AppCompatActivity() {

    private val mNewLine = "\n"
    private val mDataString = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityFunctionsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_functions)

        //Set title
        setTitle(R.string.functions)

        mDataString.append(getGreeting())
            .append(mNewLine)
            .append(anotherGreeting())
            .append(mNewLine)
            .append(returnNull())
            .append(mNewLine)
            .append(sayHello("Hello", "John"))
            .append(mNewLine)
            .append(sayHello("Hi", "Tom"))
            .append(mNewLine)
            .append(greetPerson(name = "Saikrishna", greeting = "Hi"))
            .append(mNewLine)
            .append(greetPerson(name = "Olivia"))
            .append(mNewLine)
            .append(greetPerson())
        binding.functionsData.text = mDataString.toString()
    }

    /**
     * Function with return statement
     */
    private fun getGreeting(): String {
        return "Hey Tom, How you doing?"
    }

    private fun anotherGreeting(): String = "Tom, Good morning again!"

    /**
     * Returning null values
     */
    private fun returnNull(): String? {
        return null
    }

    /**
     * Function with default values
     */
    private fun greetPerson(greeting: String = "Hello", name: String = "Nate"): String {
        return "$greeting $name"
    }

    /**
     * Function with parameters
     */
    private fun sayHello(greeting: String, itemToGreet: String): String = "$greeting $itemToGreet"
}