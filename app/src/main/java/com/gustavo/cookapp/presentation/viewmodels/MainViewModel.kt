package com.gustavo.cookapp.presentation.viewmodels

import androidx.lifecycle.*
import com.gustavo.cookapp.domain.MealRepository

class MainViewModel(val mealRepository: MealRepository) : ViewModel() {
    private val mealLiveData = MutableLiveData<String>()

    fun setMeal(nameMeal: String) {
        mealLiveData.value = nameMeal
    }

}