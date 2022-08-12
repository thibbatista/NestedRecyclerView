package com.thiagosantos.recyclerview_vertical_horizontal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagosantos.recyclerview_vertical_horizontal.databinding.MainRecyclerRowItemBinding
import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import com.thiagosantos.recyclerview_vertical_horizontal.model.CategoryItem

class MainRecyclerAdapter(
    private val context: Context,
    private val allCategoryList: List<AllCategory>
) : RecyclerView.Adapter<MainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainRecyclerRowItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.categoryTitle.text = allCategoryList[position].categoryTitle
        setCatItemRecycler(holder.itemRecycler, allCategoryList[position].categoryItemList)

    }

    override fun getItemCount(): Int {
        return allCategoryList.size
    }

    private fun setCatItemRecycler(
        recyclerView: RecyclerView,
        categoryItemList: List<CategoryItem>
    ) {

        val itemRecyclerAdapter = CategoryItemRecyclerAdapter(context, categoryItemList)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter

    }

}

class MainViewHolder(binding: MainRecyclerRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

    val categoryTitle = binding.catTitle
    val itemRecycler = binding.itemRecycler

}