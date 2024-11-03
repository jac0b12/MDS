package com.jacoo.medidordesalario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


public class Register : AppCompatActivity() {

    private lateinit var editTextId: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSave: Button
    private lateinit var modelo: Modelo
    private lateinit var editTextPasswordRepeat: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



        editTextId = findViewById(R.id.Password_input) // Asegúrate de tener un EditText para el ID
        editTextEmail = findViewById(R.id.EmailR_input)
        editTextPasswordRepeat = findViewById(R.id.repeatPassword_input)
        buttonSave = findViewById(R.id.register_btn)

        modelo = Modelo()

        buttonSave.setOnClickListener {
            val id = editTextId.text.toString()
            val email = editTextEmail.text.toString()
            val passwordRepeat = editTextPasswordRepeat.text.toString()

            if (id.isNotEmpty() && email.isNotEmpty() && passwordRepeat.isNotEmpty()) {


                if (passwordRepeat == id) {

                    val usuario = UsuariosDTO(email, id)
                    val result = modelo.insertaUsuario(this, usuario)


                    if (result == 1) {
                        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()

                        // Limpiar los campos
                        editTextId.text.clear()
                        editTextEmail.text.clear()
                        editTextPasswordRepeat.text.clear()

                        // Redirigir a la segunda actividad
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()
                    }
                }else {
                    Toast.makeText(this, "las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }


        val textButton = findViewById<TextView>(R.id.holaaa_btn)
        textButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }







}