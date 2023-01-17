package com.example.cookingutilityapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var ingredientButton: Button // lateinit suggest a variable that will be initialized
                                          // in the future
    lateinit var equipmentButton: Button
    lateinit var timerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ingredientButton = findViewById(R.id.ingredientButton)
        equipmentButton = findViewById(R.id.equipmentButton)
        timerButton = findViewById(R.id.timerButton)
        val about = findViewById<Button>(R.id.helpButton)

        // modal for app tutorial
        about.setOnClickListener{ val modalBinding = layoutInflater.inflate(R.layout.activity_modal, null)
            val aboutModal = Dialog(this)
            aboutModal.setContentView(modalBinding)

            aboutModal.setCancelable(true)
            aboutModal.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            aboutModal.show()

            val start = aboutModal.findViewById<Button>(R.id.startApp)
            start.setOnClickListener {
                aboutModal.dismiss()
            }
        }
        ingredientButton.setOnClickListener {
            val goToIngredients = Intent(this, Ingredients::class.java)
            startActivity(goToIngredients)
        }

        equipmentButton.setOnClickListener {
            val goToEquipment = Intent(this, Equipment::class.java)
            startActivity(goToEquipment)
        }

        timerButton.setOnClickListener {
            val goToTimer = Intent(this, Timer::class.java)
            startActivity(goToTimer)
        }
    }
}