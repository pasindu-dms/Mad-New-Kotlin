package com.example.customlistview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class home_page : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val intent = this.intent
        val email = intent.getStringExtra("email")

        val user_email = findViewById<TextView>(R.id.textView2)
        val allProductButton = findViewById<Button>(R.id.all_product_button)
        val HairDesignBtns = findViewById<Button>(R.id.HairDesignBtn)
        val profileBtn = findViewById<Button>(R.id.profileBtn)
        val AppoinmntBtn = findViewById<Button>(R.id.AppoinmntBtn)
        user_email.setText(email)


        allProductButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        HairDesignBtns.setOnClickListener {
            val intent = Intent(this, Hair_Styles_Men::class.java)
            startActivity(intent)
        }
        profileBtn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        AppoinmntBtn.setOnClickListener {
            val intent = Intent(this, AppoinmetMain::class.java)
            startActivity(intent)
        }

    }

}