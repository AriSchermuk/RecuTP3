package com.example.recutp3.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["user_id", "favorite_i"], unique = true)])
//Then index generates a unique constraint for user_id and favorite_i
class Favorite(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "favorite_i") val favoriteI: Int
)