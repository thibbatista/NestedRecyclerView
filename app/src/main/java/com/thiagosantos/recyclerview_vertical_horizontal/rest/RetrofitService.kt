package com.thiagosantos.recyclerview_vertical_horizontal.rest

import com.thiagosantos.recyclerview_vertical_horizontal.model.AllCategory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("api.json")
    fun getAllItems(): Call<List<AllCategory>>

    companion object {

        private val retrofitService: RetrofitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://thibbatista.github.io/api_recyclerView/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance(): RetrofitService {
            return retrofitService
        }
    }
}