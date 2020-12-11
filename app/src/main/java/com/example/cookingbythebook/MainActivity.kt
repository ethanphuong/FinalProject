package com.example.cookingbythebook

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.cookbookpackage.CookBook
import com.example.cookingbythebook.iteratorpackage.NullIterator
import com.example.cookingbythebook.iteratorpackage.PreorderIterator
import java.util.*

class MainActivity : AppCompatActivity() {
    var cookbook: CookBook = CookBook("")

    //@SuppressLint("ResourceType")
    //@RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //basic initialization
        if(cookbook.returnPageCount() == 1){
            cookbook.addPage("", Category("Breakfast"))
            cookbook.addPage("", Category("Lunch"))
            cookbook.addPage("", Category("Dinner"))
            cookbook.addPage("", Category("Dessert"))
            cookbook.addPage("", Category("Beverages"))
        }

        //when coming back from creating category/recipe
        val bundle: Bundle? = intent.extras
        if(bundle != null) {
            /*Toast.makeText(this, "in check", Toast.LENGTH_SHORT).show()
            if(bundle.containsKey("cookbook")) {
                val prevCookBook: CookBook? = bundle.getParcelable<CookBook>("cookbook")
                if(prevCookBook != null) { cookbook = prevCookBook }
                Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
            }*/

            var addCategoryToInput: String? = bundle.getString("addCategoryTo")

            var mainLinearLayout: LinearLayout? = findViewById(R.id.mainLinearLayout)
            var categoryLinearLayout: LinearLayout? =
                findCategoryLayout(mainLinearLayout, addCategoryToInput)

            when {
                bundle.containsKey("recipe") -> {
                    val recipeInput = bundle.getParcelable<Recipe>("recipe") as Recipe

                    cookbook.addPage(addCategoryToInput, recipeInput)

                    var recipeBtn = Button(applicationContext)
                    //Toast.makeText(this, recipeInput.returnTitle(), Toast.LENGTH_SHORT).show()
                    recipeBtn.text = recipeInput.returnTitle()
                    recipeBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                    recipeBtn.typeface = ResourcesCompat.getFont(this, R.font.baloo)
                    recipeBtn.textSize = 16F
                    recipeBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                    categoryLinearLayout?.addView(recipeBtn)

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

                    cookbook.addPage(addCategoryToInput, Category(categoryInput!!))

                    categoryInput = categoryInput?.toLowerCase()
                    categoryInput = categoryInput?.capitalize()

                    var categoryBtn = Button(applicationContext)
                    categoryBtn.setText(categoryInput)
                    categoryBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                    categoryBtn.setTypeface(ResourcesCompat.getFont(this, R.font.baloo))
                    categoryBtn.setTextSize(16F)
                    categoryBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                    categoryLinearLayout?.addView(categoryBtn)

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

        /*//creating buttons for each category/recipe
        var it = cookbook.titlePage?.createIterator()
        if(it != null) {
            it.first()
            while (!it.isDone()) {
                if (it.current() != null && it.current() is Category) {

                    var mainLinearLayout: LinearLayout? = findViewById(R.id.mainLinearLayout)
                    var categoryLinearLayout: LinearLayout? =
                        findCategoryLayout(mainLinearLayout, it.current()?.returnTitle())

                    var it2 = it.current()?.createIterator()
                    System.out.println(it.current()?.returnTitle())
                    System.out.println(it2 is NullIterator)
                    if (it2 != null && categoryLinearLayout != null) {
                        it2.first()
                        while (!it2.isDone()) {
                            if (it2.current() != null) {
                                when (it2.current()) {
                                    is Recipe -> {
                                        System.out.println(it.current()?.returnTitle())
                                        val rec = it2.current() as Recipe

                                        var recipeBtn = Button(applicationContext)
                                        recipeBtn.text = rec.returnTitle()
                                        recipeBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                                        recipeBtn.typeface =
                                            ResourcesCompat.getFont(this, R.font.baloo)
                                        recipeBtn.textSize = 16F
                                        recipeBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                                        categoryLinearLayout?.addView(recipeBtn)

                                        recipeBtn.setOnClickListener {
                                            val intent =
                                                Intent(this, RecipePageActivity::class.java)

                                            var bundle: Bundle = Bundle()
                                            val activityCameFrom: String = "Main Activity"

                                            bundle.putString("activityCameFrom", activityCameFrom)
                                            bundle.putParcelable("recipe", rec)
                                            bundle.putParcelable("cookbook", cookbook)
                                            intent.putExtras(bundle)
                                            startActivity(intent)
                                        }
                                    }
                                    is Category -> {
                                        val cat = it2.current() as Category

                                        var categoryBtn = Button(applicationContext)
                                        categoryBtn.setText(cat.returnTitle())
                                        categoryBtn.setTextColor(resources.getColor(R.color.dark_aqua_blue))
                                        categoryBtn.setTypeface(
                                            ResourcesCompat.getFont(
                                                this,
                                                R.font.baloo
                                            )
                                        )
                                        categoryBtn.setTextSize(16F)
                                        categoryBtn.setBackgroundColor(resources.getColor(R.color.aqua_blue))
                                        categoryLinearLayout?.addView(categoryBtn)

                                        categoryBtn.setOnClickListener {
                                            val intent =
                                                Intent(this, CategoryPageActivity::class.java)

                                            var bundle: Bundle = Bundle()
                                            val activityCameFrom: String = "Main Activity"

                                            bundle.putString("activityCameFrom", activityCameFrom)
                                            bundle.putString("categoryName", cat.returnTitle())
                                            bundle.putParcelable("cookbook", cookbook)
                                            intent.putExtras(bundle)
                                            startActivity(intent)
                                        }
                                    }
                                }
                            }

                            it2.getNext()
                        }
                    }
                }
                it.getNext()
            }
        }*/
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

            return null
    }

    //val button = findViewById<Button>(R.id.addRecipeButton)
    fun goToAddRecipePage(view: View){
        val intent = Intent(this, AddRecipeActivity::class.java)

        var bundle: Bundle = Bundle()
        val activityCameFrom: String = "Main Activity"
        bundle.putString("activityCameFrom", activityCameFrom)
        //bundle.putParcelable("cookbook", cookbook)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    fun goToAddCategoryPage(view: View){
        val intent = Intent(this, AddCategoryActivity::class.java)

        var bundle: Bundle = Bundle()
        val activityCameFrom: String = "Main Activity"
        val addCategoryTo: String = ""
        bundle.putString("activityCameFrom", activityCameFrom)
        bundle.putString("addCategoryTo", addCategoryTo)
        //bundle.putParcelable("cookbook", cookbook)
        intent.putExtras(bundle)

        startActivity(intent)

    }
}