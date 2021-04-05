package com.mahdikaseatashin.persianbirthdayreminder.repository

import android.content.Context
import com.mahdikaseatashin.persianbirthdayreminder.models.BirthUser
import com.mahdikaseatashin.persianbirthdayreminder.room.database.BirthUserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object AddUpdateRepository {

    var birthUserDatabase: BirthUserDatabase? = null

    fun insertData(context: Context, user: BirthUser) {

        birthUserDatabase = initializeDatabase(context)

        CoroutineScope(Dispatchers.IO).launch {
            birthUserDatabase!!.birthUserDao().addBirthUser(user)
        }

    }

    private fun initializeDatabase(context: Context) : BirthUserDatabase {
        return BirthUserDatabase.getInstance(context)
    }
}
