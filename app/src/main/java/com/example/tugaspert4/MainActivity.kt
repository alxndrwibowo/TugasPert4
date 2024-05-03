package com.example.tugaspert4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnExplicit: Button
    lateinit var btnImplicit: Button
    lateinit var btnData: Button
    lateinit var btnObject: Button

    lateinit var editNumber: EditText
    var number = ""
    lateinit var editNama: EditText
    var nama = ""
    lateinit var editUmur: EditText
    var umur = ""
    lateinit var editEmail: EditText
    var email = ""
    lateinit var editKota: EditText
    var kota = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnExplicit = findViewById(R.id.btnExplicit)
        btnImplicit = findViewById(R.id.btnImplicit)
        btnData = findViewById(R.id.btnData)
        btnObject = findViewById(R.id.btnObject)

        editNumber = findViewById(R.id.editNumber)
        editNama = findViewById(R.id.editNama)
        editUmur = findViewById(R.id.editUmur)
        editEmail = findViewById(R.id.editEmail)
        editKota = findViewById(R.id.editKota)

        btnExplicit.setOnClickListener(this)
        btnImplicit.setOnClickListener(this)
        btnData.setOnClickListener(this)
        btnObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnExplicit -> {
                val intentExplicit = Intent(this@MainActivity, Activity2::class.java)
                startActivity(intentExplicit)
            }
            R.id.btnImplicit -> {
                number = editNumber.text.toString()

                val intentImplicit = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number))
                startActivity(intentImplicit)
            }
            R.id.btnData -> {
                nama = editNama.text.toString()
                umur = editUmur.text.toString()
                val umurInt = umur.toInt()

                val intentData = Intent(this@MainActivity, ActivityData::class.java)
                intentData.putExtra(ActivityData.extraName, nama)
                intentData.putExtra(ActivityData.extraAge, umurInt)
                startActivity(intentData)
            }
            R.id.btnObject -> {
                nama = editNama.text.toString()
                umur = editUmur.text.toString()
                val umurInt = umur.toInt()
                email = editEmail.text.toString()
                kota = editKota.text.toString()

                val person = Person(nama, umurInt, email, kota)
                val intentObject = Intent(this@MainActivity, ActivityObject::class.java)
                intentObject.putExtra(ActivityObject.extraPerson, person)
                startActivity(intentObject)
            }
        }
    }
}