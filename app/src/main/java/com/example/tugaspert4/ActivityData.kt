package com.example.tugaspert4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityData : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val extraAge = "extra_age"
        const val extraName = "extra_name"
    }

    lateinit var btnBack: Button
    lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack = findViewById(R.id.btnBack)
        tvData = findViewById(R.id.tvData)

        btnBack.setOnClickListener(this)

        val age = intent.getIntExtra(extraAge, 0)
        val name = intent.getStringExtra(extraName)
        val text = "Name : $name, Your Age : $age"
        tvData.text = text
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnBack -> {
                val intentData = Intent(this@ActivityData, MainActivity::class.java)
                startActivity(intentData)
            }
        }
    }
}