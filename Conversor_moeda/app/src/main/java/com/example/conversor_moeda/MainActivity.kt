package com.example.conversor_moeda

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor_moeda.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 1. Usar um Map para as taxas é mais limpo e fácil de expandir
    private val taxas = mapOf(
        "Real" to 5.45,
        "Dólar" to 1.0,
        "Euro" to 0.92,
        "Libra" to 0.78,
        "Iene" to 157.65
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Funções separadas para organizar a UI
        setupSpinner()
        setupListeners()
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.moedas_array,
            R.layout.molde_texto_preto
        )
        adapter.setDropDownViewResource(R.layout.molde_texto_preto)

        binding.spinnerPara.adapter = adapter
    }

    private fun setupListeners() {
        binding.ButtonConverter.setOnClickListener {
            converterMoeda()
        }
    }

    private fun converterMoeda() {
        val valorString = binding.ValorToConvert.text.toString()


        val valorParaConverter = valorString.toDoubleOrNull()
        if (valorString.isEmpty() || valorParaConverter == null) {
            binding.ValorConvertido.text = "Digite um valor válido"
            return
        }
        val moedaDe = "Real"
        val moedaPara = binding.spinnerPara.selectedItem.toString()

        val taxaDe = taxas[moedaDe]
        val taxaPara = taxas[moedaPara]

        if (taxaDe == null || taxaPara == null || taxaDe == 0.0) {
            binding.ValorConvertido.text = "Erro ao obter taxas"
            return
        }
        val valorEmDolares = valorParaConverter / taxaDe
        val valorFinal = valorEmDolares * taxaPara

        binding.ValorConvertido.text = formatarResultado(valorFinal, moedaPara)
    }

    private fun formatarResultado(valor: Double, moeda: String): String {
        val locale = when (moeda) {
            "Real" -> Locale("pt", "BR")
            "Dólar" -> Locale.US
            "Euro", "Libra" -> Locale.UK
            "Iene" -> Locale.JAPAN
            else -> Locale.getDefault()
        }
        val formatador = NumberFormat.getCurrencyInstance(locale)
        return formatador.format(valor)
    }
}