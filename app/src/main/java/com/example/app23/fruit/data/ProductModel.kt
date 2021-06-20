package com.example.app23.fruit.data

import androidx.annotation.DrawableRes

data class ProductModel(
    override val id: Int,
    @DrawableRes
    var idIcon: Int,
    override val name: String,
    override val description: String,
    val count: Int = 0
) : ItemModel