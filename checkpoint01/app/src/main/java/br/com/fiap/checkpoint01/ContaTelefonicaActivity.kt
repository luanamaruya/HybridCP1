package br.com.fiap.checkpoint01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_conta_telefonica.*

class ContaTelefonicaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)

        btnContaCalcular.setOnClickListener {
            val signatureValue = valorAssinatura.text.toString().trim().toFloat()
            val localCall = chamadaLocal.text.toString().trim().toFloat() * 0.04
            val cellCall = chamadaCelular.text.toString().trim().toFloat() * 0.20
            val total = signatureValue + localCall + cellCall

            val mIntent = Intent(this, ResultadoContaTelefoneActivity::class.java)
            mIntent.putExtra("totalSignature", signatureValue)
            mIntent.putExtra("totalLocal", localCall)
            mIntent.putExtra("totalCell", cellCall)
            mIntent.putExtra("valueTotal", total)
            startActivity(mIntent)
        }
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
        }
        return true
    }
}