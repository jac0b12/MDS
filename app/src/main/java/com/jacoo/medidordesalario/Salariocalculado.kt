package com.jacoo.medidordesalario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Salariocalculado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salariocalculado)

        //devolvitis
        val ImageView = findViewById<ImageView>(R.id.devolvitis2)
        ImageView.setOnClickListener {
            val intent = Intent(this, Centralpage::class.java)
            startActivity(intent)
        }
    }
}