package com.example.app23.fruit.data

import com.example.app23.R

class ItemData {

    companion object{
        fun getListItem(): ArrayList<ItemModel> {
            return arrayListOf(
                FruitModel(0, R.drawable.ic_apple, "Apple", "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."),
                FruitModel(1, R.drawable.ic_banana, "Banana", "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."),
                AdModel(2,"РЕКЛАМА","Сегодня у нас распродажа"),
                ProductModel(3,R.drawable.ic_units_24,"Смартфон","Супер новый смартфон",10),
                ProductModel(4,R.drawable.ic_alarms_24,"Будильник","Будильник самый громкий",5),
                FruitModel(5, R.drawable.ic_lemon, "Lemon", "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."),
                FruitModel(6, R.drawable.ic_pear, "Pear", "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."),
                AdModel(7,"АКЦИЯ","Скидки до 30%"),
                FruitModel(8, R.drawable.ic_strawberry, "Strawberry", "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."),
                FruitModel(9, R.drawable.ic_orange, "Orange", "Orange juice is widely used as a drink in restaurants and cafes.")
            )
        }

        fun getListItemUpdate():ArrayList<ItemModel>{
            return arrayListOf(
                FruitModel(0, R.drawable.ic_apple, "Apple", "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."),
                FruitModel(1, R.drawable.ic_banana, "Banana", "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."),
                FruitModel(2, R.drawable.ic_apple, "Apple0", "update0"),
                FruitModel(3, R.drawable.ic_banana, "Banana1", "update1"),
                FruitModel(4, R.drawable.ic_lemon, "Lemon2", "update2"),
                FruitModel(5, R.drawable.ic_orange, "Orange", "Orange juice is widely used as a drink in restaurants and cafes.")
            )
        }

    }

}