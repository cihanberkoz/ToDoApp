package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.IslerDaoRepository

class IsKayitFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val krepo = IslerDaoRepository(application)

    fun kayit(yapilacak_is:String){
        krepo.isKayit(yapilacak_is)
    }
}