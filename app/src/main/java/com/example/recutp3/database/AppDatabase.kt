package com.example.recutp3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recutp3.database.dao.AppUserDao
import com.example.recutp3.database.dao.FavoriteDao
import com.example.recutp3.database.entities.AppUser
import com.example.recutp3.database.entities.Favorite

@Database(entities = [Favorite::class, AppUser::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
    abstract fun appUserDao(): AppUserDao
}