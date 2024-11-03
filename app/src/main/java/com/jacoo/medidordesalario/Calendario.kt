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
        builder.setTitle("editar dia")

        // Inflar el layout personalizado
        val dialogView = layoutInflater.inflate(R.layout.dialogo, null)
        builder.setView(dialogView)

        // Obtener referencias a los EditText
        val editTextHours = dialogView.findViewById<EditText>(R.id.horastrabajadas)
        val editTextdomin = dialogView.findViewById<EditText>(R.id.horasdominicales)
        val editTextextra = dialogView.findViewById<EditText>(R.id.horasextra)
        val editTexthour = dialogView.findViewById<EditText>(R.id.pagoporhora)

        // Configurar los botones del cuadro de diálogo
        builder.setPositiveButton("Guardar") { _, _ ->
            val hoursText = editTextHours.text.toString()
            val descripTextdomin = editTextdomin.text.toString()
            val extextra = editTextextra.text.toString()
            val Texthour = editTexthour.text.toString()


            if (hoursText.isNotEmpty() && descripTextdomin.isNotEmpty() && extextra.isNotEmpty() && Texthour.isNotEmpty()) {
                // Puedes almacenar la información de varias maneras, aquí solo se muestra un ejemplo
                val eventText = "Horas: $hoursText, horas dominicales: $descripTextdomin,horas extra: $extextra, pago por hora: $Texthour"

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