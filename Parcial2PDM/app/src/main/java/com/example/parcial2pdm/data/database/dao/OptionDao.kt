package com.example.parcial2pdm.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial2pdm.data.database.entities.PlaceOptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionDao {

    @Query("SELECT * FROM options")
    fun getAllOptions(): Flow<List<PlaceOptionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(option: PlaceOptionEntity)

    @Delete
    suspend fun deleteOption(option: PlaceOptionEntity)
}