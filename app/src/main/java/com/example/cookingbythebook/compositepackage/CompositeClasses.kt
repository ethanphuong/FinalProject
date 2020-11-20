package com.example.cookingbythebook.compositepackage

interface Page {
    abstract var title: String
}

class Recipe : Page {
    override var title: String = ""
    var tags = ArrayList<String>()
    var ingredients = ArrayList<String>()
    var instructions = ArrayList<String>()

    fun Recipe(__title:String){ title = __title }
    fun addTag(tag:String){ tags.add(tag) }
    fun removeTag(tag:String){ tags.remove(tag) }
    fun addIngredients(ingredient:String){ ingredients.add(ingredient) }
    fun removeIngredients(ingredient:String){ ingredients.remove(ingredient) }
    fun addInstruction(instruction:String){ instructions.add(instruction) }
    fun removeInstruction(instruction:String){ instructions.remove(instruction) }
}

class Category : Page {
    override var title: String = ""
    var pages = ArrayList<Page>()

    fun Category(__title:String){ title = __title }
    fun addRecipe(__recipe:Page){ pages.add(__recipe) }
    fun removeRecipe(__recipe:Page){ pages.remove(__recipe) }
}