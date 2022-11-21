package com.example.tarea1_vba

import android.app.DatePickerDialog
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
        when(view.id){
            R.id.btn_enter -> {
                if (tvIsNotEmpty()){
                    // se pasa a la otra activity
                    val intent = Intent(this, MainActivity2::class.java)

                    val parameters = Bundle()

                    parameters.putString("name", binding.tvName.text.toString())
                    parameters.putString("date", binding.tvDate.text.toString())
                    parameters.putString("account", binding.tvNaccount.text.toString())
                    parameters.putString("email", binding.tvEmail.text.toString())

                    intent.putExtras(parameters)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.items_error),
                        Toast.LENGTH_LONG).show()
                }
            }

            R.id.tv_date -> {
                datePicker()
                // EL resultado se encuentra en
                //binding.tvDate.text
            }

            R.id.btn_language -> {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS));
            }
        }
    }

    private fun datePicker(){
        // Valores por defecto del DatePicker
        val year = 2000
        val month = 0
        val day = 1

        val datePickerDialog = DatePickerDialog(
            this,
            { view, year1, monthOfYear, dayOfMonth ->
                val dateChoice = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year1)
                binding.tvDate.setText(dateChoice)
                //temp = dateChoice
            }, year, month, day
        )
        datePickerDialog.show()
    }

    private fun tvIsNotEmpty():Boolean{
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

    private fun idError(id: Int){
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