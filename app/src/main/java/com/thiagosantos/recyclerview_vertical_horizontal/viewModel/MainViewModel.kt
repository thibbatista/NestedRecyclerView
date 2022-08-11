package com.thiagosantos.recyclerview_vertical_horizontal.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import com.thiagosantos.recyclerview_vertical_horizontal.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val allCategoryList = MutableLiveData<List<AllCategory>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives() {

        val response = repository.getAllItems()
        response.enqueue(object : Callback<List<AllCategory>> {
            override fun onResponse(
                call: Call<List<AllCategory>>,
                response: Response<List<AllCategory>>
            ) {
                allCategoryList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<AllCategory>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}