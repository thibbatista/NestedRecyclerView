package com.thiagosantos.recyclerview_vertical_horizontal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagosantos.recyclerview_vertical_horizontal.adapter.MainRecyclerAdapter
import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import com.thiagosantos.recyclerview_vertical_horizontal.repositories.MainRepository
import com.thiagosantos.recyclerview_vertical_horizontal.rest.RetrofitService
import com.thiagosantos.recyclerview_vertical_horizontal.viewModel.MainViewModel
import com.thiagosantos.recyclerview_vertical_horizontal.viewModel.MainViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //private lateinit var mainRepository: MainRepository
    private lateinit var mainCategoryRecycler: RecyclerView
    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter
    private val retrofitService = RetrofitService.getInstance()
    //lateinit var viewModel: MainViewModel
   // private val TAG = "MainActivity"
    val errorMessage = MutableLiveData<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = retrofitService.getAllItems()
        response.enqueue(object : Callback<List<AllCategory>> {
            override fun onResponse(
                call: Call<List<AllCategory>>,
                response: Response<List<AllCategory>>
            ) {
                val body= response?.body()

                if (body != null) {
                    setMainCategoryRecycler(body)
                }

            }

            override fun onFailure(call: Call<List<AllCategory>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })



    }

    private fun setMainCategoryRecycler(allCategoryList: List<AllCategory>) {
        mainCategoryRecycler = findViewById(R.id.main_recycler)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainCategoryRecycler.layoutManager = layoutManager
        mainRecyclerAdapter = MainRecyclerAdapter(this, allCategoryList)
        mainCategoryRecycler.adapter = mainRecyclerAdapter
    }

}

