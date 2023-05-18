package com.example.customlistview

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract.CommonDataKinds.Email

class DBHelper (context: Context) :  SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION){

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "nevon.db"
        private const val TBL_USER = "tbl_user"
        private const val ID = "id"
        private const val USERNAME = "username"
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
        private const val GENDER = "gender"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createTblStudent = ("CREATE TABLE "+ TBL_USER + "("
                + ID + " INTEGER PRIMARY KEY," + USERNAME+ " TEXT," + GENDER+ " TEXT,"+ EMAIL+ " TEXT,"
                + PASSWORD + " TEXT"+ ")")
        db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TBL_USER")
        onCreate(db)
    }

    fun insertdata(username : String, password: String, gender: String, email: String):Boolean{
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put("username",username)
        contentValues.put("password",password)
        contentValues.put("gender",gender)
        contentValues.put("email",email)

        val result = db.insert(TBL_USER, null, contentValues)
        if (result ==-1 .toLong()){
            return false
        }
        return true
    }

    fun checkuserpass(username: String, password: String):Boolean{
        val db = this.writableDatabase
        val query = "select * from $TBL_USER where $EMAIL = '$username' and $PASSWORD = '$password'"
        val cursor = db.rawQuery(query,null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

//    @SuppressLint("Range")
//    fun getAllStudent():ArrayList<UserModel>{
//        val stdList : ArrayList<UserModel> = ArrayList()
//        val selectQuery = "SELECT * FROM $TBL_USER"
//        val db = this.readableDatabase
//
//        val cursor: Cursor?
//
//        try {
//            cursor = db.rawQuery(selectQuery, null)
//        }catch (e:Exception){
//            e.printStackTrace()
//            db.execSQL(selectQuery)
//            return ArrayList()
//        }
//        var id: Int
//        var name: String
//        var email: String
//        var gender: String
//
//        if(cursor.moveToFirst()){
//            do {
//                id = cursor.getInt(cursor.getColumnIndex("id"))
//                name = cursor.getString(cursor.getColumnIndex("name"))
//                email = cursor.getString(cursor.getColumnIndex("email"))
//                gender = cursor.getString(cursor.getColumnIndex("gender"))
//
//                val std = UserModel(id = id, name = name, email = email,gender = gender)
//                stdList.add(std)
//
//            }while (cursor.moveToNext()   )
//        }
//        return stdList
//    }

}