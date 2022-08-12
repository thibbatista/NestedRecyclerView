package com.thiagosantos.recyclerview_vertical_horizontal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thiagosantos.recyclerview_vertical_horizontal.R
import com.thiagosantos.recyclerview_vertical_horizontal.databinding.CategoryRowItemsBinding
import com.thiagosantos.recyclerview_vertical_horizontal.model.CategoryItem

class CategoryItemRecyclerAdapter(
    private val context: Context,
    private val categoryItemList: List<CategoryItem> = ArrayList()
) : RecyclerView.Adapter<CategoryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoryRowItemsBinding.inflate(inflater, parent, false)
        return CategoryItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {

        holder.bind(categoryItemList[position])

    }

    override fun getItemCount(): Int {
        return categoryItemList.size
    }
}

class CategoryItemViewHolder(binding: CategoryRowItemsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val itemImage: ImageView = binding.itemImage

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