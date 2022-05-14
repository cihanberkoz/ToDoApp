package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.IslerDaoRepository

class IsDetayFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val krepo = IslerDaoRepository(application)

    fun guncelle(is_id:Int,yapilacak_is:String){
        krepo.isGuncelle(is_id,yapilacak_is)
    }
}