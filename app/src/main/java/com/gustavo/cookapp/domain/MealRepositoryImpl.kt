package com.gustavo.cookapp.domain

import com.gustavo.cookapp.data.datasource.Datasource

class MealRepositoryImpl(val datasource: Datasource) : MealRepository {
    override fun getMealsRepository(nameMeal: String) {
        TODO("Not yet implemented")
    }
}