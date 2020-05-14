package com.tahadroid.memoryApp.repository.local

import androidx.room.*

@Dao
interface MemoryDao {
    @Insert
    fun addMemory(memory:Memory)

    @Query("DELETE FROM memory WHERE mId = :id")
    fun deleteMemory(id:Int)

    @Update
    fun updateMemory(memory:Memory)

    @Query("SELECT * FROM memory")
    fun getAllMemories():List<Memory>


    @Query("DELETE FROM memory")
    fun deleteAll()

}