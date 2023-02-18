package com.mony.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.switchmaterial.SwitchMaterial
import com.mony.sampleapp.databinding.ActivityMainBinding
import com.mony.sampleapp.databinding.ActivityMainBinding.inflate
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    /* Object for creating bindings */
    private lateinit var binding : ActivityMainBinding

    /* Properties for holding views */
    private lateinit var inputTextBox : EditText
    private lateinit var totalAmount : TextView
    private lateinit var calculateButton : Button
    private lateinit var radioButtons : RadioGroup
    private lateinit var roundingSwitch : SwitchMaterial

    /* Runs on creation of this activity */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Saves the value of calculated tip*/
        var calculatedTip = 0.00

        /* Setting the base view in place using binding */
        binding = inflate(layoutInflater)
        val currentView = binding.root
        setContentView(currentView)

        /* Access views from xml layout files
        using view binding */
        inputTextBox = binding.costEditText
        totalAmount = binding.total
        calculateButton = binding.calculateTipButton
        radioButtons = binding.radioGroup
        roundingSwitch = binding.roundupSwitch

        totalAmount.text = getString(
            R.string.tip, calculatedTip.toString()
        )

        /* Short hand for setting a click handler */
        calculateButton.setOnClickListener {

            /* Rounds the value if roundingSwitch is checked */
            if (roundingSwitch.isChecked){
                calculatedTip = calculatedTip.roundToInt().toDouble()
            }

            totalAmount.text = getString(
                R.string.tip, calculatedTip.toString()
            )
        }

        /* Short hand for radio button change event handler */
        radioButtons.setOnCheckedChangeListener { _, i ->

            calculatedTip = 0.00

            /* If inputTextBox is not blank, calculate ans set the tip */
            if (inputTextBox.text.isNotBlank()) {

                if (i == R.id.one)
                    calculatedTip = (
                            inputTextBox.text.toString().toInt() * 0.20
                            )

                if (i == R.id.two)
                    calculatedTip = (
                            inputTextBox.text.toString().toInt() * 0.10
                            )

                if (i == R.id.three)
                    calculatedTip = (
                            inputTextBox.text.toString().toInt() * 0.05
                            )
            }
        }
    }
}