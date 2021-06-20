package com.example.app23.fruit.data

import androidx.annotation.DrawableRes

data class FruitModel(
    override val id: Int,
    @DrawableRes
    var idIcon: Int,
    override val name: String,
    override val description: String
) : ItemModel
