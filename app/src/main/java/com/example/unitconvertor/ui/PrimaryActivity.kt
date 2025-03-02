package com.example.unitconvertor.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.unitconvertor.R

class PrimaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        println("OnCreate")
        setContentView(R.layout.activity_primary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button:Button = findViewById(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this,SecondaryActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onStart() {
        super.onStart()
        println("OnStart")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy")
    }
}