package com.gustavo.cookapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    val idMealData = MutableLiveData<String>()

    fun setIdMealData(id:String) {
        idMealData.value = id
    }
}