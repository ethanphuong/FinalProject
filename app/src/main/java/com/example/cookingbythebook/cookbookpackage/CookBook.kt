package com.example.cookingbythebook.cookbookpackage

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.strategypackage.CompileStrategy

interface Book {
    var titlePage: Page?
    var compiler: CompileStrategy?
    fun addPage(categoryName: String, page: Page)
    fun setListCompiler(_compiler: CompileStrategy)
    fun compile(searchInput: String): ArrayList<Page>
    fun createIterator(): Iterator
}

class CookBook: Book{
    override var titlePage: Page? = null
    override var compiler: CompileStrategy? = null

    constructor(bookName: String) {
        titlePage = Category(bookName) //head page of the cookbook
    }

    override fun addPage(categoryName: String, page: Page) {
        if (titlePage != null) {
            var it: CookBookIterator = CookBookIterator(titlePage)
            if (it is Category && it.returnTitle() == categoryName) {
                it.addPage(page)
            }
        }
    }

    override fun setListCompiler(_compiler: CompileStrategy) {
        compiler = _compiler
    }

    override fun compile(searchInput: String): ArrayList<Page> {
        if (compiler != null) {
            var it: CookBookIterator = CookBookIterator(titlePage)
            if (it.hasNext()) {
                var compiledList: ArrayList<Page> = ArrayList<Page>()
                compiledList = compiler!!.compileList(it, searchInput)
            }
        }
        else {
            throw IllegalArgumentException("List compiler required")
        }
    }

}