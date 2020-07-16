package com.gustavo.cookapp.domain

import Meal
import com.gustavo.cookapp.base.Resource
import com.gustavo.cookapp.data.datasource.Datasource

class MealRepositoryImpl(val datasource: Datasource) : MealRepository {
    override suspend fun getMealsRepository(nameMeal: String) : Resource<List<Meal>> {
        return datasource.getMealsByName(nameMeal)
    }
}