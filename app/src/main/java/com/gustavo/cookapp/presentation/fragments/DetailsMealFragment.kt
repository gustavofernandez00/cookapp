package com.gustavo.cookapp.presentation.fragments

import Meal
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.gustavo.cookapp.R
import com.gustavo.cookapp.presentation.viewmodels.DetailViewModel
import kotlinx.android.synthetic.main.fragment_details_meal.*
import kotlinx.android.synthetic.main.meal_row.view.*


class DetailsMealFragment : Fragment() {

    private lateinit var meal: Meal

    private val detailViewModel by viewModels<DetailViewModel> {
        TODO()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            meal = it.getParcelable("meal")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fix me
        //setupDetails()
    }

    private fun setupDetails() {
        Glide.with(requireContext()).load(meal.strMealThumb).into(img_meal_detail.img_meal)
        txt_title_meal_detail.text = meal.strMeal
        txt_title_meal_instructions.text = meal.strInstructions
    }

}