package com.example.cookingbythebook

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

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        //val clickedItem =
        myAdapter.notifyItemChanged(position)
    }
}