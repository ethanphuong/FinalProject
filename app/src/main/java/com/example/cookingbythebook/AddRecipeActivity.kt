package com.example.cookingbythebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.cookingbythebook.compositepackage.Recipe

class AddRecipeActivity : AppCompatActivity() {

    var recipe: Recipe = Recipe("")
    var switch: String = "tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)
    }

    fun addInput(view: View){
        val inputText: String = findViewById<TextView>(R.id.inputTextView).text.toString()
        if(switch == "tag"){
            recipe.addTag(inputText)
        }
        else if(switch == "ingredient"){
            recipe.addIngredients(inputText)
        }
        else if(switch == "instruction"){
            recipe.addInstruction(inputText)
        }

        updateList()
    }

    fun updateList(){
        val list = findViewById<LinearLayout>(R.id.listLinearLayout)
        if(switch == "tag"){
            for(i in 1..recipe.returnTagsCount()){
                var text: TextView = TextView(applicationContext)
                text.text = recipe.returnTags(i - 1).toString()
                list.addView(text)
            }
        }
        else if(switch == "ingredient"){
            for(i in 1..recipe.returnIngredientsCount()){
                var text: TextView = TextView(applicationContext)
                text.text = recipe.returnIngredients(i - 1).toString()
                list.addView(text)
            }
        }
        else if(switch == "instruction"){
            for(i in 1..recipe.returnInstructionsCount()){
                var text: TextView = TextView(applicationContext)
                text.text = recipe.returnInstructions(i - 1).toString()
                list.addView(text)
            }
        }
    }
}