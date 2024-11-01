package com.jacoo.medidordesalario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)


        //devolvitis
        val ImageView = findViewById<ImageView>(R.id.devolvitis1)
        ImageView.setOnClickListener {
            val intent = Intent(this, Centralpage::class.java)
            startActivity(intent)
        }
    }
}