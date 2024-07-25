package com.example.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.adapter.ItemRecyclerViewAdapter
import com.example.recycleview.model.ItemModel

class MainActivity : AppCompatActivity() {
    private val itemList = ArrayList<ItemModel>()
    private lateinit var itemRecyclerViewAdapter: ItemRecyclerViewAdapter
    private lateinit var itemRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI(){

        itemRecyclerView = findViewById(R.id.recyclerView)
        itemRecyclerView.layoutManager = LinearLayoutManager(this)

        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Burger" , "5$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Pizza" , "7$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Mexican Pizza" , "10$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Taco" , "2$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Beef Burger" , "12$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Mutton Burger" , "14$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Zinger Burger" , "9$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Chicken Pizza" , "4$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Vege Pizza" , "3$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "kebab Pizza" , "15$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Coca Cola" , "1.5$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Salad" , "2.5$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Fish" , "2$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "French Fries" , "3$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Italian Pizza" , "12$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Pasta" , "6$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Patty Burger" , "11$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Shawarma" , "4$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Chicken Roll" , "7$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Chicken Pieces" , "9$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Paratha Roll" , "4$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Mango Shake" , "2$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Peach Juice" , "2.5$"))
        itemList.add(ItemModel(image = R.drawable.ic_action_name , "Orange Juice" , "3.5$"))

        itemRecyclerViewAdapter = ItemRecyclerViewAdapter(itemList)
        itemRecyclerView.adapter = itemRecyclerViewAdapter

    }
}