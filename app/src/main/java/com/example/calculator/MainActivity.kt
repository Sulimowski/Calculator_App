package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var operator: Char = ' '
    private var firstValue: Double = 0.0
    private var secondValue: Double = 0.0
    private var isNewOperator = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)
    }

    fun onNumberClick(view: View) {
        if (isNewOperator) {
            tvDisplay.text = ""
        }
        isNewOperator = false
        val button = view as Button
        val buttonText = button.text.toString()
        val currentText = tvDisplay.text.toString()
        tvDisplay.text = currentText + buttonText
    }

    fun onOperatorClick(view: View) {
        isNewOperator = true
        val button = view as Button
        operator = button.text.toString()[0]
        firstValue = tvDisplay.text.toString().toDouble()
    }

    fun onEqualClick(view: View) {
        secondValue = tvDisplay.text.toString().toDouble()
        var result = 0.0
        when (operator) {
            '+' -> result = firstValue + secondValue
            '-' -> result = firstValue - secondValue
            '×' -> result = firstValue * secondValue
            '÷' -> result = firstValue / secondValue
        }
        tvDisplay.text = result.toString()
    }

    fun onClearClick(view: View) {
        tvDisplay.text = "0"
        isNewOperator = true
    }

    fun onBackspaceClick(view: View) {
        val currentText = tvDisplay.text.toString()
        if (currentText.isNotEmpty()) {
            tvDisplay.text = currentText.dropLast(1)
        }
    }
}
