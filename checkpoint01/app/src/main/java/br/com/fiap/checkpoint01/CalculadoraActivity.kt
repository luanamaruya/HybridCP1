package br.com.fiap.checkpoint01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_main.*

class CalculadoraActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    enum class Operator(val type: Int) {
        PLUS(R.id.radioSoma),
        MINUS(R.id.radioSubtracao),
        TIMES(R.id.radioMultiplicacao),
        DIVIDEDBY(R.id.radioDivisao);

        fun calcular(num1: Float, num2: Float): Float {
            return when(this) {
                PLUS -> num1 + num2
                MINUS -> num1 - num2
                TIMES -> num1 * num2
                DIVIDEDBY -> num1 / num2
            }
        }
    }

    private var operator: Operator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        radioGroup.setOnCheckedChangeListener(this)
        btnCalcular.setOnClickListener(this)
    }

    private fun validateFields(): Boolean {
        val value1 = edtCalculadoraValue1.text.toString().trim()
        val value2 = edtCalculadoraValue2.text.toString().trim()

        if (value1.isEmpty()){
            edtCalculadoraValue1.error = "Campo obrigatório"
            edtCalculadoraValue1.requestFocus()
            return false
        } else if (value2.isEmpty()) {
            edtCalculadoraValue2.error = "Campo obrigatório"
            edtCalculadoraValue2.requestFocus()
            return false
        }
        return true
    }

    private fun executeCalculator() {
        val value1 = edtCalculadoraValue1.text.toString().trim().toFloat()
        val value2 = edtCalculadoraValue2.text.toString().trim().toFloat()
        val result = operator?.calcular(value1, value2).toString()
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        operator = Operator.values().firstOrNull { it.type == checkedId }
    }

    override fun onClick(v: View?) {
        if (validateFields()) {
            executeCalculator()
        }
    }
}