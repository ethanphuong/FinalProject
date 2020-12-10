package com.example.cookingbythebook.cookbookpackage

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.strategypackage.CompileStrategy

interface Book {
    var titlePage: Page?
    var compiler: CompileStrategy?
    var pageCount: Int
    fun addPage(categoryName: String, page: Page)
    fun setListCompiler(_compiler: CompileStrategy)
    fun compile(searchInput: String): ArrayList<Page>
    fun returnPageCount(): Int
}

class CookBook: Book{
    override var titlePage: Page? = null
    override var compiler: CompileStrategy? = null
    override var pageCount = 1

    constructor(bookName: String) {
        titlePage = Category(bookName) //head page of the cookbook
    }

    override fun addPage(categoryName: String, page: Page) {
        //to lower category name
        if (categoryName == "") {
            if (titlePage is Category) {
                (titlePage as Category).addPage(page)
                pageCount++
                return
            }
        }

        var _categoryName: String = categoryName
        _categoryName.toLowerCase()

        if (titlePage != null) {
            var it = PreorderIterator(titlePage)

            it.first()
            while (!it.isDone()) {
                // to lower page's title
                var _pageTitle: String = it.getCurrent().returnTitle()
                _pageTitle.toLowerCase()

                if (it.getCurrent() is Category && _pageTitle == _categoryName) {
                    it.getCurrent().addPage(page)
                    pageCount++
                    return
                }
                it.getNext()
            }
        }
    }

    override fun setListCompiler(_compiler: CompileStrategy) {
        compiler = _compiler
    }

    override fun compile(searchInput: String): ArrayList<Page> {
        var compiledList: ArrayList<Page> = ArrayList<Page>()
        if (compiler != null) {
            compiledList = compiler!!.compileList(titlePage, searchInput)
        }
        else {
            throw IllegalArgumentException("List compiler required")
        }
        return compiledList;
    }

    override fun returnPageCount(): Int {
        return pageCount
    }
}