package com.jacoo.medidordesalario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {

    private lateinit var editTextId: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var modelo: Modelo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextId = findViewById(R.id.Email_is)
        editTextPassword = findViewById(R.id.password_is)
        buttonLogin = findViewById(R.id.iniciarSesion_btn)
        modelo = Modelo()

        buttonLogin.setOnClickListener {
            val id = editTextId.text.toString()
            val password = editTextPassword.text.toString()

            if (id.isNotEmpty() && password.isNotEmpty()) {
                if (modelo.loginUsuario(this, id, password)) {
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Centralpage::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }


        //boton a register
        val textButton = findViewById<TextView>(R.id.register_btn)
        textButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}