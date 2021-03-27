package br.com.fiap.checkpoint01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addIntegrantes = AlertDialog.Builder(this)
            .setTitle("Integrantes do grupo:")
            .setMessage("""
                Carolina Gomes da Silva
                João Carlos Silva Muniz
                Luana Cunha Hitmomi Maruya""")
            .setPositiveButton("OK") { _, _ ->
                Toast.makeText(this, "Obrigado!", Toast.LENGTH_SHORT).show()
            }.create()
        btnIntegrantes.setOnClickListener {
            addIntegrantes.show()
        }
    }
}
