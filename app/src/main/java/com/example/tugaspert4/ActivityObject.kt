package com.example.tugaspert4

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityObject : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val extraPerson = "extra_person"
    }

    lateinit var btnBack: Button
    lateinit var tvObject: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_object)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack = findViewById(R.id.btnBack)
        tvObject = findViewById(R.id.tvObject)

        btnBack.setOnClickListener(this)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(extraPerson, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(extraPerson)
        }

        if (person != null) {
            val text = "Name : ${person.name.toString()}, " +
                    "\nEmail : ${person.email}," +
                    "\nAge : ${person.age}," +
                    "\nLocation : ${person.city}"
            tvObject.text = text
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnBack -> {
                val intentData = Intent(this@ActivityObject, MainActivity::class.java)
                startActivity(intentData)
            }
        }
    }
}