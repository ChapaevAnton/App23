package com.example.app23

import android.os.Bundle
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.fruit.*
import com.example.app23.fruit.data.ItemData
import com.example.app23.fruit.data.ItemModel

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
        val itemAdapter = ItemAdapter(ItemData.getListItem())
        // TODO: 19.06.2021 23.4 StableIds
        //fruitAdapter.setHasStableIds(true)
        mainRecyclerView.adapter = itemAdapter
        mainRecyclerView.itemAnimator = ItemAnimatorFruit(this)

        // TODO: 20.06.2021 23.6. Работа со скроллом
        var isLoading = false
        mainRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as RecyclerView.LayoutManager
                val visibleItemCount: Int =
                    layoutManager.childCount //смотрим сколько элементов на экране
                val totalItemCount: Int = layoutManager.itemCount //сколько всего элементов
                val firstVisibleItems: Int =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition() //какая позиция первого элемента

                if (!isLoading) { //проверяем, грузим мы что-то или нет, эта переменная должна быть вне класса  OnScrollListener
                    if (visibleItemCount + firstVisibleItems >= totalItemCount) {
                        isLoading = true //ставим флаг что мы попросили еще элемены
                        //load data
                    }
                }
            }
        })

        val add = findViewById<Button>(R.id.add)
        val remove = findViewById<Button>(R.id.remove)
        val update = findViewById<Button>(R.id.update)
        val shuffle = findViewById<Button>(R.id.shuffle)

        add.setOnClickListener {

            itemAdapter.listItem.add(
                ItemData.getListItem().random()
            )
            itemAdapter.notifyItemInserted(itemAdapter.listItem.lastIndex)
            mainRecyclerView.smoothScrollToPosition(itemAdapter.itemCount)
        }

        remove.setOnClickListener {
            if (itemAdapter.listItem.isNotEmpty()) {
                itemAdapter.listItem.removeLast()
                itemAdapter.notifyItemRemoved(itemAdapter.listItem.size)
                mainRecyclerView.smoothScrollToPosition(itemAdapter.itemCount)
            } else Toast.makeText(this, "empty list", Toast.LENGTH_SHORT)
                .apply { setGravity(Gravity.CENTER, 0, 0) }.show()
        }

        // TODO: 19.06.2021 23.4
        update.setOnClickListener {
            //StableIds
//            fruitAdapter.listItem[0].idIcon = R.drawable.ic_lemon
//            fruitAdapter.notifyItemChanged(0, "icon")

            //DiffUtil
            //Вычислить Diff и получить DiffResult:
            val diffFruit = ItemDiff(ItemData.getListItemUpdate(), itemAdapter.listItem)
            val diffResult = DiffUtil.calculateDiff(diffFruit)

            //Обновить данные и оповестить об этом RecyclerView:
            itemAdapter.listItem = ItemData.getListItemUpdate()
            diffResult.dispatchUpdatesTo(itemAdapter)
        }

        shuffle.setOnClickListener {
            val shuffleListFruit = ArrayList<ItemModel>(itemAdapter.listItem.shuffled())

            val diffFruitShuffle = ItemDiff(shuffleListFruit, itemAdapter.listItem)
            val diffFruitShuffleResult = DiffUtil.calculateDiff(diffFruitShuffle)
            itemAdapter.listItem.clear()
            itemAdapter.listItem.addAll(shuffleListFruit)
            diffFruitShuffleResult.dispatchUpdatesTo(itemAdapter)
        }
        // TODO: 21.06.2021 23.6 Практика Up Save Down
        val upPage = findViewById<Button>(R.id.up_page)
        val downPage = findViewById<Button>(R.id.down_page)
        val savePage = findViewById<Button>(R.id.save_page)
        val layoutManager = mainRecyclerView.layoutManager as LinearLayoutManager

        var savePositionFirst = 0
        var savePositionLast = 0

        fun savePosition() {
            savePositionFirst = layoutManager.findFirstCompletelyVisibleItemPosition()
            savePositionLast = layoutManager.findLastCompletelyVisibleItemPosition()
        }

        fun scrollToStart() {
            mainRecyclerView.scrollToPosition(0)
        }

        fun scrollToSaveStartPosition() {
            mainRecyclerView.scrollToPosition(savePositionFirst)
        }

        fun scrollToSaveLastPosition() {
            mainRecyclerView.scrollToPosition(savePositionLast)
        }

        fun scrollToEnd() {
            mainRecyclerView.scrollToPosition(itemAdapter.itemCount - 1)
        }
        upPage.setOnClickListener {
            if (layoutManager.findFirstVisibleItemPosition() == 0) {
                scrollToSaveLastPosition()
            } else scrollToStart()
        }
        downPage.setOnClickListener {
            if (layoutManager.findLastVisibleItemPosition() == itemAdapter.itemCount - 1) {
                scrollToSaveStartPosition()
            } else
                scrollToEnd()
        }
        savePage.setOnClickListener {
            savePosition()
        }


        // TODO: 17.06.2021 23.2
//        mainRecyclerView.layoutManager = GridLayoutManager(this,4)
//        mainRecyclerView.adapter = MainRecyclerAdapter()


        // TODO: 17.06.2021 repeat create recyclerview

//        val peopleRecyclerView = findViewById<RecyclerView>(R.id.main_recycler_view)
//        val peopleRecyclerAdapter = PeopleRecyclerAdapter()
//        peopleRecyclerAdapter.listPeople = mutableListOf(
//            People("Иванов", 23),
//            People("Петров", 22),
//            People("Сидоров", 55),
//            People("Кузьмин", 44)
//        )
//        peopleRecyclerView.adapter = peopleRecyclerAdapter

    }
}