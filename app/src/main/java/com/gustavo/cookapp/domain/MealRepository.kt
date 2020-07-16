package com.gustavo.cookapp.domain

import Meal
import com.gustavo.cookapp.base.Resource

interface MealRepository {
    suspend fun getMealsRepository(nameMeal: String) : Resource<List<Meal>>
}