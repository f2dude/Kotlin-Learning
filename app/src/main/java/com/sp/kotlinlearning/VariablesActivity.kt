package com.sp.kotlinlearning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sp.kotlinlearning.databinding.ActivityVariablesBinding

class VariablesActivity : AppCompatActivity() {

    private val TAG: String = this.javaClass.simpleName
    private val mNewLine = "\n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityVariablesBinding = DataBindingUtil.setContentView(this, R.layout.activity_variables)

        //Set title
        setTitle(R.string.variables)

        binding.data.text = readVariables()
    }

    /**
     * This is about variables
     */
    private fun readVariables(): String {
        val finalString: StringBuilder = StringBuilder()

        val name: String = "Vision"
        val age: Int = 35
        var sentence: String? = null
        sentence = "Wife name is Wanda "
        sentence += "and son's name is Thor"

        Log.d(TAG, "Name: $name")
        finalString.append(name)
        finalString.append(mNewLine)
        Log.d(TAG, "Age: $age")
        finalString.append(age)
        finalString.append(mNewLine)
        Log.d(TAG, "Additional info: $sentence")

        finalString.append(sentence)
        finalString.append(mNewLine)

        when (age) {
            in 1..34 -> {
                Log.d(TAG, "Age is below 35")
                finalString.append("Age is below 35")
            }
            in 35..65 -> {
                Log.d(TAG, "Age is above 35")
                finalString.append("Age is above 35")
            }
            else -> {
                Log.d(TAG, "Old fellow!")
                finalString.append("Old fellow!")
            }
        }
        return finalString.toString()
    }
}