package com.example.cookingbythebook

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.strategypackage.CompileStrategy
import com.example.cookingbythebook.strategypackage.IngredientsCompileStrategy
import com.example.cookingbythebook.strategypackage.TagCompileStrategy
import com.example.cookingbythebook.strategypackage.TitleCompileStrategy

class SearchRecipeActivity : AppCompatActivity() {

    private var compiler: CompileStrategy? = null
    private var searchInput: String? = ""
    private var searchDropDown: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_recipe)

        val bundle: Bundle? = intent.extras
        val activityCameFrom = bundle?.getString("activityCameFrom")

        searchDropDown = findViewById(R.id.searchDropDown)
        var selections: ArrayAdapter<String> = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item,
            getResources().getStringArray(R.array.dropDownList)
        )

        selections.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        searchDropDown?.setAdapter(selections)

        //var searchBtn: Button = Button(applicationContext)
        //searchBtn = findViewById(R.id.searchBtn2)
    }
}

    /*    fun clickToCompileList() {
            val searchInput: EditText = findViewById(R.id.searchInput)

            searchDropDown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    var selectedItem = searchDropDown.selectedItem.toString()
                    if (selectedItem == "Title") {
                        compiler = TitleCompileStrategy()
                        cookBook.setListCompiler(compiler)
                        val titleList: ArrayList<Page> = cookBook.compile(searchInput)

                        for (i in 1..titleList.count()) {
                            val recipeName: String = titleList.get(i).returnTitle()
                            val listLinearLayout: LinearLayout = findViewById(R.id.listLinearLayout)

                            var recipeBtn: Button = Button(applicationContext)
                            recipeBtn.id = i
                            recipeBtn.setText(recipeName)
                            recipeBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                            //recipeBtn.setTypeface(ResourcesCompat.getFont(this, R.font.baloo))
                            recipeBtn.setTextSize(16F)
                            recipeBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                            listLinearLayout?.addView(recipeBtn)

                            recipeBtn.setOnClickListener {
                                val intent = Intent(this, RecipePageActivity::class.java)

                                var bundle: Bundle = Bundle()
                                val activityCameFrom: String = "Search Recipe Activity"

                                bundle.putString("activityCameFrom", activityCameFrom)
                                bundle.putString("recipeName", recipeName)
                                intent.putExtras(bundle)
                                startActivity(intent)
                            }
                        }
                    } else if (selectedItem == "Tags") {
                        compiler = TagCompileStrategy()
                        cookBook.setListCompiler(compiler)
                        val tagList: ArrayList<Page> = cookBook.compile(searchInput)

                        for (i in 1..tagList.count()) {
                            val recipeName: String = tagList.get(i).returnTitle()
                            val listLinearLayout: LinearLayout = findViewById(R.id.listLinearLayout)

                            var recipeBtn: Button = Button(applicationContext)
                            recipeBtn.setText(recipeName)
                            recipeBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                            recipeBtn.setTypeface(ResourcesCompat.getFont(this, R.font.baloo))
                            recipeBtn.setTextSize(16F)
                            recipeBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                            listLinearLayout?.addView(recipeBtn)

                            recipeBtn.setOnClickListener {
                                val intent = Intent(this, AddRecipeActivity::class.java)

                                var bundle: Bundle = Bundle()
                                val activityCameFrom: String = "Search Recipe Activity"

                                bundle.putString("activityCameFrom", activityCameFrom)
                                bundle.putString("recipeName", recipeName)
                                intent.putExtras(bundle)
                                startActivity(intent)
                            }
                        }

                    } else if (selectedItem == "Ingredients") {
                        compiler = IngredientsCompileStrategy()
                        cookBook.setListCompiler(compiler)
                        val ingredientsList: ArrayList<Page> = cookBook.compile(searchInput)

                        for (i in 1..ingredientsList.count()) {
                            val recipeName: String = ingredientsList.get(i).returnTitle()
                            val listLinearLayout: LinearLayout = findViewById(R.id.listLinearLayout)

                            var recipeBtn: Button = Button(applicationContext)
                            recipeBtn.setText(recipeName)
                            recipeBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                            recipeBtn.setTypeface(ResourcesCompat.getFont(this, R.font.baloo))
                            recipeBtn.setTextSize(16F)
                            recipeBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                            listLinearLayout?.addView(recipeBtn)

                            recipeBtn.setOnClickListener {
                                val intent = Intent(this, RecipePageActivity::class.java)

                                var bundle: Bundle = Bundle()
                                val activityCameFrom: String = "Search Recipe Activity"

                                bundle.putString("activityCameFrom", activityCameFrom)
                                bundle.putString("recipeName", recipeName)
                                intent.putExtras(bundle)
                                startActivity(intent)
                            }
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }

            }
        }
    }
}
*/