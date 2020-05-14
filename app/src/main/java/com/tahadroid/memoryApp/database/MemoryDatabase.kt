package com.tahadroid.memoryApp.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memory::class], version = 1, exportSchema = false)
abstract class MemoryDatabase : RoomDatabase() {
    abstract fun memoryDao(): MemoryDao

    companion object {
        private const val DATABASE_NAME = "memories"
        private var memoryDatabase: MemoryDatabase? = null
        fun getInstance(context: Context): MemoryDatabase? {

            if (memoryDatabase == null) {
                memoryDatabase = Room.databaseBuilder(
                    context,
                    MemoryDatabase::class.java,
                    DATABASE_NAME
                ).allowMainThreadQueries().build()
            }
            return memoryDatabase
        }
    }


}