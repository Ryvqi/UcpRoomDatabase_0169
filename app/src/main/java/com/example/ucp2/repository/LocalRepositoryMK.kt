package com.example.ucp2.repository

import com.example.ucp2.data.dao.MataKuliahDao
import com.example.ucp2.data.entity.MataKuliah
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMK(
    private val matakuliahDao: MataKuliahDao
): RepositoryMK {
    override suspend fun insertMK(matkul: MataKuliah){
        matakuliahDao.insertMataKuliah(matkul)
    }
    override fun getAllMK(): Flow<List<MataKuliah>> {
        return matakuliahDao.getAllMataKuliah()
    }
    override fun getMK(kode: String): Flow<MataKuliah> {
        return matakuliahDao.getMataKuliah(kode)
    }
    override suspend fun updateMK(matkul: MataKuliah){
        matakuliahDao.updateMataKuliah(matkul)
    }
    override suspend fun deleteMK(matkul: MataKuliah){
        matakuliahDao.deleteMataKuliah(matkul)
    }
}