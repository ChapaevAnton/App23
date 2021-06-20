package com.example.app23.fruit.data

import androidx.annotation.DrawableRes

data class FruitModel(
    val id: Int,
    @DrawableRes
    var idIcon: Int,
    val name: String,
    val description: String
): ItemModel
