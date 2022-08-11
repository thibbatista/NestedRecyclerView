package com.thiagosantos.recyclerview_vertical_horizontal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagosantos.recyclerview_vertical_horizontal.adapter.MainRecyclerAdapter
import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import com.thiagosantos.recyclerview_vertical_horizontal.rest.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var mainCategoryRecycler: RecyclerView
    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter
    private val retrofitService = RetrofitService.getInstance()
    val errorMessage = MutableLiveData<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = retrofitService.getAllItems()
        response.enqueue(object : Callback<List<AllCategory>> {
            override fun onResponse(
                call: Call<List<AllCategory>>,
                response: Response<List<AllCategory>?>
            ) {

                response.body()?.let { setMainCategoryRecycler(it) }

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

