package br.com.fiap.checkpoint01

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resultado_conta_telefone.*

class ResultadoContaTelefoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_conta_telefone)

        val resultSignature = intent.getFloatExtra("totalSignature", 0f)
        val resultTotalLocal = intent.getDoubleExtra("totalLocal", 0.0)
        val resultTotalCell = intent.getDoubleExtra("totalCell", 0.0)
        val resultValueTotal = intent.getDoubleExtra("valueTotal", 0.0)

        val txvResultSignature = String.format("%.2f", resultSignature)
        val txvResultTotalLocal = String.format("%.2f", resultTotalLocal)
        val txvResultTotalCell = String.format("%.2f", resultTotalCell)
        val txvResultValueTotal = String.format("%.2f", resultValueTotal)

        txvValorAssinatura.setText(txvResultSignature)
        txvValorChamadaLocal.setText(txvResultTotalLocal)
        txvValorChamadaCelular.setText(txvResultTotalCell)
        txvValorTotal.setText(txvResultValueTotal)
    }

    override fun finish() {
        super.finish()
    }
}