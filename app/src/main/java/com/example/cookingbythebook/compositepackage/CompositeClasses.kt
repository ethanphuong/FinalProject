package com.example.cookingbythebook.compositepackage

open class Page(protected open var title: String) {
    fun returnTitle(): String { return title }
    fun changeTitle(__title: String) { title = __title }
}

class Recipe(override var title: String) : Page(title) {
    var tags = ArrayList<String>()
    var ingredients = ArrayList<String>()
    var instructions = ArrayList<String>()

    fun addTag(tag:String) { tags.add(tag) }
    fun removeTag(tag:String) { tags.remove(tag) }
    fun returnTag(loc: Int): String { return tags.get(loc) }
    fun returnTagsListCount(): Int { return tags.count() }

    fun addIngredients(ingredient:String) { ingredients.add(ingredient) }
    fun removeIngredients(ingredient:String) { ingredients.remove(ingredient) }
    fun returnIngredients(loc: Int): String { return ingredients.get(loc) }
    fun returnIngredientsCount(): Int { return ingredients.count() }

    fun addInstruction(instruction:String) { instructions.add(instruction) }
    fun removeInstruction(instruction:String) { instructions.remove(instruction) }
    fun returnInstructions(loc: Int): String { return instructions.get(loc) }
    fun returnInstructionsCount(): Int { return instructions.count() }
}

class Category(override var title: String) : Page(title) {
    var pages = ArrayList<Page>()

    fun addRecipe(__recipe:Page) { pages.add(__recipe) }
    fun removeRecipe(__recipe:Page) { pages.remove(__recipe) }
    fun returnPage(loc: Int): Page { return pages.get(loc) }
    fun returnPageCount(): Int { return pages.count() }
}