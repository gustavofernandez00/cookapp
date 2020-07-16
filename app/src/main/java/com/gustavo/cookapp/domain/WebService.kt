package com.gustavo.cookapp.domain

import MealList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php")
    suspend fun getMealsByName(@Query(value = "s") mealName: String) : MealList
}