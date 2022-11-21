package com.example.recutp3.database.repository

import android.content.Context
import androidx.room.Room
import com.example.recutp3.database.AppDatabase
import com.example.recutp3.database.entities.Favorite

class FavoriteRepository private constructor(private val appDatabase: AppDatabase) {

    private val dao = appDatabase.favoriteDao()

    fun add(favorite: Favorite) {
        dao.insert(favorite)
    }

    fun delete(favorite: Favorite) {
        dao.delete(favorite)
    }

    fun getAll(): List<Favorite> {
        return dao.getAll()
    }

    fun getFavoriteIndexes(userId: String): List<Int> {
        return dao.getFavoriteIndexes(userId)
    }

    companion object {
        private var favoriteRepository: FavoriteRepository? = null

        fun getInstance(context: Context): FavoriteRepository {
            return favoriteRepository ?: kotlin.run {

                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "db"
                )
                    .allowMainThreadQueries()
                    .build()

                val createdRepository = FavoriteRepository(db)
                favoriteRepository = createdRepository
                createdRepository
            }
        }
    }
}