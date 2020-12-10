package com.example.cookingbythebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.example.cookingbythebook.compositepackage.Category
import java.util.*

class MainActivity : AppCompatActivity() {
    var titlePage: Category = Category("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle: Bundle? = intent.extras

        var categoryInput: String? = bundle?.getString("categoryName").toString()
        var addCategoryToInput: String? = bundle?.getString("addCategoryTo").toString()

        var mainLinearLayout: LinearLayout? = findViewById(R.id.mainLinearLayout)
        var categoryLinearLayout: LinearLayout? = findCategoryLayout(mainLinearLayout, addCategoryToInput)

        var categoryBtn = Button(applicationContext)
        categoryBtn.text = categoryInput
        categoryLinearLayout?.addView(categoryBtn)

    }

    fun findCategoryLayout(linearLayout: LinearLayout?, _addCategoryInput: String?): LinearLayout? {
            var layout: LinearLayout? = findViewById(R.id.mainLinearLayout)

            for(i in 0 until linearLayout?.childCount!!) {
                var view: View = linearLayout.getChildAt(i)
                if (view is TextView) {
                    var addCategoryInput = _addCategoryInput?.toLowerCase()
                    var categoryName = view.text.toString().toLowerCase()

                    if (categoryName == addCategoryInput) {
                        if (linearLayout.getChildAt(i+1) is ScrollView) {
                            val categoryScrollView: ScrollView = linearLayout.getChildAt(i + 1) as ScrollView
                            layout = categoryScrollView.getChildAt(0) as LinearLayout
                            return layout
                        }
                    }
                }
            }

            return layout
    }

    //val button = findViewById<Button>(R.id.addRecipeButton)
    fun goToAddRecipePage(view: View){
        val intent = Intent(this, AddRecipeActivity::class.java)
        startActivity(intent)

    }

    fun goToAddCategoryPage(view: View){
        val intent = Intent(this, AddCategoryActivity::class.java)
        startActivity(intent)

    }
}