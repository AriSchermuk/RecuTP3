package com.example.recutp3.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.recutp3.database.entities.AppUser
import com.example.recutp3.database.entities.Favorite

@Dao
interface AppUserDao {
    @Insert
    fun insert(appUser: AppUser)

    @Query("SELECT * FROM appuser a where a.email=:email and a.password=:password")
    fun get(email: String, password: String): AppUser
}