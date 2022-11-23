package com.example.recutp3.database.repository

import android.content.Context
import androidx.room.Room
import com.example.recutp3.database.AppDatabase
import com.example.recutp3.database.entities.AppUser

class AppUserRepository private constructor(private val appDatabase: AppDatabase) {

    private val dao = appDatabase.appUserDao()

    fun add(appUser: AppUser) {
        dao.insert(appUser)
    }

    fun get(email: String, password: String): AppUser {
        return dao.get(email, password)
    }

    fun updateUser(appUser: AppUser) {
        return dao.updateUser(appUser)
    }

    fun findLoggedUser(): AppUser? {
        return dao.findLoggedUser()
    }

    companion object {
        private var appUserRepository: AppUserRepository? = null

        fun getInstance(context: Context): AppUserRepository {
            return appUserRepository ?: kotlin.run {

                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

                val createdRepository = AppUserRepository(db)
                appUserRepository = createdRepository
                createdRepository
            }
        }
    }
}