package com.example.recutp3.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.recutp3.database.entities.AppUser
import com.example.recutp3.database.entities.Favorite

@Dao
interface AppUserDao {
    @Insert
    fun insert(appUser: AppUser)

    @Query("SELECT * FROM appuser a where a.email=:email and a.password=:password")
    fun get(email: String, password: String): AppUser

    @Update
    fun updateUser(appUser: AppUser)

    @Query("SELECT * FROM appuser where logged=1")
    fun findLoggedUser(): AppUser?
}