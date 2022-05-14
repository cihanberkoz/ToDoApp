package com.example.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.todoapp.entity.Isler

@Database(entities = [Isler::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun islerDao() : IslerDao

    companion object{
        var INSTANCE:Veritabani? = null

        fun veritabaniErisim(context:Context) : Veritabani? {
            if (INSTANCE==null) {
                synchronized(Veritabani::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Veritabani::class.java,
                        "isler.sqlite"
                    ).createFromAsset("isler.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}