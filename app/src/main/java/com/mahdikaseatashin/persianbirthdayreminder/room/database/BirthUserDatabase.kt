package com.mahdikaseatashin.persianbirthdayreminder.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mahdikaseatashin.persianbirthdayreminder.models.BirthUser
import com.mahdikaseatashin.persianbirthdayreminder.room.BirthUserDAO

@Database(entities = [BirthUser::class],version = 1)
abstract class BirthUserDatabase : RoomDatabase() {
    abstract fun birthUserDao() : BirthUserDAO

    companion object{
        private var instance : BirthUserDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : BirthUserDatabase {
            if (instance != null) return instance!!

            synchronized(this) {
                instance = Room
                    .databaseBuilder(context, BirthUserDatabase::class.java, "LOGIN_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return instance!!
            }
        }
    }

}
