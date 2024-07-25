package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divisionButton: Button
    private lateinit var result: TextView
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText

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
        addButton = findViewById(R.id.add)
        subtractButton = findViewById(R.id.subtract)
        multiplyButton = findViewById(R.id.multiply)
        divisionButton = findViewById(R.id.division)
        result = findViewById(R.id.result)
        firstNumber =  findViewById(R.id.firstNumber)
        secondNumber = findViewById(R.id.secondNumber)
    }

    private fun setListeners(){

        addButton.setOnClickListener{
            performOperation(Operation.ADD)
        }

        multiplyButton.setOnClickListener {
            performOperation(Operation.MULTIPLY)
        }

        divisionButton.setOnClickListener {
            performOperation(Operation.DIVIDE)
        }

        subtractButton.setOnClickListener {
            performOperation(Operation.SUBTRACT)
        }
    }

    private fun performOperation(operation: Operation) {
        val num1 = firstNumber.text.toString().toIntOrNull()
        val num2 = secondNumber.text.toString().toIntOrNull()

        if (num1 == null || num2 == null) {
            result.text = "Please enter valid numbers"
            return
        }

        val answer = when (operation) {
            Operation.ADD -> num1 + num2
            Operation.SUBTRACT -> num1 - num2
            Operation.MULTIPLY -> num1 * num2
            Operation.DIVIDE -> {
                if (num2 == 0) {
                    result.text = "Cannot divide by zero"
                    return
                } else {
                    num1 / num2
                }
            }
        }

        result.text = answer.toString()
    }

    private enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
