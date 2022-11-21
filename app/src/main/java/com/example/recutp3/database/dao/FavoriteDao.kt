package com.example.recutp3.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.recutp3.database.entities.Favorite

@Dao
interface FavoriteDao {
    @Insert
    fun insert(favorite: Favorite)

    @Delete
    fun delete(favorite: Favorite)

    @Query("SELECT *  FROM favorite")
    fun getAll(): List<Favorite>
}