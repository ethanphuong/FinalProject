package com.example.cookingbythebook.compositepackage

interface Page {
    abstract var title: String
    abstract var isRecipe: Boolean
}

class Recipe : Page {
    override var title: String = ""
    override var isRecipe: Boolean = true
    var tags = ArrayList<String>()
    var ingredients = ArrayList<String>()
    var instructions = ArrayList<String>()

    fun Recipe(__title:String){ title = __title }
    fun addTag(tag:String){ tags.add(tag) }
    fun removeTag(tag:String){ tags.remove(tag) }
    fun returnTags(): ArrayList<String>{ return tags }
    fun addIngredients(ingredient:String){ ingredients.add(ingredient) }
    fun removeIngredients(ingredient:String){ ingredients.remove(ingredient) }
    fun returnIngredients(): ArrayList<String>{ return ingredients }
    fun addInstruction(instruction:String){ instructions.add(instruction) }
    fun removeInstruction(instruction:String){ instructions.remove(instruction) }
    fun returnInstructions(): ArrayList<String>{ return instructions }
}

class Category : Page {
    override var title: String = ""
    override var isRecipe: Boolean = false
    var pages = ArrayList<Page>()

    fun Category(__title:String){ title = __title }
    fun addRecipe(__recipe:Page){ pages.add(__recipe) }
    fun removeRecipe(__recipe:Page){ pages.remove(__recipe) }
}