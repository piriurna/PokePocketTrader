package com.piriurna.pokepockettrader.data.user.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.piriurna.pokepockettrader.data.user.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE nickname =:nickname")
    fun selectUserById(nickname: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertNewUser(user: UserEntity)
}