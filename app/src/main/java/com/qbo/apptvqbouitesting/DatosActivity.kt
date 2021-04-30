package com.qbo.apptvqbouitesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qbo.apptvqbouitesting.databinding.ActivityDatosBinding

class DatosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvnombre.text = intent.getStringExtra("nombre").toString()
    }
}