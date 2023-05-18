package com.example.customlistview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class signup_page : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val user_sign = findViewById<TextView>(R.id.signintxtview)

        val uName = findViewById<EditText>(R.id.name_input)
        val uEmail = findViewById<EditText>(R.id.email_input)
        val uPassword = findViewById<EditText>(R.id.password_input)
        val gender = findViewById<EditText>(R.id.gender_input)
        val createBtn = findViewById<Button>(R.id.create_btn)

        dbHelper = DBHelper(this)

        createBtn.setOnClickListener{
            val uNameText = uName.text.toString()
            val uPasswordText = uPassword.text.toString()
            val uEmailText = uEmail.text.toString()
            val uGenderText = gender.text.toString()

            val savedata = dbHelper.insertdata(uNameText,uPasswordText,uGenderText,uEmailText,)

            if(TextUtils.isEmpty(uNameText) || TextUtils.isEmpty(uPasswordText) || TextUtils.isEmpty(uEmailText)  || TextUtils.isEmpty(uGenderText)  ){
                Toast.makeText(this,"Not accept empty fields",Toast.LENGTH_LONG).show()
            }
            else{
                if(savedata == true){
                    Toast.makeText(this,"Account is created",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, signin_page::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Your task failed",Toast.LENGTH_LONG).show()
                }
            }
        }

        user_sign.setOnClickListener {
            val intent = Intent(this, signin_page::class.java)
            startActivity(intent)
        }
    }
}