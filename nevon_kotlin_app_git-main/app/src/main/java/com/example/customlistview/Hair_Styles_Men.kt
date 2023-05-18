package com.example.customlistview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Hair_Styles_Men : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hair_styles_men)


        val women_hairStyle_Btn = findViewById<Button>(R.id.women_hairStyle_Btn)

        val MenStyle01 = findViewById<ImageView>(R.id.MenStyle01)
        val MenStyle02 = findViewById<ImageView>(R.id.MenStyle02)
        val MenStyle03 = findViewById<ImageView>(R.id.MenStyle03)
        val MenStyle04 = findViewById<ImageView>(R.id.MenStyle04)
        val MenStyle05 = findViewById<ImageView>(R.id.MenStyle05)
        val MenStyle06 = findViewById<ImageView>(R.id.MenStyle06)


        women_hairStyle_Btn.setOnClickListener {
            val intent = Intent(this, Hair_Styles_Women::class.java)
            startActivity(intent)
        }

        MenStyle01.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","MenStyle01")
            intent.putExtra("StylePrice","1000")
            startActivity(intent)
        }

        MenStyle02.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","MenStyle02")
            intent.putExtra("StylePrice","2000")
            startActivity(intent)
        }

        MenStyle03.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","MenStyle03")
            intent.putExtra("StylePrice","3000")
            startActivity(intent)
        }

        MenStyle04.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","MenStyle04")
            intent.putExtra("StylePrice","4000")
            startActivity(intent)
        }

        MenStyle05.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","MenStyle05")
            intent.putExtra("StylePrice","5000")
            startActivity(intent)
        }

        MenStyle06.setOnClickListener {
//            Toast.makeText(this,ItemID.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HairDesignAddToCart::class.java)
            intent.putExtra("styleID","MenStyle06")
            intent.putExtra("StylePrice","6000")
            startActivity(intent)
        }

    }
}