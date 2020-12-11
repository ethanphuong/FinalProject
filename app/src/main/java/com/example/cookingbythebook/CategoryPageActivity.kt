package com.example.cookingbythebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Recipe

class CategoryPageActivity : AppCompatActivity() {

    var categoryName: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_page)

        val bundle: Bundle? = intent.extras

        val activityCameFrom: String? = bundle?.getString("activityCameFrom")
        categoryName = bundle?.getString("categoryName")

        if (activityCameFrom == "Main Activity") {
            val categoryPageTitle: TextView = findViewById(R.id.categoryPageTitle)
            categoryPageTitle.setText(categoryName)

            val catPageLL = findViewById<LinearLayout>(R.id.categoryPageLinearLayout)

            when {
                bundle.containsKey("recipe") -> {
                    val recipeInput = bundle.getParcelable<Recipe>("recipe") as Recipe

                    var recipeBtn = Button(applicationContext)
                    //Toast.makeText(this, recipeInput.returnTitle(), Toast.LENGTH_SHORT).show()
                    recipeBtn.text = recipeInput.returnTitle()
                    recipeBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                    recipeBtn.typeface = ResourcesCompat.getFont(this, R.font.baloo)
                    recipeBtn.textSize = 16F
                    recipeBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                    catPageLL?.addView(recipeBtn)

                    recipeBtn.setOnClickListener {
                        val intent = Intent(this, RecipePageActivity::class.java)

                        var bundle: Bundle = Bundle()
                        val activityCameFrom: String = "Main Activity"

                        bundle.putString("activityCameFrom", activityCameFrom)
                        bundle.putParcelable("recipe", recipeInput)
                        intent.putExtras(bundle)
                        startActivity(intent)
                    }
                }
                bundle.containsKey("categoryInput") -> {
                    var categoryInput = bundle.getString("categoryInput")

                    categoryInput = categoryInput?.toLowerCase()
                    categoryInput = categoryInput?.capitalize()

                    var categoryBtn = Button(applicationContext)
                    categoryBtn.setText(categoryInput)
                    categoryBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                    categoryBtn.setTypeface(ResourcesCompat.getFont(this, R.font.baloo))
                    categoryBtn.setTextSize(16F)
                    categoryBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                    catPageLL?.addView(categoryBtn)

                    categoryBtn.setOnClickListener {
                        val intent = Intent(this, CategoryPageActivity::class.java)

                        var bundle: Bundle = Bundle()
                        val activityCameFrom: String = "Main Activity"

                        bundle.putString("activityCameFrom", activityCameFrom)
                        bundle.putString("categoryName", categoryInput)
                        intent.putExtras(bundle)
                        startActivity(intent)
                    }
                }
            }
        }
        else if (activityCameFrom == "Add Category Activity") {
            val categoryInput: String? = bundle?.getString("categoryInput")
            val addCategoryTo: String? = bundle?.getString("addCategoryTo")

            val categoryPageTitle: TextView = findViewById(R.id.categoryPageTitle)
            categoryPageTitle.setText(categoryName)

            var categoryBtn = Button(applicationContext)
            categoryBtn.setText(categoryInput)
            categoryBtn.setTextColor(resources.getColor(R.color.dark_blue))
            categoryBtn.setTypeface(ResourcesCompat.getFont(this, R.font.baloo))
            categoryBtn.setTextSize(16F)
            categoryBtn.setBackgroundColor(resources.getColor(R.color.light_blue))

            val categoryPageLinearLayout: LinearLayout = findViewById(R.id.categoryPageLinearLayout)
            categoryPageLinearLayout?.addView(categoryBtn)
        }
    }

    fun goToAddRecipePage(view: View) {
        val intent = Intent(this, AddRecipeActivity::class.java)

        var bundle: Bundle = Bundle()
        val activityCameFrom: String = "Category Page Activity"
        bundle.putString("activityCameFrom", activityCameFrom)
        bundle.putString("categoryName", categoryName)
        intent.putExtras(bundle)

        startActivity(intent)
    }

    fun goToAddCategoryPage(view: View) {
        val intent = Intent(this, AddCategoryActivity::class.java)

        var bundle: Bundle = Bundle()
        val activityCameFrom: String = "Category Page Activity"
        bundle.putString("activityCameFrom", activityCameFrom)
        bundle.putString("categoryName", categoryName)
        intent.putExtras(bundle)

        startActivity(intent)
    }

}