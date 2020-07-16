package com.gustavo.cookapp.presentation.viewmodels

import androidx.lifecycle.*
import com.gustavo.cookapp.base.Resource
import com.gustavo.cookapp.domain.MealRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mealRepository: MealRepository) : ViewModel() {
    private val mealLiveData = MutableLiveData<String>()

    fun setMeal(nameMeal: String) {
        mealLiveData.value = nameMeal
    }

    val getMealList = mealLiveData.distinctUntilChanged().switchMap { nameMeal ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(mealRepository.getMealsRepository(nameMeal))
            } catch (e:Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

}