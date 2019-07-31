package com.banico.calculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.banico.calculator.R

class CalculatorFragment : Fragment() {

    var display: AppCompatTextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_calculator, container, false)
        initView(v)
        return v
    }

    private fun initView(v: View?) {

        display = v?.findViewById(R.id.display)

        val one = v?.findViewById<AppCompatTextView>(R.id.num_one)
        val two = v?.findViewById<AppCompatTextView>(R.id.num_two)
        val three = v?.findViewById<AppCompatTextView>(R.id.num_three)
        val four = v?.findViewById<AppCompatTextView>(R.id.num_four)
        val five = v?.findViewById<AppCompatTextView>(R.id.num_five)
        val six = v?.findViewById<AppCompatTextView>(R.id.num_six)
        val seven = v?.findViewById<AppCompatTextView>(R.id.num_seven)
        val eight = v?.findViewById<AppCompatTextView>(R.id.num_eight)
        val nine = v?.findViewById<AppCompatTextView>(R.id.num_nine)

        val sum = v?.findViewById<AppCompatTextView>(R.id.sum)
        val subtract = v?.findViewById<AppCompatTextView>(R.id.subtract)
        val division = v?.findViewById<AppCompatTextView>(R.id.division)
        val multiply = v?.findViewById<AppCompatTextView>(R.id.multiply)
        val equivalent = v?.findViewById<AppCompatTextView>(R.id.equivalent)

        val clear = v?.findViewById<AppCompatTextView>(R.id.clear)

        val operandListener = View.OnClickListener {
            val dis = display?.text.toString()
            val number = (it as AppCompatTextView).text
            display?.text = dis.plus(number)
        }
        val operatorListener = View.OnClickListener {
            val dis = display?.text.toString()
            val operator = (it as AppCompatTextView).text
            display?.text = dis.plus("\n").plus(operator).plus("\n")
        }

        one?.setOnClickListener(operandListener)
        two?.setOnClickListener(operandListener)
        three?.setOnClickListener(operandListener)
        four?.setOnClickListener(operandListener)
        five?.setOnClickListener(operandListener)
        six?.setOnClickListener(operandListener)
        seven?.setOnClickListener(operandListener)
        eight?.setOnClickListener(operandListener)
        nine?.setOnClickListener(operandListener)

        sum?.setOnClickListener(operatorListener)
        subtract?.setOnClickListener(operatorListener)
        division?.setOnClickListener(operatorListener)
        multiply?.setOnClickListener(operatorListener)

        equivalent?.setOnClickListener { operate() }
        clear?.setOnClickListener { clearDisplay() }
    }

    private fun operate() {
        val statement = display?.text.toString().split("\n")
        val operandOne = statement[0]
        val operator = statement[1]
        val operandTwo = statement[2]

        var result = 0
        when (operator) {
            "+" -> result = operandOne.toInt() + operandTwo.toInt()
            "-" -> result = operandOne.toInt() - operandTwo.toInt()
            "/" -> result = operandOne.toInt() / operandTwo.toInt()
            "*" -> result = operandOne.toInt() * operandTwo.toInt()
        }

        display?.text = result.toString()
    }

    private fun clearDisplay() {
        display?.text = ""
    }
}
