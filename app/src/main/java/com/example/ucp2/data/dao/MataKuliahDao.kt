package com.example.ucp2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2.data.entity.MataKuliah
import kotlinx.coroutines.flow.Flow

@Dao
interface MataKuliahDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMataKuliah(matkul: MataKuliah)

    // mengambil semua data mata kuliah dan mengurutkannya berdasarkan nama (Ascending)
    @Query("SELECT * FROM matakuliah ORDER BY nama ASC")
    fun getAllMataKuliah(): Flow<List<MataKuliah>>

    // mengambil data mata kuliah berdasarkan kode
    @Query("SELECT * FROM matakuliah WHERE kode = :kode")
    fun getMataKuliah(kode: String): Flow<MataKuliah>

    @Update
    suspend fun updateMataKuliah(matkul: MataKuliah)

    @Delete
    suspend fun deleteMataKuliah(matkul: MataKuliah)

}