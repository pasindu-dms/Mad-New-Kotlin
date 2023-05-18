package com.example.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HairDesignAddToCart : AppCompatActivity() {

    private lateinit var edName : EditText
    private lateinit var edEmail : EditText
    private lateinit var btnAdd : Button
    private lateinit var btnView : Button
    private lateinit var btnUpdate : Button
    private lateinit var appoinBTN : Button

    private lateinit var sqLiteHelper: HairDesignSQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter: HairDesignAdapter? =null
    private var std: HairDesignModel? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hair_design_add_to_cart)


        GetStyleAmount()
        initView()
        initRecyclerView()

        sqLiteHelper = HairDesignSQLiteHelper(this)

        btnAdd.setOnClickListener{addHairDesignCart()}
        btnView.setOnClickListener{getHairDesignCart()}
        btnUpdate.setOnClickListener{updateHairDesignCart()}

        appoinBTN.setOnClickListener {
            val intent = Intent(this, AppoinmetMain::class.java)
            startActivity(intent)
        }


        adapter?.setOnClickItem {
            Toast.makeText(this,it.name, Toast.LENGTH_SHORT).show()
            //Update

            edName.setText(it.name)
            edEmail.setText(it.email)
            std = it
        }

        adapter?. setOnClickDeleteItem {
            deleteHairDesignCart(it.id)
        }
    }

    private fun GetStyleAmount() {

        val StylePrice = intent.getStringExtra("StylePrice")
        val styleID = intent.getStringExtra("styleID")


//        if(styleID == "MenStyle01"){
//            StyleAmount = 1000
//        }
//        if(styleID == "MenStyle02"){
//            StyleAmount = 2000
//        }
//        if(styleID == "MenStyle03"){
//            StyleAmount = 3000
//        }
//        if(styleID == "MenStyle04"){
//            StyleAmount = 4000
//        }
//        if(styleID == "MenStyle05"){
//            StyleAmount = 5000
//        }
//        if(styleID == "MenStyle06"){
//            StyleAmount = 6000
//        }

        val editTextItemID = findViewById<EditText>(R.id.eName01).apply {
            setText(styleID)
        }
        val editTextAmount = findViewById<EditText>(R.id.eEmail01).apply {
            setText("Rs. "+StylePrice)
        }
    }

    private fun updateHairDesignCart() {
        var name = edName.text.toString()
        var email = edEmail.text.toString()

        //Check Record
        if(name == std?.name && email == std?.email){
            Toast.makeText(this,"Record Not Changed....",Toast.LENGTH_SHORT).show()
            return
        }

        if (std == null)return

        val std = HairDesignModel(id = std!!.id, name = name, email=email)
        val status = sqLiteHelper.updateHairDesignCart(std)
        if(status > -1){

            clearEditText()
            getHairDesignCart()
        }else{
            Toast.makeText(this,"Update Failed.....",Toast.LENGTH_SHORT).show()

        }
    }

    private fun getHairDesignCart() {
        val stdList = sqLiteHelper.getAllHairDesignCart()
        Log.e("pppp","${stdList.size}")

        //

        adapter?.addItems(stdList)
    }

    private fun addHairDesignCart() {
        var name = edName.text.toString()
        var email = edEmail.text.toString()

        if(name.isEmpty() || email.isEmpty()){
            Toast.makeText(this,"Please enter requried field",Toast.LENGTH_SHORT).show()
        }else{
            val std = HairDesignModel(name = name , email = email)
            val status = sqLiteHelper.insertHairDesignCart(std)
            // Check insert success or not

            if(status > -1){
                Toast.makeText(this,"Item is added.....",Toast.LENGTH_SHORT).show()
                clearEditText()
            }else{
                Toast.makeText(this,"Record not saved!..",Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun deleteHairDesignCart(id: Int){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to delete item? ")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes"){ dialog, _ ->
            sqLiteHelper.HairDesignCartById(id)
            getHairDesignCart()
            dialog.dismiss()
        }
        builder.setNegativeButton("No"){ dialog, _ ->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }


    private fun clearEditText() {
        edName.setText("")
        edEmail.setText("")
        edName.requestFocus()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HairDesignAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView() {
        edName = findViewById(R.id.eName01)
        edEmail = findViewById(R.id.eEmail01)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)
        btnUpdate = findViewById(R.id.btnUpdate)
        appoinBTN = findViewById(R.id.appoinBTN)
        recyclerView = findViewById(R.id.recyclerView)
    }
}