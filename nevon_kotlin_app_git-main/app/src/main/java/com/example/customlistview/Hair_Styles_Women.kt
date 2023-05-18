package com.example.customlistview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Hair_Styles_Women : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hair_styles_women)

        val men_hairStyle_Btn = findViewById<Button>(R.id.men_hairStyle_Btn)

        val WomenStyle01 = findViewById<ImageView>(R.id.WomenStyle01)
        val WomenStyle02 = findViewById<ImageView>(R.id.WomenStyle02)
        val WomenStyle03 = findViewById<ImageView>(R.id.WomenStyle03)
        val WomenStyle04 = findViewById<ImageView>(R.id.WomenStyle04)
        val WomenStyle05 = findViewById<ImageView>(R.id.WomenStyle05)
        val WomenStyle06 = findViewById<ImageView>(R.id.WomenStyle06)

        men_hairStyle_Btn.setOnClickListener {
            val intent = Intent(this, Hair_Styles_Men::class.java)
            startActivity(intent)
        }

        WomenStyle01.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","WomenStyle01")
            intent.putExtra("StylePrice","1500")
            startActivity(intent)
        }

        WomenStyle02.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","WomenStyle02")
            intent.putExtra("StylePrice","2500")
            startActivity(intent)
        }

        WomenStyle03.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","WomenStyle03")
            intent.putExtra("StylePrice","3500")
            startActivity(intent)
        }

        WomenStyle04.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","WomenStyle04")
            intent.putExtra("StylePrice","4500")
            startActivity(intent)
        }

        WomenStyle05.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","WomenStyle05")
            intent.putExtra("StylePrice","5500")
            startActivity(intent)
        }

        WomenStyle06.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","WomenStyle06")
            intent.putExtra("StylePrice","6500")
            startActivity(intent)
        }
    }
}