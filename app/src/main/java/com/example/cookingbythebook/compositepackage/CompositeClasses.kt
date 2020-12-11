package com.example.cookingbythebook.compositepackage

import android.os.Parcel
import android.os.Parcelable
import com.example.cookingbythebook.iteratorpackage.CategoryIterator
import com.example.cookingbythebook.iteratorpackage.CookbookIterator
import com.example.cookingbythebook.iteratorpackage.NullIterator

abstract class Page(protected open var title: String) : Parcelable {
    fun returnTitle(): String { return title }
    fun changeTitle(__title: String) { title = __title }
    abstract fun createIterator(): CookbookIterator
}

class Recipe(override var title: String) : Page(title), Parcelable {
    private var tags = ArrayList<String>()
    private var ingredients = ArrayList<String>()
    private var instructions = ArrayList<String>()

    constructor(_title: String, _tags: ArrayList<String>, _ingredients: ArrayList<String>, _instructions: ArrayList<String>) : this(_title) {
        tags = _tags
        ingredients = _ingredients
        instructions = _instructions
    }
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.createStringArrayList() as ArrayList<String>
    ) {

    }

    fun addTag(tag:String) { tags.add(tag) }
    fun removeTag(tag:String) { tags.remove(tag) }
    fun editTag(loc: Int, tag: String) { tags[loc] = tag }
    fun returnTag(loc: Int): String { return tags[loc] }
    fun returnTagsCount(): Int { return tags.count() }

    fun addIngredient(ingredient:String) { ingredients.add(ingredient) }
    fun removeIngredient(ingredient:String) { ingredients.remove(ingredient) }
    fun editIngredient(loc: Int, ingredient: String) { ingredients[loc] = ingredient }
    fun returnIngredient(loc: Int): String { return ingredients[loc] }
    fun returnIngredientsCount(): Int { return ingredients.count() }

    fun addInstruction(instruction:String) { instructions.add(instruction) }
    fun removeInstruction(instruction:String) { instructions.remove(instruction) }
    fun editInstruction(loc: Int, instruction: String) { instructions[loc] = instruction }
    fun returnInstruction(loc: Int): String { return instructions[loc] }
    fun returnInstructionsCount(): Int { return instructions.count() }

    override fun createIterator(): CookbookIterator { return NullIterator(this) }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeStringList(tags)
        parcel.writeStringList(ingredients)
        parcel.writeStringList(instructions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}

class Category(override var title: String) : Page(title) {
    private var pages = ArrayList<Page>()

    constructor(_title: String, _pages: java.util.ArrayList<Recipe>?) : this(_title) {
        if(_pages != null) {
            for (i in 1.._pages.size) {
                pages.add(_pages[i - 1])
            }
        }
    }
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.createTypedArrayList(Recipe.CREATOR)
    ) {

    }

    fun addPage(__page:Page) { pages.add(__page) }
    fun removePage(__page:Page) { pages.remove(__page) }
    fun returnPage(loc: Int): Page { return pages[loc] }
    fun returnPagesCount(): Int { return pages.count() }

    override fun createIterator(): CookbookIterator {
        return if(returnPagesCount() > 0) {
            CategoryIterator(this)
        }
        else {
            NullIterator(this)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeTypedArray(pages.toTypedArray(), flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}