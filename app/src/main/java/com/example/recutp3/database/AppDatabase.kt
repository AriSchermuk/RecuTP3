package com.example.recutp3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recutp3.database.dao.FavoriteDao
import com.example.recutp3.database.entities.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}