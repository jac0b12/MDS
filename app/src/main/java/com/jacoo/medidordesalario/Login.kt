package com.jacoo.medidordesalario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //boton a register
        val button = findViewById<Button>(R.id.iniciarSesion_btn)
        button.setOnClickListener {
            val intent = Intent(this, Centralpage::class.java)
            startActivity(intent)
        }

        //boton a login
        val textButton = findViewById<TextView>(R.id.register_btn)
        textButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}