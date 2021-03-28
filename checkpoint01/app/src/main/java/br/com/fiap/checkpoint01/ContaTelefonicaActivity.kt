package br.com.fiap.checkpoint01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_conta_telefonica.*

class ContaTelefonicaActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)
        btnContaCalcular.setOnClickListener(this)
    }

    private fun validateFields(): Boolean {
        val signatureValue = valorAssinatura.text.toString().trim()
        val localCall = chamadaLocal.text.toString().trim()
        val cellCall = chamadaCelular.text.toString().trim()

        if (signatureValue.isEmpty()) {
            valorAssinatura.error = "Campo obrigatório"
            valorAssinatura.requestFocus()
            return false
        } else if (localCall.isEmpty()) {
            chamadaLocal.error = "Campo obrigatório"
            chamadaLocal.requestFocus()
            return false
        } else if (cellCall.isEmpty()) {
            chamadaCelular.error = "Campo obrigatório"
            chamadaCelular.requestFocus()
            return false
        }
        return true
    }

    private fun calculatorTotal() {
        if(!validateFields()){
            return
        }
        val signatureValue = valorAssinatura.text.toString().trim().toDouble()
        val localCall = chamadaLocal.text.toString().trim().toDouble() * 0.04
        val cellCall = chamadaCelular.text.toString().trim().toDouble() * 0.20
        val total = signatureValue + localCall + cellCall
        showResults(signatureValue, localCall, cellCall, total)
    }

    private fun showResults(signatureValue: Double, localCall: Double, cellCall: Double, total: Double){
        val mIntent = Intent(this, ResultadoContaTelefoneActivity::class.java)
        mIntent.putExtra("totalSignature", signatureValue)
        mIntent.putExtra("totalLocal", localCall)
        mIntent.putExtra("totalCell", cellCall)
        mIntent.putExtra("valueTotal", total)
        startActivity(mIntent)
    }

    override fun onClick(v: View?) {
        calculatorTotal()
    }
}