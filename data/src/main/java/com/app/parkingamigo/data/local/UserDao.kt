/*
package com.app.parkingamigo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.parkingamigo.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE cedula = :cedula AND password = :password")
    suspend fun getUser(cedula: String, password: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
}*/
