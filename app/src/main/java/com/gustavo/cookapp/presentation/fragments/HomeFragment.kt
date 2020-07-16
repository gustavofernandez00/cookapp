package com.gustavo.cookapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.gustavo.cookapp.R
import com.gustavo.cookapp.base.Resource
import com.gustavo.cookapp.data.datasource.Datasource
import com.gustavo.cookapp.domain.MealRepositoryImpl
import com.gustavo.cookapp.presentation.viewmodels.MainViewModel
import com.gustavo.cookapp.presentation.viewmodels.MainViewModelFactory


class HomeFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(MealRepositoryImpl(Datasource()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.setMeal("Arrabiata")
    }

    private fun setupObservers() {
        viewModel.getMealList.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    Log.d("MEALS", "Lista de comidas: ${result.data}")
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Ha ocurrido un error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}