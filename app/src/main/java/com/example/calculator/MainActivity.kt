package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {



            btn0.setOnClickListener {
                txtInput.append("0")
            }
            btn1.setOnClickListener {
                txtInput.append("1")
            }
            btn2.setOnClickListener {
                txtInput.append("2")
            }
            btn3.setOnClickListener {
                txtInput.append("3")
            }
            btn4.setOnClickListener {
                txtInput.append("4")
            }
            btn5.setOnClickListener {
                txtInput.append("5")
            }
            btn6.setOnClickListener {
                txtInput.append("6")
            }
            btn7.setOnClickListener {
                txtInput.append("7")
            }
            btn8.setOnClickListener {
                txtInput.append("8")
            }
            btn9.setOnClickListener {
                txtInput.append("9")
            }

            btnAC.setOnClickListener {
                if (txtInput.text.isNotEmpty()) {
                    txtInput.text = ""
                    txtAnswer.text = ""
                }
            }
            btnBackSpace.setOnClickListener {
                if (txtInput.text.isNotEmpty()) {
                    val currentText = txtInput.text.toString()
                    txtInput.text = currentText.substring(0, currentText.length - 1)
//                    txtInput.toString().dropLast(1)
                }
            }
            btnBracketOpen.setOnClickListener {
                txtInput.append("(")
            }
            btnBracketClose.setOnClickListener {
                txtInput.append(")")
            }
            btnDevide.setOnClickListener {
                txtInput.append("/")
            }
            btnMultiply.setOnClickListener {
                txtInput.append("*")
            }
            btnSubtract.setOnClickListener {
                txtInput.append("-")
            }
            btnAdd.setOnClickListener {
                txtInput.append("+")
            }
            btnDecimal.setOnClickListener {
                txtInput.append(".")
            }
            btnEqual.setOnClickListener {
                val input = txtInput.text.toString()
                if (input.isNotEmpty()) {
                    var userinput = input[input.length - 1].toString()
                    if (userinput == "0" || userinput == "1" || userinput == "2" || userinput == "3" || userinput == "4" || userinput == "5" || userinput == "6" || userinput == "7" || userinput == "8" || userinput == "9") {
                        /**=====================calculate=====================*/

                        val expression = ExpressionBuilder(txtInput.text.toString()).build()
                        val result = expression.evaluate().toDouble()
                        txtAnswer.text = result.toString()
                        txtInput.text.toString().chars()
                    } else {
                        val currentText = txtInput.text.toString()
                        txtInput.text = currentText.substring(0, currentText.length - 1)
                        val expression = ExpressionBuilder(txtInput.text.toString()).build()
                        val result = expression.evaluate().toDouble()
                        txtAnswer.text = result.toString()
                        txtInput.text.toString().chars()
                    }
                }
            }
        }
    }
}