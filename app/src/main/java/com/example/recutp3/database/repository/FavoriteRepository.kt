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

    fun getFavoriteIndexes(userId: Int): List<Int> {
        return dao.getFavoriteIndexes(userId)
    }

    fun exists(userId: Int, index: Int): Boolean {
        return dao.exists(userId, index)
    }

    fun getAll():List<Favorite>{
        return dao.getAll()
    }
    fun delete(favorite: Favorite){
        dao.delete(favorite)
    }

    companion object {
        private var favoriteRepository: FavoriteRepository? = null

        fun getInstance(context: Context): FavoriteRepository {
            return favoriteRepository ?: kotlin.run {

                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

                val createdRepository = FavoriteRepository(db)
                favoriteRepository = createdRepository
                createdRepository
            }
        }
    }
}