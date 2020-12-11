package com.example.cookingbythebook.cookbookpackage

import android.os.Parcel
import android.os.Parcelable
import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.strategypackage.CompileStrategy
import com.example.cookingbythebook.iteratorpackage.PreorderIterator

interface Book {
    var titlePage: Page?
    var compiler: CompileStrategy?
    var pageCount: Int
    fun addPage(categoryName: String?, page: Page)
    fun setListCompiler(_compiler: CompileStrategy)
    fun compile(searchInput: String): ArrayList<Page>
    fun returnPageCount(): Int
}

class CookBook() : Book, Parcelable {
    override var titlePage: Page? = null
    override var compiler: CompileStrategy? = null
    override var pageCount = 1

    constructor(bookName: String) : this() {
        titlePage = Category(bookName) //head page of the cookbook
    }

    constructor(parcel: Parcel) : this() {
        titlePage = parcel.readParcelable(Category::class.java.classLoader)
        pageCount = parcel.readInt()
    }

    override fun addPage(categoryName: String?, page: Page) {
        //to lower category name
        if (categoryName == "") {
            if (titlePage is Category) {
                (titlePage as Category).addPage(page)
                pageCount++
                return
            }
        }
        else {

            var _categoryName: String? = categoryName
            _categoryName?.toLowerCase()

            if (titlePage != null) {
                var it = PreorderIterator(titlePage)
                it.first()

                while (!it.isDone()) {
                    // to lower page's title
                    if (it.current() != null && it.current() is Category) {
                        var _pageTitle: String? = it.current()!!.returnTitle()
                        _pageTitle?.toLowerCase()
                        
                        if (it.current() is Category && _pageTitle == _categoryName) {
                            (it.current() as Category).addPage(page)
                            pageCount++
                            return
                        }
                    }
                    it.getNext()
                }
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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(titlePage, flags)
        parcel.writeInt(pageCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CookBook> {
        override fun createFromParcel(parcel: Parcel): CookBook {
            return CookBook(parcel)
        }

        override fun newArray(size: Int): Array<CookBook?> {
            return arrayOfNulls(size)
        }
    }
}