package com.thiagosantos.recyclerview_vertical_horizontal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thiagosantos.recyclerview_vertical_horizontal.R
import com.thiagosantos.recyclerview_vertical_horizontal.model.CategoryItem

class CategoryItemRecyclerAdapter(
    private val context: Context,
    private val categoryItemList: List<CategoryItem> = ArrayList()
) : RecyclerView.Adapter<CategoryItemViewHolder>() {

    //private val categoryItemList : List<CategoryItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {

        return CategoryItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {

        holder.bind(categoryItemList[position])

        //holder.itemImage.setImageResource(categoryItemList[position].imageUrl)
    }

    override fun getItemCount(): Int {
        return categoryItemList.size
    }
}

class CategoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val itemImage: ImageView = itemView.findViewById(R.id.item_image)

    fun bind(categoryItem: CategoryItem) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(categoryItem.imageUrl)
            .into(itemImage)
    }
}