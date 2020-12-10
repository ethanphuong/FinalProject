package com.example.cookingbythebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CategoryPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_page)

        val bundle: Bundle? = intent.extras

        var categoryInput: String? = bundle?.getString("categoryName")

        val categoryPageTitle: TextView = findViewById(R.id.categoryPageTitle)
        categoryPageTitle.setText(categoryInput)


    }

    fun goToAddRecipePage(view: View) {
        val intent = Intent(this, AddRecipeActivity::class.java)
        startActivity(intent)
    }

    fun goToAddCategoryPage(view: View) {
        val intent = Intent(this, AddCategoryActivity::class.java)
        startActivity(intent)
    }

}