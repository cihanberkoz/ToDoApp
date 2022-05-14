package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.entity.Isler
import com.example.todoapp.repo.IslerDaoRepository

class AnasayfaFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val krepo = IslerDaoRepository(application)
    var islerListesi = MutableLiveData<List<Isler>>()

    init {
        isleriYukle()
        islerListesi = krepo.isleriGetir()
    }

    fun ara(aramaKelimesi:String){
        krepo.isAra(aramaKelimesi)
    }

    fun sil(is_id:Int){
        krepo.isSil(is_id)
    }

    fun isleriYukle(){
        krepo.tumIsleriAl()
    }
}