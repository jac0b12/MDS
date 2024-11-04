package com.jacoo.medidordesalario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class Salariocalculado : AppCompatActivity() {

    private lateinit var salarioTextView: TextView
    private lateinit var horasTrabajadasTextView: TextView
    private lateinit var horasDominicalesTextView: TextView
    private lateinit var horasExtraTextView: TextView
    private lateinit var pagoPorHoraTextView: TextView

    private lateinit var horasTrabajadasEditText: EditText
    private lateinit var horasDominicalesEditText: EditText
    private lateinit var horasExtraEditText: EditText
    private lateinit var agregarHorasButton: Button

    private var totalHorasTrabajadas = 0.0
    private var totalHorasDominicales = 0.0
    private var totalHorasExtra = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salariocalculado)


        val imageView = findViewById<ImageView>(R.id.devolvitis2)
        imageView.setOnClickListener {
            val intent = Intent(this, Centralpage::class.java)
            startActivity(intent)
        }

        // Inicializar los TextViews
        salarioTextView = findViewById(R.id.text2)
        horasTrabajadasTextView = findViewById(R.id.text3)
        horasDominicalesTextView = findViewById(R.id.text4)
        horasExtraTextView = findViewById(R.id.text5)
        pagoPorHoraTextView = findViewById(R.id.text7)

        // Inicializar los EditTexts
        horasTrabajadasEditText = findViewById(R.id.horasTrabajadasEditText)
        horasDominicalesEditText = findViewById(R.id.horasDominicalesEditText)
        horasExtraEditText = findViewById(R.id.horasExtraEditText)

        // Inicializar el botón
        agregarHorasButton = findViewById(R.id.agregarHorasButton)

        // Configurar el botón para agregar horas
        agregarHorasButton.setOnClickListener {
            agregarHoras()
        }

        // Configurar el pago por hora (puedes cambiarlo según el ingreso del usuario)
        val pagoPorHora = 10000.0
        pagoPorHoraTextView.text = "PAGO POR HORA: $pagoPorHora"
    }

    private fun agregarHoras() {
        // Obtener las horas ingresadas
        val horasTrabajadas = horasTrabajadasEditText.text.toString().toDoubleOrNull() ?: 0.0
        val horasDominicales = horasDominicalesEditText.text.toString().toDoubleOrNull() ?: 0.0
        val horasExtra = horasExtraEditText.text.toString().toDoubleOrNull() ?: 0.0

        // Sumar las horas a los totales
        totalHorasTrabajadas += horasTrabajadas
        totalHorasDominicales += horasDominicales
        totalHorasExtra += horasExtra

        // Actualizar la interfaz
        horasTrabajadasTextView.text = "HORAS TRABAJADAS: $totalHorasTrabajadas"
        horasDominicalesTextView.text = "HORAS DOMINCALES: $totalHorasDominicales"
        horasExtraTextView.text = "HORAS EXTRA: $totalHorasExtra"

        // Calcular el salario total y mostrarlo
        val salarioTotal = calcularSalario(totalHorasTrabajadas, totalHorasDominicales, totalHorasExtra, 10000.0)
        salarioTextView.text = "SALARIO CALCULADO: $salarioTotal"

        // Limpiar los EditTexts después de agregar horas
        horasTrabajadasEditText.text.clear()
        horasDominicalesEditText.text.clear()
        horasExtraEditText.text.clear()
    }

    private fun calcularSalario(horasTrabajadas: Double, horasDominicales: Double, horasExtra: Double, pagoPorHora: Double): Double {
        val porcentajeDominical = 0.5 // 50% más por trabajo dominical
        val porcentajeExtra = 1.0 // 100% más por horas extra

        val salarioBasico = horasTrabajadas * pagoPorHora
        val salarioDominical = horasDominicales * pagoPorHora * (1 + porcentajeDominical)
        val salarioExtra = horasExtra * pagoPorHora * (1 + porcentajeExtra)

        return salarioBasico + salarioDominical + salarioExtra
    }
}
