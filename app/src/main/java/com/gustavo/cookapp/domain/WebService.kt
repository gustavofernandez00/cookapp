package com.gustavo.cookapp.domain

import Meal
import MealList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php")
    suspend fun getMealsByName(@Query(value = "s") mealName: String) : MealList

    @GET("lookup.php")
    suspend fun getMealById(@Query(value = "i") mealId: String) : Meal
}