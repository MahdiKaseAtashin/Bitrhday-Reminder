package com.mahdikaseatashin.persianbirthdayreminder.room

import androidx.room.*
import com.mahdikaseatashin.persianbirthdayreminder.models.BirthUser

@Dao
interface BirthUserDAO {

    @Insert
    fun addBirthUser(birthUser: BirthUser): Long

    @Update
    fun updateBirthUser(birthUser: BirthUser)

    @Delete
    fun removeBirthUser(birthUser: BirthUser)

    @Query("select * from tb_birth_user")
    fun getAllBirthUsers():List<BirthUser>

}
