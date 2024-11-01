package com.jacoo.medidordesalario

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Calendario : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var addEventButton: Button
    private lateinit var eventTextView: TextView

    // HashMap para almacenar los eventos con la fecha como clave
    private val events = HashMap<String, String>()

    // Variable para almacenar la fecha seleccionada
    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        //boton devolvitis
        //devolvitis
        val ImageView = findViewById<ImageView>(R.id.devolvitis2)
        ImageView.setOnClickListener {
            val intent = Intent(this, Centralpage::class.java)
            startActivity(intent)
        }

        calendarView = findViewById(R.id.calendarView)
        addEventButton = findViewById(R.id.addEventButton)
        eventTextView = findViewById(R.id.eventTextView)

        // Obtener la fecha seleccionada inicialmente (hoy)
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        selectedDate = sdf.format(calendarView.date)

        // Escuchar el cambio de fecha en el CalendarView
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year)
            updateEventTextView()
        }

        // Escuchar el click del botón para agregar un evento
        addEventButton.setOnClickListener {
            showAddEventDialog()
        }
    }

    // Mostrar un cuadro de diálogo para agregar un evento
    private fun showAddEventDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Agregar Evento")

        // Crear un EditText para que el usuario escriba el evento
        val input = EditText(this)
        builder.setView(input)

        // Configurar los botones del cuadro de diálogo
        builder.setPositiveButton("Guardar") { _, _ ->
            val eventText = input.text.toString()
            if (eventText.isNotEmpty()) {
                events[selectedDate] = eventText
                updateEventTextView()
            }
        }
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }

    // Actualizar el TextView para mostrar el evento de la fecha seleccionada
    private fun updateEventTextView() {
        val event = events[selectedDate]
        if (event != null) {
            eventTextView.text = "Evento en $selectedDate: $event"
        } else {
            eventTextView.text = "No hay eventos en $selectedDate"
        }
    }
}