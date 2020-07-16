package com.gustavo.cookapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gustavo.cookapp.domain.MealRepository

class MainViewModelFactory(val mealRepository: MealRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return modelClass.getConstructor(MealRepository::class.java).newInstance(mealRepository)
    }
}