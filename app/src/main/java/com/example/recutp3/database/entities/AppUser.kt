package com.example.recutp3.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["email"], unique = true)])
//Then index generates a unique constraint for email
class AppUser(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val email: String,
    @ColumnInfo val password: String
)