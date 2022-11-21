package com.example.recutp3.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Favorite(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "user_id") val userId: String,
    @ColumnInfo(name = "favorite_i") val favoriteI: Int
)