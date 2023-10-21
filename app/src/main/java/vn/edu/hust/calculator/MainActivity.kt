package vn.edu.hust.calculator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val add = '+'
    private val sub = '-'
    private val mul = '*'
    private val div = '/'

    private lateinit var result : TextView
    private lateinit var plusminus : Button
    private lateinit var zero : Button
    private lateinit var dot : Button
    private lateinit var equal : Button

    private lateinit var one : Button
    private lateinit var two : Button
    private lateinit var three : Button
    private lateinit var plus : Button

    private lateinit var four : Button
    private lateinit var five : Button
    private lateinit var six : Button
    private lateinit var minus : Button

    private lateinit var seven : Button
    private lateinit var eight : Button
    private lateinit var nine : Button
    private lateinit var multiply : Button

    private lateinit var ce : Button
    private lateinit var c : Button
    private lateinit var bs : Button
    private lateinit var divide : Button

    private var currentSymbol: Char = '0'

    private var calculated: Boolean = false

    private var firstValue = Double.NaN
    private var secondValue = Double.NaN
    private var decimalformat: DecimalFormat = DecimalFormat("#.####")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_no_constraint)

        result = findViewById(R.id.result) as TextView

        plusminus = findViewById(R.id.plusminus) as Button
        zero = findViewById(R.id.zero) as Button
        dot = findViewById(R.id.dot) as Button
        equal = findViewById(R.id.equal) as Button

        one = findViewById(R.id.one) as Button
        two = findViewById(R.id.two) as Button
        three = findViewById(R.id.three) as Button
        plus = findViewById(R.id.plus) as Button

        four = findViewById(R.id.four) as Button
        five = findViewById(R.id.five) as Button
        six = findViewById(R.id.six) as Button
        minus = findViewById(R.id.minus) as Button

        seven = findViewById(R.id.seven) as Button
        eight = findViewById(R.id.eight) as Button
        nine = findViewById(R.id.nine) as Button
        multiply = findViewById(R.id.multiply) as Button

        ce = findViewById(R.id.ce) as Button
        c = findViewById(R.id.c) as Button
        bs = findViewById(R.id.bs) as Button
        divide = findViewById(R.id.divide) as Button


        var toast1: Toast

        zero.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text != "0")
                result.setText(result.text.toString() + "0")
        }
        one.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "1")
        }
        two.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "2")
        }
        three.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "3")
        }
        four.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "4")
        }
        five.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "5")
        }
        six.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "6")
        }
        seven.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "7")
        }
        eight.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "8")
        }
        nine.setOnClickListener {
            if (calculated){
	            result.setText("")
	            calculated = false
            }
            if (result.text == "0") result.setText("")
            result.setText(result.text.toString() + "9")
        }

        plus.setOnClickListener {
            allCalculations()
            currentSymbol = add
            result.setText(decimalformat.format(firstValue))
            resetColor()
            plus.setBackgroundColor(Color.RED)
            calculated = true
        }
        minus.setOnClickListener {
            allCalculations()
            currentSymbol = sub
            result.setText(decimalformat.format(firstValue))
            resetColor()
            minus.setBackgroundColor(Color.RED)
            calculated = true
        }
        multiply.setOnClickListener {
            allCalculations()
            currentSymbol = mul
            result.setText(decimalformat.format(firstValue))
            resetColor()
            multiply.setBackgroundColor(Color.RED)
            calculated = true
        }
        divide.setOnClickListener {
            allCalculations()
            currentSymbol = div
            result.setText(decimalformat.format(firstValue))
            resetColor()
            divide.setBackgroundColor(Color.RED)
            calculated = true
        }
        dot.setOnClickListener {
            result.setText(result.getText().toString() + ".")
        }
        plusminus.setOnClickListener {
            if (result.getText().startsWith('-'))
                result.setText(result.getText().drop(1))
            else
                result.setText("-" + result.getText())
        }
        c.setOnClickListener {
            result.setText("0")
            currentSymbol = '0'
            resetColor()
            calculated = false;
        }
        bs.setOnClickListener {
            if (result.getText().length>1) run {
                val currentText: CharSequence = result.getText()
                result.setText(currentText.subSequence(0, currentText.length-1))
            } else{
                firstValue = Double.NaN
                secondValue = Double.NaN
                result.setText("0")
            }
        }
        ce.setOnClickListener {
            resetColor()
            currentSymbol = '0'
            calculated = false;
        }
        equal.setOnClickListener {
            allCalculations()
            resetColor()
            result.setText(decimalformat.format(firstValue))
            firstValue = Double.NaN
            currentSymbol = '0'
            calculated = true;
        }

    }
    private fun allCalculations(){

        if (!firstValue.isNaN()){
            secondValue = result.getText().toString().toDouble()
            result.setText(null)

            if (currentSymbol == add)
                firstValue += secondValue
            else if (currentSymbol == sub)
                firstValue -= secondValue
            else if (currentSymbol == mul)
                firstValue *= secondValue
            else if (currentSymbol == div)
                firstValue /= secondValue
        } else{
            try {
                firstValue = result.getText().toString().toDouble()
            } catch (_: Exception){

            }
        }
    }
    private fun resetColor(){
        plus.setBackgroundColor(Color.parseColor("#606060"))
        plus.setTextColor(Color.parseColor("#ffffff"))
        minus.setBackgroundColor(Color.parseColor("#606060"))
        minus.setTextColor(Color.parseColor("#ffffff"))
        multiply.setBackgroundColor(Color.parseColor("#606060"))
        multiply.setTextColor(Color.parseColor("#ffffff"))
        divide.setBackgroundColor(Color.parseColor("#606060"))
        divide.setTextColor(Color.parseColor("#ffffff"))
    }
}