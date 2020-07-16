package com.gustavo.cookapp.presentation.adapters

import Meal
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.cookapp.R
import com.gustavo.cookapp.base.BaseViewHolder
import kotlinx.android.synthetic.main.meal_row.view.*

class MainViewAdapter(
    private val context: Context,
    private val mealList: List<Meal>,
    private val itemOnMealClickListener: OnMealClickListener
)
    : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMealClickListener {
        fun onClick(meal: Meal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.meal_row, parent, false))
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is MainViewHolder -> holder.bind(mealList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Meal>(itemView) {
        override fun bind(item: Meal, position: Int) {
            itemView.txt_title_meal.text = item.strMeal
            itemView.txt_category_meal.text = "Category: ${item.strCategory}"
            Glide.with(context).load(item.strMealThumb).centerCrop().into(itemView.img_meal)
            itemView.setOnClickListener { itemOnMealClickListener.onClick(item) }
        }
    }
}