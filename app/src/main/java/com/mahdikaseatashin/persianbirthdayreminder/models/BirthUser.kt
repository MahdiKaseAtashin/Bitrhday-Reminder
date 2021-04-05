package com.mahdikaseatashin.persianbirthdayreminder.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_birth_user")
data class BirthUser(

    @ColumnInfo(name = "birth_user_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "birth_user_name")
    val name: String,

    @ColumnInfo(name = "birth_user_phone")
    val phone: String,

    @ColumnInfo(name = "birth_user_email")
    val email: String,

    @ColumnInfo(name = "birth_user_birthday")
    val birthday: String,

    @ColumnInfo(name = "birth_user_image")
    val image: String
)
