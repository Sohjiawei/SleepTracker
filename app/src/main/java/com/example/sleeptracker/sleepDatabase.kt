package com.example.sleeptracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Sleep::class),version = 1)
abstract class sleepDatabase: RoomDatabase() {
    abstract fun SleepDao() : SleepDao

    companion object{
        //create an instance of the room database
        //singleton prevents multiple instances of the database
        private var INSTANCE : sleepDatabase? = null

        fun getDatabase(context:Context) : sleepDatabase{
            val tempDB = INSTANCE
            if (tempDB != null){
                return tempDB
            }

            //create an instance of the database
            synchronized(this){
                val instance = Room.databaseBuilder(context,sleepDatabase::class.java,"sleep_db").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}