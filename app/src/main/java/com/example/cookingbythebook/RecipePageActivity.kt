package com.example.cookingbythebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.cookingbythebook.compositepackage.Recipe

class RecipePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val prevBundle: Bundle? = intent.extras
        if(prevBundle != null){
            val recipe = prevBundle.getParcelable<Recipe>("recipe") as Recipe

            val recipeTV = findViewById<TextView>(R.id.recipePageTitle)
            recipeTV.text = recipe.returnTitle()

            val tagsLL = findViewById<LinearLayout>(R.id.tagsLinearLayout)

            for(i in 1..recipe.returnTagsCount()) {
                val tempTV = TextView(applicationContext)
                tempTV.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                tempTV.text = recipe.returnTag(i - 1)
                tempTV.setTextColor(resources.getColor(R.color.black_pink))
                tempTV.setBackgroundColor(resources.getColor(R.color.light_pink))
                tempTV.typeface = ResourcesCompat.getFont(this, R.font.baloo)
                tempTV.textSize = 14F
                tempTV.setPadding(30,5,30,5)
                tagsLL.addView(tempTV)
            }

            val ingLL = findViewById<LinearLayout>(R.id.ingredientsLinearLayout)
            for(i in 1..recipe.returnIngredientsCount()) {
                val tempTV = TextView(applicationContext)
                tempTV.text = recipe.returnIngredient(i - 1)
                ingLL.addView(tempTV)
            }

            val instLL = findViewById<LinearLayout>(R.id.instructionsLinearLayout)
            for(i in 1..recipe.returnInstructionsCount()) {
                val tempTV = TextView(applicationContext)
                tempTV.text = recipe.returnInstruction(i - 1)
                instLL.addView(tempTV)
            }
        }
    }
}