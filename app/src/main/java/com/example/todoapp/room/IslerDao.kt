package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumIsler() : List<Isler>

    @Insert
    suspend fun isEkle(islem:Isler)

    @Update
    suspend fun isGuncelle(islem:Isler)

    @Delete
    suspend fun isSil(islem:Isler)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun isArama(aramaKelimesi:String) : List<Isler>
}