package com.tahadroid.memoryApp.repository.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memory(
    val mTitle:String
    ,val mDescription:String
    ,val mLatitude:Double
    ,val mLongitude:Double) {
@PrimaryKey(autoGenerate = true)
    var mId:Int=0
}