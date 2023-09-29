package com.example.challenge_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.challenge_2.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            val costOfService = binding.costOfService.text.toString().toDoubleOrNull() ?: 0.0
            val roundUp = binding.roundUpSwitch.isChecked
            val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
                binding.optionTwentyPercent.id -> 0.20
                binding.optionEighteenPercent.id -> 0.18
                binding.optionFifteenPercent.id -> 0.15
                else -> 0.0
            }
            var tipAmount = costOfService * tipPercentage
            if (roundUp) {
                tipAmount = ceil(tipAmount)
            }

            binding.tipResult.text = tipAmount.toString()
        }
    }
}