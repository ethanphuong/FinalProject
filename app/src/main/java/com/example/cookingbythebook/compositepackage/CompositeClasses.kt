package com.example.cookingbythebook.compositepackage
//package com.example.cookingbythebook.iteratorpackage

open class Page(protected open var title: String) {
    fun returnTitle(): String { return title }
    fun changeTitle(__title: String) { title = __title }
}

class Recipe(override var title: String) : Page(title) {
    private var tags = ArrayList<String>()
    private var ingredients = ArrayList<String>()
    private var instructions = ArrayList<String>()

    fun addTag(tag:String) { tags.add(tag) }
    fun removeTag(tag:String) { tags.remove(tag) }
    fun returnTag(loc: Int): String { return tags[loc] }
    fun returnTagsCount(): Int { return tags.count() }

    fun addIngredient(ingredient:String) { ingredients.add(ingredient) }
    fun removeIngredient(ingredient:String) { ingredients.remove(ingredient) }
    fun returnIngredient(loc: Int): String { return ingredients[loc] }
    fun returnIngredientsCount(): Int { return ingredients.count() }

    fun addInstruction(instruction:String) { instructions.add(instruction) }
    fun removeInstruction(instruction:String) { instructions.remove(instruction) }
    fun returnInstruction(loc: Int): String { return instructions[loc] }
    fun returnInstructionsCount(): Int { return instructions.count() }

    //fun create_iterator(): Iterator { return NullIterator(this) }
}

class Category(override var title: String) : Page(title) {
    private var pages = ArrayList<Page>()

    fun addPage(__page:Page) { pages.add(__page) }
    fun removePage(__page:Page) { pages.remove(__page) }
    fun returnPage(loc: Int): Page { return pages[loc] }
    fun returnPagesCount(): Int { return pages.count() }

    //fun create_iterator(): Iterator { return BinaryIterator(this) }
}