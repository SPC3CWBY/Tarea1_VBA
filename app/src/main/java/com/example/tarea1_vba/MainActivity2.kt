package com.example.tarea1_vba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tarea1_vba.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // se reciben los parametros
        val bundle = intent.extras
        // se guardan
        val name = bundle?.getString("name","")
        val date = bundle?.getString("date","")
        val account = bundle?.getString("account","")
        val email = bundle?.getString("email","")


        with(binding){
            tvName.text = name
            tvAge.text = date
            tvNaccount.text = account
            tvEmail.text = email
        }




    }


}