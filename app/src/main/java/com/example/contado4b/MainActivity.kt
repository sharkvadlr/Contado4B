package com.example.contado4b

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Atributo privado del contador
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Referenciar los elementos de la interfaz
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)
        val btnDisminuir = findViewById<Button>(R.id.btnDisminuir)
        val btnReiniciar = findViewById<Button>(R.id.btnReiniciar)
        val tvContador = findViewById<TextView>(R.id.tvContador)
        val tvAdvertencia = findViewById<TextView>(R.id.tvAdvertencia)

        // Inicializar textos por defecto
        tvContador.text = contador.toString()
        tvAdvertencia.text = ""

        // Aumentar contador con el boton
        btnAumentar.setOnClickListener {
            tvAdvertencia.text = "" // Limpiar advertencia previa
            if (contador < 10) {
                // Aumentar el valor del contador del atributo contador
                contador++
                // Asignar el valor del contador en el texto
                tvContador.text = contador.toString()
            }

            // Si llega al límite máximo
            if (contador == 10) {
                tvAdvertencia.text = "Número máximo alcanzado"
            }
        }

        // Disminuir contador con el boton
        btnDisminuir.setOnClickListener {
            tvAdvertencia.text = "" // Limpiar advertencia previa
            if (contador > 0) {
                // Disminuir el valor del atributo contador
                contador--
                // Asignar el valor del contador en el texto
                tvContador.text = contador.toString()
            }

            // Si llega al límite mínimo
            if (contador == 0) {
                tvAdvertencia.text = "No se permiten números negativos"
            }
        }

        // Reiniciar contador con el boton
        btnReiniciar.setOnClickListener {
            // Restablecer el valor del atributo contador a 0
            contador = 0
            // Asignar el valor del contador en el texto
            tvContador.text = contador.toString()
            tvAdvertencia.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}