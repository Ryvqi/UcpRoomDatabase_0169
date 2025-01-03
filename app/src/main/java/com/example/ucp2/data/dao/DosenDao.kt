package com.example.ucp2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ucp2.data.entity.Dosen
import kotlinx.coroutines.flow.Flow

@Dao
interface DosenDao {
    // operasi create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDosen(dosen: Dosen)

    // operasi read (mengambil semua data dosen dan mengurutkan berdasarkan nama (Ascending))
    @Query("SELECT * FROM dosen ORDER BY nama ASC")
    fun getAllDosen(): Flow<List<Dosen>>
}