package com.example.tarea1_vba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import com.example.tarea1_vba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick(view: View) {
        //if (binding.btnEnter.isPressed){
            if (tvIsNotEmpty()){
                // se pasa a la otra activity
                binding.tvTitle.text = "jajajaja"
            } else {
                Toast.makeText(this@MainActivity, getString(R.string.items_error),Toast.LENGTH_LONG).show()
            }
        //}

        if (binding.btnLanguage.isPressed){
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS));
        }
    }

    fun tvIsNotEmpty():Boolean{
        val check = mutableListOf<Boolean>() // Para comprobar que haya texto
        with(binding){
            val idsTexts = listOf(tvName.text,tvDate.text,tvNaccount.text,tvEmail.text)

            for (id_text in idsTexts){
                if (id_text.isEmpty()) {
                    idError(idsTexts.indexOf(id_text))
                } else {
                    check.add(true)
                }
            }
            return check.size == 4
        }
    }

    fun idError(id: Int){
        when (id){
            0 -> {
                binding.tvName.error = getString(R.string.nombre_error)
            }
            1 -> {
                binding.tvDate.error = getString(R.string.fecha_error)
            }
            2 -> {
                binding.tvNaccount.error = getString(R.string.cuenta_error)
            }
            3 -> {
                binding.tvEmail.error = getString(R.string.correo_error)
            }
        }
    }
}