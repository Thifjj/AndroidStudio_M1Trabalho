package com.example.calculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.Soma.setOnClickListener {
            val num1 = binding.Val1.text.toString().toDouble();
            val num2 = binding.Val2.text.toString().toDouble();

            val soma = num1+num2

            binding.CalculoRealizado.text = "Calculo realizado: "+num1.toString() + "+" + num2.toString()
            binding.Resultado.text = "Resultado: "+soma.toString()
        }

        binding.Sub.setOnClickListener {
            val num1 = binding.Val1.text.toString().toDouble();
            val num2 = binding.Val2.text.toString().toDouble();

            val sub = num1-num2

            binding.CalculoRealizado.text = "Calculo realizado: "+num1.toString() + "-" + num2.toString()
            binding.Resultado.text = "Resultado: "+sub.toString()
        }

        binding.Mult.setOnClickListener {
            val num1 = binding.Val1.text.toString().toDouble();
            val num2 = binding.Val2.text.toString().toDouble();

            val mult = num1*num2

            binding.CalculoRealizado.text = "Calculo realizado: "+num1.toString() + "*" + num2.toString()
            binding.Resultado.text = "Resultado: "+mult.toString()
        }
        binding.Divisao.setOnClickListener {
            val num1 = binding.Val1.text.toString().toDouble();
            val num2 = binding.Val2.text.toString().toDouble();

            val div = num1/num2

            binding.CalculoRealizado.text = "Calculo realizado: "+num1.toString() + "/" + num2.toString()
            binding.Resultado.text = "Resultado: "+div.toString()
        }
        binding.Exponencial.setOnClickListener {
            val num1 = binding.Val1.text.toString().toDouble();
            val num2 = binding.Val2.text.toString().toDouble();

            val Exp = num1.pow (num2)

            binding.CalculoRealizado.text = "Calculo realizado: "+num1.toString() + "Exp" + num2.toString()
            binding.Resultado.text = "Resultado: "+Exp.toString()
        }

    }
}