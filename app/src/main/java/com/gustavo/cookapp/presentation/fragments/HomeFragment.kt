package com.gustavo.cookapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gustavo.cookapp.R
import com.gustavo.cookapp.base.Resource
import com.gustavo.cookapp.data.datasource.Datasource
import com.gustavo.cookapp.domain.MealRepositoryImpl
import com.gustavo.cookapp.presentation.adapters.MainViewAdapter
import com.gustavo.cookapp.presentation.viewmodels.MainViewModel
import com.gustavo.cookapp.presentation.viewmodels.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*


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
        setupRecyclerViewMeals()

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.setMeal(newText!!)
                return false
            }
        })
    }

    private fun setupRecyclerViewMeals() {
        rv_meals.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupObservers() {
        viewModel.getMealList.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("MEALS", "Lista de comidas: ${result.data}")
                    progressBar.visibility = View.GONE
                    rv_meals.adapter = MainViewAdapter(requireContext(), result.data)
                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ha ocurrido un error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}