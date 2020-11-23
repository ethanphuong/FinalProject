package com.example.cookingbythebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //val button = findViewById<Button>(R.id.addRecipeButton)
    fun goToAddRecipePage(view: View){
        val intent = Intent(this, AddRecipeActivity::class.java)
        startActivity(intent)
        /*Intent(this, AddRecipeActivity::class.java).apply {
            startActivity(this)
        }*/

    }
}