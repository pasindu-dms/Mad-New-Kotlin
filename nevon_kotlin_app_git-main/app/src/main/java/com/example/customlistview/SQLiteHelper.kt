package com.example.customlistview

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) :  SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION) {


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "cart.db"
        private const val TBL_Cart = "tbl_cart"
        private const val ID = "id"
        private const val NAME = "name"
        private const val EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblStudent = ("CREATE TABLE "+ TBL_Cart + "("
                + ID + " INTEGER PRIMARY KEY," + NAME+ " TEXT,"
                + EMAIL + " TEXT"+ ")")
        db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_Cart")
        onCreate(db)
    }

    fun insertCart(std: CartModel): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID,std.id)
        contentValues.put(NAME,std.name)
        contentValues.put(EMAIL,std.email)

        val success = db.insert(TBL_Cart, null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getAllCarts():ArrayList<CartModel>{
        val stdList : ArrayList<CartModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_Cart"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        }catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id: Int
        var name: String
        var email: String

        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                name = cursor.getString(cursor.getColumnIndex("name"))
                email = cursor.getString(cursor.getColumnIndex("email"))

                val std = CartModel(id = id, name = name, email = email)
                stdList.add(std)

            }while (cursor.moveToNext()   )
        }
        return stdList
    }
    fun updateCart(std: CartModel):Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID,std.id)
        contentValues.put(NAME,std.name)
        contentValues.put(EMAIL,std.email)

        val sucess = db.update(TBL_Cart,contentValues,"id=" + std.id,null)
        db.close()
        return sucess
    }

    fun deleteCartById(id:Int): Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, id)
        val success = db.delete(TBL_Cart, "id=$id",null)
        db.close()
        return success
    }
}