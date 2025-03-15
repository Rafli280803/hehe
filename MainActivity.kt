package com.example.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonTambah: Button
    private lateinit var buttonKurang: Button
    private lateinit var buttonKali: Button
    private lateinit var buttonBagi: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi elemen UI
        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        buttonTambah = findViewById(R.id.buttonTambah)
        buttonKurang = findViewById(R.id.buttonKurang)
        buttonKali = findViewById(R.id.buttonKali)
        buttonBagi = findViewById(R.id.buttonBagi)
        textViewResult = findViewById(R.id.textViewResult)

        // Event listener untuk masing-masing tombol
        buttonTambah.setOnClickListener { hitung('+') }
        buttonKurang.setOnClickListener { hitung('-') }
        buttonKali.setOnClickListener { hitung('*') }
        buttonBagi.setOnClickListener { hitung('/') }
    }

    private fun hitung(operator: Char) {
        val input1 = editTextNumber1.text.toString()
        val input2 = editTextNumber2.text.toString()

        if (input1.isEmpty() || input2.isEmpty()) {
            textViewResult.text = "Masukkan angka terlebih dahulu!"
            return
        }

        val angka1 = input1.toDoubleOrNull()
        val angka2 = input2.toDoubleOrNull()

        if (angka1 == null || angka2 == null) {
            textViewResult.text = "Masukkan angka yang valid!"
            return
        }

        val hasil = when (operator) {
            '+' -> angka1 + angka2
            '-' -> angka1 - angka2
            '*' -> angka1 * angka2
            '/' -> if (angka2 != 0.0) angka1 / angka2 else {
                textViewResult.text = "Tidak bisa membagi dengan nol!"
                return
            }
            else -> 0.0
        }

        // Jika hasilnya bilangan bulat, tampilkan tanpa desimal
        val hasilText = if (hasil % 1 == 0.0) hasil.toInt().toString() else hasil.toString()

        textViewResult.text = "Hasil: $hasilText"
    }
}
