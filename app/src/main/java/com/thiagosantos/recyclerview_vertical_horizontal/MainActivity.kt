package com.thiagosantos.recyclerview_vertical_horizontal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagosantos.recyclerview_vertical_horizontal.adapter.MainRecyclerAdapter
import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import com.thiagosantos.recyclerview_vertical_horizontal.model.CategoryItem

class MainActivity : AppCompatActivity() {

    private lateinit var mainCategoryRecycler: RecyclerView
    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // here we will add some dummy data to our model class

        // here we will add data to category item model class

        // added in first category
        val categoryItemList: MutableList<CategoryItem> = ArrayList()
        categoryItemList.add(CategoryItem(1, R.drawable.hollywood1))
        categoryItemList.add(CategoryItem(1, R.drawable.hollywood2))
        categoryItemList.add(CategoryItem(1, R.drawable.hollywood3))
        categoryItemList.add(CategoryItem(1, R.drawable.hollywood4))
        categoryItemList.add(CategoryItem(1, R.drawable.hollywood5))
        categoryItemList.add(CategoryItem(1, R.drawable.hollywood6))

        // added in second category

        // added in second category
        val categoryItemList2: MutableList<CategoryItem> = ArrayList()
        categoryItemList2.add(CategoryItem(1, R.drawable.bestofoscar1))
        categoryItemList2.add(CategoryItem(1, R.drawable.bestofoscar2))
        categoryItemList2.add(CategoryItem(1, R.drawable.bestofoscar3))
        categoryItemList2.add(CategoryItem(1, R.drawable.bestofoscar4))
        categoryItemList2.add(CategoryItem(1, R.drawable.bestofoscar5))
        categoryItemList2.add(CategoryItem(1, R.drawable.bestofoscar6))

        // added in 3rd category

        // added in 3rd category
        val categoryItemList3: MutableList<CategoryItem> = ArrayList()
        categoryItemList3.add(CategoryItem(1, R.drawable.moviedubbedinhindi1))
        categoryItemList3.add(CategoryItem(1, R.drawable.moviedubbedinhindi2))
        categoryItemList3.add(CategoryItem(1, R.drawable.moviedubbedinhindi3))
        categoryItemList3.add(CategoryItem(1, R.drawable.moviedubbedinhindi4))
        categoryItemList3.add(CategoryItem(1, R.drawable.moviedubbedinhindi5))
        categoryItemList3.add(CategoryItem(1, R.drawable.moviedubbedinhindi6))

        // added in 4th category

        // added in 4th category
        val categoryItemList4: MutableList<CategoryItem> = ArrayList()
        categoryItemList4.add(CategoryItem(1, R.drawable.hollywood1))
        categoryItemList4.add(CategoryItem(1, R.drawable.hollywood2))
        categoryItemList4.add(CategoryItem(1, R.drawable.hollywood3))
        categoryItemList4.add(CategoryItem(1, R.drawable.hollywood4))
        categoryItemList4.add(CategoryItem(1, R.drawable.hollywood5))
        categoryItemList4.add(CategoryItem(1, R.drawable.hollywood6))


        // added in 5th category


        // added in 5th category
        val categoryItemList5: MutableList<CategoryItem> = ArrayList()
        categoryItemList5.add(CategoryItem(1, R.drawable.bestofoscar1))
        categoryItemList5.add(CategoryItem(1, R.drawable.bestofoscar2))
        categoryItemList5.add(CategoryItem(1, R.drawable.bestofoscar3))
        categoryItemList5.add(CategoryItem(1, R.drawable.bestofoscar4))
        categoryItemList5.add(CategoryItem(1, R.drawable.bestofoscar5))
        categoryItemList5.add(CategoryItem(1, R.drawable.bestofoscar6))

        val allCategoryList: MutableList<AllCategory> = ArrayList()
        allCategoryList.add(AllCategory("Hollywood", categoryItemList))
        allCategoryList.add(AllCategory("Best of Oscars", categoryItemList2))
        allCategoryList.add(AllCategory("Movies Dubbed in Hindi", categoryItemList3))
        allCategoryList.add(AllCategory("Category 4th", categoryItemList4))
        allCategoryList.add(AllCategory("Category 5th", categoryItemList5))


        setMainCategoryRecycler(allCategoryList)



    }

    fun setMainCategoryRecycler(allCategoryList: List<AllCategory>) {
        mainCategoryRecycler = findViewById(R.id.main_recycler)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainCategoryRecycler.layoutManager = layoutManager
        mainRecyclerAdapter = MainRecyclerAdapter(this, allCategoryList)
        mainCategoryRecycler.adapter = mainRecyclerAdapter
    }
}

