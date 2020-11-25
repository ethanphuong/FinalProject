package com.example.cookingbythebook.cookbookpackage

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.strategypackage.CompileStrategy

interface Book {
    var titlePage: Page?
    var compiler: CompileStrategy?
    fun addPage(categoryName: String, page: Page)
    fun setListCompiler(_compiler: Compiler)
    fun compile(searchInput: String)
}

class CookBook: Book{
    override var titlePage: Page? = null
    override var compiler: CompileStrategy? = null

    constructor(bookName: String) {
        titlePage = Category(bookName) //head page of the cookbook
    }

    override fun addPage(categoryName: String, page: Page) {
        if (titlePage != null) {
            if (titlePage is Category) {
                var _titlePage = titlePage as Category
                if (_titlePage.returnTitle() == categoryName) {
                    _titlePage.addRecipe(page)
                }
            }
        }
    }

    override fun setListCompiler(_compiler: CompileStrategy) {
        compiler = _compiler
    }

    override fun compile(searchInput: String) {
        if (compiler != null) {
            var it: CookBookIterator = CookBookIterator(this)
            if (it.hasNext()) {
                compiler!!.compileList(it, searchInput)
            }
        }
        else {
            throw IllegalArgumentException("List compiler required")
        }
    }
}