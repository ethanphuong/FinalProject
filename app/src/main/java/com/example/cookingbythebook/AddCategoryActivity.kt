package com.example.cookingbythebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddCategoryActivity : AppCompatActivity() {
    var categoryName: String = ""
    var addCategoryTo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        println("Hello World!")
    }

    fun submitCategoryOnClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)

        val categoryNameInput: EditText = findViewById(R.id.editCategoryName)
        val addCategoryToInput: EditText = findViewById(R.id.editAddCategoryTo)

        categoryName = categoryNameInput.text.toString()
        addCategoryTo = addCategoryToInput.text.toString()

        var bundle: Bundle = Bundle()
        bundle.putString("categoryName", categoryName)
        bundle.putString("addCategoryTo", addCategoryTo)
        intent.putExtras(bundle)

        startActivity(intent)
    }

}