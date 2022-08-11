package com.thiagosantos.recyclerview_vertical_horizontal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagosantos.recyclerview_vertical_horizontal.R
import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import com.thiagosantos.recyclerview_vertical_horizontal.model.CategoryItem

class MainRecyclerAdapter(private val context: Context, private val allCategoryList: List<AllCategory> =  ArrayList()): RecyclerView.Adapter<MainViewHolder>() {

   // private val allCategoryList : List<AllCategory> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.categoryTitle.text = allCategoryList[position].categoryTitle
        setCatItemRecycler(holder.itemRecycler, allCategoryList[position].categoryItemList)


    }

    override fun getItemCount(): Int {
        return  allCategoryList.size
    }

    private fun setCatItemRecycler(recyclerView: RecyclerView, categoryItemList: List<CategoryItem>){

        val itemRecyclerAdapter = CategoryItemRecyclerAdapter(context, categoryItemList)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter

    }

}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val categoryTitle: TextView = itemView.findViewById(R.id.cat_title)
    val itemRecycler: RecyclerView = itemView.findViewById(R.id.item_recycler)
}