package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        Toast.makeText(this@LoginActivity, "We Clicked on the button to see this Toast!", Toast.LENGTH_LONG).show()
    }
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView

    lateinit var txtRegister: TextView
    val validMobileNum="555"
    val validPassword=arrayOf("tony","steve","bruce","thanos")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)

        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_login)
        if(isLoggedIn)
        {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_login)

        title="Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)


        btnLogin.setOnClickListener{
            val mobileNumber=etMobileNumber.text.toString()
            val password=etPassword.text.toString()
            var nameOfAvenger="Avenger"
            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if((mobileNumber==validMobileNum)){

                if(password==validPassword[0]){
                    nameOfAvenger="Iron Man"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[1]){
                    nameOfAvenger="Captain America"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[2]){
                    nameOfAvenger="The Hulk"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[3]){
                    nameOfAvenger="The Avengers"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }

            }
            else{
                Toast.makeText(this@LoginActivity,"Invalid Credentials",Toast.LENGTH_LONG).show()
            }



        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}