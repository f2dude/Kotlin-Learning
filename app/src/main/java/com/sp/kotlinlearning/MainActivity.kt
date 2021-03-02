package com.sp.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sp.classes.BasicInfoProvider
import com.sp.classes.Entity
import com.sp.classes.FancyInfoProvider
import com.sp.classes.Person
import com.sp.interfaces.PersonInfoProvider
import com.sp.kotlinlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val tag: String = this.javaClass.simpleName
    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding!!.variablesButton.setOnClickListener(this)
        mBinding!!.collectionsButton.setOnClickListener(this)
        mBinding!!.functionsButton.setOnClickListener(this)
        mBinding!!.classesButton.setOnClickListener(this)
        mBinding!!.interfacesButton.setOnClickListener(this)
        mBinding!!.companionButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                mBinding?.variablesButton?.id -> {
                    val intent = Intent(this, VariablesActivity::class.java)
                    startActivity(intent)
                }
                mBinding?.collectionsButton?.id -> {
                    val intent = Intent(this, CollectionsActivity::class.java)
                    startActivity(intent)
                }
                mBinding?.functionsButton?.id -> {
                    val intent = Intent(this, FunctionsActivity::class.java)
                    startActivity(intent)
                }
                mBinding?.classesButton?.id -> {
                    Toast.makeText(this, "Check logs for output", Toast.LENGTH_SHORT).show()
                    val person = Person()
                    person.firstName
                    person.lastName
                    person.nickName = "Shades" //Sets the value
                    person.nickName //Returns the getter value
                    person.nickName = "New nick name" //Sets the value
                    person.nickName //Returns the getter value
                    person.printInfo()
                }
                mBinding?.interfacesButton?.id -> {
                    Toast.makeText(this, "Check logs for output", Toast.LENGTH_SHORT).show()
                    val provider = FancyInfoProvider()

//                    val provider = object : PersonInfoProvider {
//                        override val providerInfo: String
//                            get() = "New Info Provider"
//
//                        override fun printInfo(person: Person) {
//
//                        }
//
//                        fun getSessionId () = "id"
//                    }

                    provider.printInfo(Person())
                    provider.defaultInfo()
                    val sessionId = provider.getSessionId()
                    Log.d(tag, "$sessionId")
//                    provider.checkTypes(provider)
                }

                mBinding?.companionButton?.id -> {
                    val entity = Entity.Factory.create()
                }
            }
        }
    }
}