package com.example.todoapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.Isler
import com.example.todoapp.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IslerDaoRepository(var application: Application) {
    var islerListesi:MutableLiveData<List<Isler>>
    var vt:Veritabani

    init {
        islerListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun isleriGetir() : MutableLiveData<List<Isler>> {
        return islerListesi
    }

    fun isKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniIs = Isler(0,yapilacak_is)
            vt.islerDao().isEkle(yeniIs)

        }
    }

    fun isGuncelle(is_id:Int,yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Isler(is_id,yapilacak_is)
            vt.islerDao().isGuncelle(guncellenenIs)
        }
    }

    fun isAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.islerDao().isArama(aramaKelimesi)
        }
    }

    fun isSil(is_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenIs = Isler(is_id,"")
            vt.islerDao().isSil(silinenIs)
            tumIsleriAl()
        }
    }

    fun tumIsleriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.islerDao().tumIsler()
        }
    }

}