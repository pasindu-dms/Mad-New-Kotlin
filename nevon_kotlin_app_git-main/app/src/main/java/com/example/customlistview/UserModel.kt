package com.example.customlistview

import java.util.Random

class UserModel (
    var id: Int = getAutoId(),
    var name : String = "",
    var email : String = "",
    var gender : String = "",

    ){
    companion object{
        fun getAutoId():Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}