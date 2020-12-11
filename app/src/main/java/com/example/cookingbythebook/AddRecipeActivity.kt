package com.example.cookingbythebook

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.recyclerviewpackage.MyAdapter


class AddRecipeActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {

    private var recipe: Recipe = Recipe("")
    private var switch: String = "tag"
    private var highlighted: Int = -1
    private var al = ArrayList<String>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        for(i in 1..recipe.returnTagsCount()){
            al[i - 1] = recipe.returnTag(i - 1)
        }

        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(al,this)

        recyclerView = findViewById<RecyclerView>(R.id.listRecyclerView).apply{
            layoutManager = manager
            adapter = myAdapter
        }
    }

    fun addInput(view: View){
        val textView = findViewById<TextView>(R.id.inputTextView)
        val inputText: String = textView.text.toString()
        textView.text = ""
        if(inputText != "") {
            when (switch) {
                "tag" -> recipe.addTag(inputText)
                "ingredient" -> recipe.addIngredient(inputText)
                "instruction" -> recipe.addInstruction(inputText)
            }

            updateList()
        }
        else{
            Toast.makeText(this, "Please enter something into the text field.", Toast.LENGTH_SHORT).show()
        }
    }

    fun removeItem(view: View){
        if(highlighted == -1){
            Toast.makeText(this, "Please select an item from the list first.", Toast.LENGTH_SHORT).show()
        }
        else{
            when(switch){
                "tag" -> recipe.removeTag(recipe.returnTag(highlighted))
                "ingredient" -> recipe.removeIngredient(recipe.returnIngredient(highlighted))
                "instruction" -> recipe.removeInstruction(recipe.returnInstruction(highlighted))
            }
            highlighted = -1
            updateList()
        }
    }

    fun editItem(view: View){
        val textView = findViewById<TextView>(R.id.inputTextView)
        val text: String = textView.text.toString()
        if(highlighted == -1){
            Toast.makeText(this, "Please select an item to edit from the list first.", Toast.LENGTH_SHORT).show()
        }
        else if(text == ""){
            Toast.makeText(this, "Please input the new text in the text field to the left.", Toast.LENGTH_SHORT).show()
        }
        else{
            when(switch){
                "tag" -> recipe.editTag(highlighted, text)
                "ingredient" -> recipe.editIngredient(highlighted, text)
                "instruction" -> recipe.editInstruction(highlighted, text)
            }
            textView.text = ""

            updateList()
        }
    }

    fun switchListToTags(view: View){
        switch = "tag"
        updateList()
    }

    fun switchListToIngredients(view: View){
        switch = "ingredient"
        updateList()
    }

    fun switchListToInstructions(view: View){
        switch = "instruction"
        updateList()
    }

    private fun updateList(){
        al.clear()
        when(switch){
            "tag" -> {
                for (i in 1..recipe.returnTagsCount()) {
                    al.add(recipe.returnTag(i - 1))
                }
            }
            "ingredient" -> {
                for (i in 1..recipe.returnIngredientsCount()) {
                    al.add(recipe.returnIngredient(i - 1))
                }
            }
            "instruction" -> {
                for (i in 1..recipe.returnInstructionsCount()) {
                    al.add(recipe.returnInstruction(i - 1))
                }
            }
        }

        myAdapter = MyAdapter(al, this)

        recyclerView.apply{
            layoutManager = manager
            adapter = myAdapter
        }
    }

    override fun onItemClick(position: Int) { //used to know when recyclerview items have been clicked
        //Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show() <- use this for testing
        highlighted = when(highlighted) {
            position -> -1
            else -> position
        }
        //findViewById<TextView>(R.id.editCategoryName).text = highlighted.toString() <- use this for testing purposes
        myAdapter.notifyItemChanged(position)
    }

    fun sendCompleteRecipe(view: View){
        val categoryTV = findViewById<TextView>(R.id.editCategoryName)
        val recipeTV = findViewById<TextView>(R.id.editRecipeName)
        when {
            categoryTV.text == "" -> {
                Toast.makeText(this, "Please enter a category to put the recipe in.", Toast.LENGTH_SHORT).show()
            }
            recipeTV.text == "" -> {
                Toast.makeText(this, "Please enter a name for the recipe.", Toast.LENGTH_SHORT).show()
            }
            else -> {
                recipe.changeTitle(recipeTV.text.toString())

                val bundle: Bundle? = intent.extras
                val activityCameFrom = bundle?.getString("activityCameFrom").toString()

                when(activityCameFrom) {
                    "Main Activity" -> {
                        val intent = Intent(this, MainActivity::class.java)
                    }
                    "Category Page Activity" -> {
                        //val intent = Intent(this, )
                    }
                }
            }
        }
    }
}