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

    @Query("SELECT f.favorite_i FROM favorite f where f.user_id=:userId")
    fun getFavoriteIndexes(userId: Int): List<Int>

    @Query("SELECT COUNT(0)>0 FROM favorite f where f.user_id=:userId and f.favorite_i=:index")
    fun exists(userId: Int, index: Int): Boolean

    @Query("SELECT * FROM favorite f")
    fun getAll(): List<Favorite>

    @Delete
    fun delete(favorite: Favorite)
}