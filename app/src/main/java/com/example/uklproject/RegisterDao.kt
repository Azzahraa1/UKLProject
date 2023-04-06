package com.example.uklproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RegisterDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahRegister(register: Register)

    @Query("SELECT * FROM Register")
    fun ambilData(): LiveData<List<Register>>
}