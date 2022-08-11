package com.thiagosantos.recyclerview_vertical_horizontal

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagosantos.recyclerview_vertical_horizontal.adapter.MainRecyclerAdapter
import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import com.thiagosantos.recyclerview_vertical_horizontal.repositories.MainRepository
import com.thiagosantos.recyclerview_vertical_horizontal.rest.RetrofitService
import com.thiagosantos.recyclerview_vertical_horizontal.viewModel.MainViewModel
import com.thiagosantos.recyclerview_vertical_horizontal.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter
    private lateinit var mainCategoryRecycler: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

    }


    override fun onStart() {
        super.onStart()

        viewModel.allCategoryList.observe(this) {
            Log.d(TAG, "onCreate: $it")

            setMainCategoryRecycler(it)

        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllCategory()

    }

    private fun setMainCategoryRecycler(allCategoryList: List<AllCategory>) {
        mainCategoryRecycler = findViewById(R.id.main_recycler)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainCategoryRecycler.layoutManager = layoutManager
        mainRecyclerAdapter = MainRecyclerAdapter(this, allCategoryList)
        mainCategoryRecycler.adapter = mainRecyclerAdapter
    }

}

