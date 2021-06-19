package com.example.app23.fruit

import androidx.annotation.DrawableRes
import com.example.app23.R

data class Fruit(
    val id: Int,
    @DrawableRes
    var idIcon: Int,
    val name: String,
    val description: String
) {
    companion object{
        fun getListFruit(): ArrayList<Fruit> {
        return arrayListOf(
            Fruit(0, R.drawable.ic_apple, "Apple", "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."),
            Fruit(1, R.drawable.ic_banana, "Banana", "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."),
            Fruit(2, R.drawable.ic_lemon, "Lemon", "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."),
            Fruit(3, R.drawable.ic_pear, "Pear", "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."),
            Fruit(4, R.drawable.ic_strawberry, "Strawberry", "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."),
            Fruit(5, R.drawable.ic_orange, "Orange", "Orange juice is widely used as a drink in restaurants and cafes."))
        }

        fun getListFruitUpdate():ArrayList<Fruit>{
            return arrayListOf(
                Fruit(0, R.drawable.ic_apple, "Apple", "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."),
                Fruit(1, R.drawable.ic_banana, "Banana", "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."),
                Fruit(2, R.drawable.ic_apple, "Apple0", "update0"),
                Fruit(3, R.drawable.ic_banana, "Banana1", "update1"),
                Fruit(4, R.drawable.ic_lemon, "Lemon2", "update2"),
                Fruit(5, R.drawable.ic_orange, "Orange", "Orange juice is widely used as a drink in restaurants and cafes."))
        }

    }


}
