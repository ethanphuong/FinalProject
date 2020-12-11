package com.example.cookingbythebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

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