package com.example.database.main.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.database.R
import com.example.database.main.data.model.User
import com.example.database.main.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var addName: Button
    private lateinit var printName: Button
    private lateinit var enterName: EditText
    private lateinit var enterAge: EditText
    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUi()
        setListeners()
    }

    private fun initUi(){
        addName = findViewById(R.id.addName)
        printName = findViewById(R.id.printName)
        enterName = findViewById(R.id.enterName)
        enterAge = findViewById(R.id.enterAge)
        nameTextView = findViewById(R.id.Name)
        ageTextView = findViewById(R.id.Age)
    }

    @SuppressLint("SetTextI18n")
    private fun setListeners() {
        addName.setOnClickListener {
            val name = enterName.text.toString()
            val age = enterAge.text.toString().toIntOrNull()
            if ((name.isNotEmpty() && age != null)){
                val user = User(name = name, age = age)
                userViewModel.insert(user)
                enterName.text.clear()
                enterAge.text.clear()
            }
        }

        printName.setOnClickListener{
            userViewModel.allUsers.observe(this) { users ->
                val names = users.joinToString(separator = "\n") { it.name }
                val ages = users.joinToString(separator = "\n") { it.age.toString() }
                nameTextView.text = "Names:\n$names"
                ageTextView.text = "Ages:\n$ages"
            }
        }
    }
}