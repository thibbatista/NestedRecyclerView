package com.thiagosantos.recyclerview_vertical_horizontal.repositories

import com.thiagosantos.recyclerview_vertical_horizontal.rest.RetrofitService


class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllItems() = retrofitService.getAllItems()

}