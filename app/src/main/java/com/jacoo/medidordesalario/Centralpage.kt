package com.jacoo.medidordesalario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Centralpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centralpage)


        //boton a calendario
        val buttonC = findViewById<Button>(R.id.calendario_btn)
        buttonC.setOnClickListener {
            val intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }

        //boton a salario
        val buttonS = findViewById<Button>(R.id.salario_btn)
        buttonS.setOnClickListener {
            val intent = Intent(this, Salariocalculado::class.java)
            startActivity(intent)
        }
    }
}