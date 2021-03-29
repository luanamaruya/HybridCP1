package br.com.fiap.checkpoint01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.System.exit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculadora.setOnClickListener{
            val mIntent = Intent(this, CalculadoraActivity::class.java)
            this.startActivity(mIntent)
        }

        val addIntegrantes = AlertDialog.Builder(this)
            .setTitle("Integrantes do grupo:")
            .setMessage("Carolina Gomes da Silva \nJoão Carlos Silva Muniz \nLuana Cunha Hitomi Maruya")
            .setPositiveButton("OK") { _, _ ->
                Toast.makeText(this, "Obrigado!", Toast.LENGTH_SHORT).show()
            }.create()
        btnIntegrantes.setOnClickListener {
            addIntegrantes.show()
        }

        btnConta.setOnClickListener {
            val mIntent = Intent(this, ContaTelefonicaActivity::class.java)
            this.startActivity(mIntent)
        }

    }
}

