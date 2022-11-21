package com.example.tarea1_vba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tarea1_vba.databinding.ActivityMain2Binding
import java.util.*

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
            ageCalculator(date.toString())
            tvNaccount.text = account
            tvEmail.text = email
            zodiacCh(date.toString())
            zodiac(date.toString())
        }
    }

    fun zodiacCh(date: String){
        val tmp = splitDate(date)
        val year = tmp[2]

        when(year.toInt()){
            // RATA
            2020, 2008, 1996, 1984, 1972, 1960 -> {
                binding.zodiacChino.setImageResource(R.drawable.zrata)
            }
            // BUEY
            2021, 2009, 1997, 1985, 1973, 1961 -> {
                binding.zodiacChino.setImageResource(R.drawable.zbuey)
            }
            // TIGRE
            2022, 2010, 1998, 1986, 1974, 1962 -> {
                binding.zodiacChino.setImageResource(R.drawable.ztigre)
            }
            // CONEJO
            2023, 2011, 1999, 1987, 1975, 1963 -> {
                binding.zodiacChino.setImageResource(R.drawable.zconejo)
            }
            // DRAGON
            2024, 2012, 2000, 1988, 1976, 1964 -> {
                binding.zodiacChino.setImageResource(R.drawable.zdragon)
            }
            // SERPIENTE
            2025, 2013, 2001, 1989, 1977, 1965 -> {
                binding.zodiacChino.setImageResource(R.drawable.zserpiente)
            }
            // CABALLO
            2026, 2014, 2002, 1990, 1978, 1966 -> {
                binding.zodiacChino.setImageResource(R.drawable.zcaballo)
            }
            // CABRA
            2027, 2015, 2003, 1991, 1979, 1967 -> {
                binding.zodiacChino.setImageResource(R.drawable.zcabra)
            }
            // MONO
            2028, 2016, 2004, 1992, 1980, 1968 -> {
                binding.zodiacChino.setImageResource(R.drawable.zmono)
            }
            // GALLO
            2029, 2017, 2005, 1993, 1981, 1969 -> {
                binding.zodiacChino.setImageResource(R.drawable.zgallo)
            }
            // PERRO
            2030, 2018, 2006, 1994, 1982, 1970 -> {
                binding.zodiacChino.setImageResource(R.drawable.zperro)
            }
            // CERDO
            2031, 2019, 2007, 1995, 1983, 1971 -> {
                binding.zodiacChino.setImageResource(R.drawable.zcerdo)
            }
        }
    }

    fun splitDate(date: String): Array<String> {
        val tmp = date.split("-").toTypedArray()
        return arrayOf(tmp[0],tmp[1], tmp[2])
            //          DAY     MONTH   YEAR
    }

    fun ageCalculator(date: String){
        val tmp = splitDate(date)
        val month = tmp[1]
        val year = tmp[2]
        //Obtener el mes y año de la fecha actual
        val c = Calendar.getInstance()
        val monthCurrent = c.get(Calendar.MONTH)
        val yearCurrent = c.get(Calendar.YEAR)

        if (month.toInt() <= monthCurrent+1){
            binding.tvAge.text = (yearCurrent - year.toInt()).toString()
        } else {
            binding.tvAge.text = ((yearCurrent - year.toInt())-1).toString()
        }
    }

    fun zodiac(date: String){
        val tmp = splitDate(date)
        val day = tmp[0].toInt()
        val month = tmp[1].toInt()

        when(month){
            // Enero
            1 -> {
                if (day < 20){
                    // Capricornio
                    binding.Zodiac.setImageResource(R.drawable.zcapricornio)
                } else {
                    // Acuario
                    binding.Zodiac.setImageResource(R.drawable.zacuario)
                }
            }
            // Febrero
            2 -> {
                if (day < 19){
                    // Acuario
                    binding.Zodiac.setImageResource(R.drawable.zacuario)
                } else {
                    // Piscis
                    binding.Zodiac.setImageResource(R.drawable.zpiscis)
                }
            }
            // Marzo
            3 -> {
                if (day < 21){
                    // Piscis
                    binding.Zodiac.setImageResource(R.drawable.zpiscis)
                } else {
                    // Aries
                    binding.Zodiac.setImageResource(R.drawable.zaries)
                }
            }
            // Abril
            4 -> {
                if (day < 20){
                    // Aries
                    binding.Zodiac.setImageResource(R.drawable.zaries)
                } else {
                    //  Tauro
                    binding.Zodiac.setImageResource(R.drawable.ztauro)
                }
            }
            // Mayo
            5 -> {
                if (day < 21){
                    //  Tauro
                    binding.Zodiac.setImageResource(R.drawable.ztauro)
                } else {
                    // Geminis
                    binding.Zodiac.setImageResource(R.drawable.zgeminis)
                }
            }
            // Junio
            6 -> {
                if (day < 21){
                    // Geminis
                    binding.Zodiac.setImageResource(R.drawable.zgeminis)
                } else {
                    // Cancer
                    binding.Zodiac.setImageResource(R.drawable.zcancer)
                }
            }
            // Julio
            7 -> {
                if (day < 23){
                    // Cancer
                    binding.Zodiac.setImageResource(R.drawable.zcancer)
                } else {
                    // Leo
                    binding.Zodiac.setImageResource(R.drawable.zleo)
                }
            }
            // Agosto
            8 -> {
                if (day < 23){
                    // Leo
                    binding.Zodiac.setImageResource(R.drawable.zleo)
                } else {
                    // Virgo
                    binding.Zodiac.setImageResource(R.drawable.zvirgo)
                }
            }
            // Septiembre
            9 -> {
                if (day < 23){
                    // Virgo
                    binding.Zodiac.setImageResource(R.drawable.zvirgo)
                } else {
                    // Libra
                    binding.Zodiac.setImageResource(R.drawable.zlibra)
                }
            }
            // Octubre
            10 -> {
                if (day < 23){
                    // Libra
                    binding.Zodiac.setImageResource(R.drawable.zlibra)
                } else {
                    // Scorpio
                    binding.Zodiac.setImageResource(R.drawable.zscorpio)
                }
            }
            // Noviembre
            11 -> {
                if (day < 22){
                    // Scorpio
                    binding.Zodiac.setImageResource(R.drawable.zscorpio)
                } else {
                    // Sagitario
                    binding.Zodiac.setImageResource(R.drawable.zsagitario)
                }
            }
            // Diciembre
            12 -> {
                if (day < 22){
                    // Sagitario
                    binding.Zodiac.setImageResource(R.drawable.zsagitario)
                } else {
                    // Capricornio
                    binding.Zodiac.setImageResource(R.drawable.zcapricornio)
                }
            }
        }
    }
}