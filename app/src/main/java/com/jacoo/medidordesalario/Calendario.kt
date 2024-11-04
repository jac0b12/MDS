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
    private var selectedDate: String = ""
    private val modelo = Modelo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        val imageView = findViewById<ImageView>(R.id.devolvitis2)
        imageView.setOnClickListener {
            val intent = Intent(this, Centralpage::class.java)
            startActivity(intent)
        }

        calendarView = findViewById(R.id.calendarView)
        addEventButton = findViewById(R.id.addEventButton)
        eventTextView = findViewById(R.id.eventTextView)

        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        selectedDate = sdf.format(calendarView.date)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year)
            updateEventTextView()
        }

        addEventButton.setOnClickListener {
            showAddEventDialog()
        }
    }

    private fun showAddEventDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Editar día")

        val dialogView = layoutInflater.inflate(R.layout.dialogo, null)
        builder.setView(dialogView)

        val editTextHours = dialogView.findViewById<EditText>(R.id.horastrabajadas)
        val editTextDomin = dialogView.findViewById<EditText>(R.id.horasdominicales)
        val editTextExtra = dialogView.findViewById<EditText>(R.id.horasextra)
        val editTextHour = dialogView.findViewById<EditText>(R.id.pagoporhora)

        builder.setPositiveButton("Guardar") { _, _ ->
            val hoursText = editTextHours.text.toString()
            val dominicalesText = editTextDomin.text.toString()
            val extraText = editTextExtra.text.toString()
            val hourText = editTextHour.text.toString()

            if (hoursText.isNotEmpty() && dominicalesText.isNotEmpty() && extraText.isNotEmpty() && hourText.isNotEmpty()) {
                modelo.insertaHorasTrabajadas(this, selectedDate, hoursText, dominicalesText, extraText, hourText)
                updateEventTextView()
            }
        }
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }
        builder.show()
    }

    private fun updateEventTextView() {
        val event = modelo.getHorasTrabajadas(this, selectedDate)
        if (event != null) {
            eventTextView.text = "Evento en $selectedDate: $event"
        } else {
            eventTextView.text = "No hay eventos en $selectedDate"
        }
    }
}
