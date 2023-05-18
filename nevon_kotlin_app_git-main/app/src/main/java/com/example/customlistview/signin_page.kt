package com.example.customlistview

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class signin_page : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private var loadingBar: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_page)

        val user_sign = findViewById<TextView>(R.id.signuplink)
        val Email_Input_user = findViewById<EditText>(R.id.Email_Input_user)
        val password_input_user = findViewById<EditText>(R.id.password_input_user)
        val login_btn = findViewById<Button>(R.id.login_btn)
        dbHelper = DBHelper(this)
        loadingBar = ProgressDialog(this)


        login_btn.setOnClickListener{
            val useremail = Email_Input_user.text.toString()
            val userpass = password_input_user.text.toString()

            loadingBar!!.setTitle("Sign In")
            loadingBar!!.setMessage("Please wait we are checking your credentials..")
            loadingBar!!.setCanceledOnTouchOutside(true)
            loadingBar!!.show()

//            val intent = Intent(this, home_page::class.java)
//                    intent.putExtra("email", useremail)
//                    startActivity(intent)

            if (TextUtils.isEmpty(useremail) || TextUtils.isEmpty(userpass)){
                Toast.makeText(this,"Not accept empty fields", Toast.LENGTH_LONG).show()

            }
            else{
                val checkuser = dbHelper.checkuserpass(useremail,userpass)
                if(checkuser == true){
                    Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, home_page::class.java)
                    intent.putExtra("email", useremail)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Wrong User name or Password",Toast.LENGTH_LONG).show()
                }
            }
        }

        user_sign.setOnClickListener {
            val intent = Intent(this, signup_page::class.java)
            startActivity(intent)
        }


    }
}