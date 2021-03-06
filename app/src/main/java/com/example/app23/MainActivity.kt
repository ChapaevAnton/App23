package com.example.app23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.fruit.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRecyclerView = findViewById<RecyclerView>(R.id.main_recycler_view)


        // TODO: 17.06.2021 23.3 ItemDecoration
//        val itemOffsetsDecoration = ItemOffsetsDecoration(this)
//        mainRecyclerView.addItemDecoration(itemOffsetsDecoration)

        // TODO: 17.06.2021 23.3 LayoutAnimation
        val addItemAnimLayout =
            AnimationUtils.loadLayoutAnimation(this, R.anim.add_item_anim_layout)
        mainRecyclerView.layoutAnimation = addItemAnimLayout
        mainRecyclerView.scheduleLayoutAnimation()


        // TODO: 19.06.2021 23.3 ItemAnimator1
        val fruitAdapter = FruitAdapter(ItemData.getListItem())
        // TODO: 19.06.2021 23.4 StableIds
        //fruitAdapter.setHasStableIds(true)
        mainRecyclerView.adapter = fruitAdapter
        mainRecyclerView.itemAnimator = ItemAnimatorFruit(this)


        val add = findViewById<Button>(R.id.add)
        val remove = findViewById<Button>(R.id.remove)
        val update = findViewById<Button>(R.id.update)
        val shuffle = findViewById<Button>(R.id.shuffle)

        add.setOnClickListener {

            fruitAdapter.listItem.add(
                ItemData.getListItem().random()
            )
            fruitAdapter.notifyItemInserted(fruitAdapter.listItem.lastIndex)
            mainRecyclerView.smoothScrollToPosition(fruitAdapter.itemCount)
        }

        remove.setOnClickListener {
            if (fruitAdapter.listItem.isNotEmpty()) {
                fruitAdapter.listItem.removeLast()
                fruitAdapter.notifyItemRemoved(fruitAdapter.listItem.size)
                mainRecyclerView.smoothScrollToPosition(fruitAdapter.itemCount)
            } else Toast.makeText(this, "empty list", Toast.LENGTH_SHORT)
                .apply { setGravity(Gravity.CENTER, 0, 0) }.show()
        }

        // TODO: 19.06.2021 23.4
        update.setOnClickListener {
            //StableIds
//            fruitAdapter.listItem[0].idIcon = R.drawable.ic_lemon
//            fruitAdapter.notifyItemChanged(0, "icon")

            //DiffUtil
            //?????????????????? Diff ?? ???????????????? DiffResult:
//            val diffFruit = FruitDiff(ItemData.getListItemUpdate(), fruitAdapter.listItem)
//            val diffResult = DiffUtil.calculateDiff(diffFruit)

            //???????????????? ???????????? ?? ???????????????????? ???? ???????? RecyclerView:
//            fruitAdapter.listItem = ItemData.getListItemUpdate()
//            diffResult.dispatchUpdatesTo(fruitAdapter)
        }

        shuffle.setOnClickListener {
//            val shuffleListFruit = ArrayList<FruitModel>(fruitAdapter.listItem.shuffled())
//
//            val diffFruitShuffle = FruitDiff(shuffleListFruit, fruitAdapter.listItem)
//            val diffFruitShuffleResult = DiffUtil.calculateDiff(diffFruitShuffle)
//            fruitAdapter.listItem.clear()
//            fruitAdapter.listItem.addAll(shuffleListFruit)
//            diffFruitShuffleResult.dispatchUpdatesTo(fruitAdapter)
        }

        // TODO: 17.06.2021 23.2
//        mainRecyclerView.layoutManager = GridLayoutManager(this,4)
//        mainRecyclerView.adapter = MainRecyclerAdapter()


        // TODO: 17.06.2021 repeat create recyclerview

//        val peopleRecyclerView = findViewById<RecyclerView>(R.id.main_recycler_view)
//        val peopleRecyclerAdapter = PeopleRecyclerAdapter()
//        peopleRecyclerAdapter.listPeople = mutableListOf(
//            People("????????????", 23),
//            People("????????????", 22),
//            People("??????????????", 55),
//            People("??????????????", 44)
//        )
//        peopleRecyclerView.adapter = peopleRecyclerAdapter

    }
}