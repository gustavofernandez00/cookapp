package com.gustavo.cookapp.data.datasource

import Meal
import com.gustavo.cookapp.base.Resource
import com.gustavo.cookapp.base.RetrofitClient

class Datasource {
    suspend fun getMealsByName(nameMeal: String) : Resource<List<Meal>>{
        return Resource.Success(RetrofitClient.webservice.getMealsByName(nameMeal).meals)
    }
}