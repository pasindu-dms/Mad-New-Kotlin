package com.example.customlistview

import java.util.*

data class HairDesignModel(
    var id: Int = getAutoId(),
    var name : String = "",
    var email : String = "",

    ) {
    companion object{
        fun getAutoId():Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}