package com.example.customlistview

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HairDesignSQLiteHelper(context: Context) :  SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION) {


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "hair_design.db"
        private const val TBL_STUDENT = "tbl_hair_design"
        private const val ID = "id"
        private const val NAME = "name"
        private const val EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblStudent = ("CREATE TABLE "+ TBL_STUDENT + "("
                + ID + " INTEGER PRIMARY KEY," + NAME+ " TEXT,"
                + EMAIL + " TEXT"+ ")")
        db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_STUDENT")
        onCreate(db)
    }

    fun insertHairDesignCart(std: HairDesignModel): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID,std.id)
        contentValues.put(NAME,std.name)
        contentValues.put(EMAIL,std.email)

        val success = db.insert(TBL_STUDENT, null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getAllHairDesignCart():ArrayList<HairDesignModel>{
        val stdList : ArrayList<HairDesignModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_STUDENT"
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

                val std = HairDesignModel(id = id, name = name, email = email)
                stdList.add(std)

            }while (cursor.moveToNext()   )
        }
        return stdList
    }
    fun updateHairDesignCart(std: HairDesignModel):Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID,std.id)
        contentValues.put(NAME,std.name)
        contentValues.put(EMAIL,std.email)

        val sucess = db.update(TBL_STUDENT,contentValues,"id=" + std.id,null)
        db.close()
        return sucess
    }

    fun HairDesignCartById(id:Int): Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, id)
        val success = db.delete(TBL_STUDENT, "id=$id",null)
        db.close()
        return success
    }
}