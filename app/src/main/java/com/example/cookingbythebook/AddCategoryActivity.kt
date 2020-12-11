package com.example.cookingbythebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddCategoryActivity : AppCompatActivity() {
    private var categoryInput: String? = ""
    private var addCategoryTo: String? = ""
    private var categoryName: String? = ""
    private var activityCameFrom: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        val bundle: Bundle? = intent.extras
        activityCameFrom = bundle?.getString("activityCameFrom").toString()
        categoryName = bundle?.getString("categoryName").toString()

        if (activityCameFrom == "Category Page Activity") {
            val editAddCategoryTo: EditText = findViewById(R.id.editAddCategoryTo)
            editAddCategoryTo.visibility = View.GONE
        }
    }

    fun submitCategoryOnClick(view: View) {
        val categoryNameInput: EditText = findViewById(R.id.editCategoryName)
        val addCategoryToInput: EditText = findViewById(R.id.editAddCategoryTo)

        categoryInput = categoryNameInput.text.toString()
        addCategoryTo = addCategoryToInput.text.toString()

        var bundle: Bundle = Bundle()

        if (activityCameFrom == "Main Activity") {
            if (categoryInput == "" || addCategoryTo == "") {
                Toast.makeText(this, "Please Enter a Category Name and Category to Add to", Toast.LENGTH_LONG).show()
            }
            else {
                val intent = Intent(this, MainActivity::class.java)

                bundle.putString("categoryInput", categoryInput)
                bundle.putString("addCategoryTo", addCategoryTo)
                intent.putExtras(bundle)

                startActivity(intent)
            }
        } else if (activityCameFrom == "Category Page Activity") {
            if (categoryInput == "") {
                Toast.makeText(this, "Please Enter a Category Name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, CategoryPageActivity::class.java)
                val activityCameFrom: String? = "Add Category Activity"

                bundle.putString("activityCameFrom", activityCameFrom)
                bundle.putString("categoryName", categoryName)
                bundle.putString("categoryInput", categoryInput)
                bundle.putString("addCategoryTo", addCategoryTo)
                intent.putExtras(bundle)

                startActivity(intent)
            }
        }
    }

}