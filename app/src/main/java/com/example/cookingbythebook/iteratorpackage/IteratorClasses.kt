package com.example.cookingbythebook.iteratorpackage

import java.util.*

package com.example.cookingbythebook.compositepackage
import android.graphics.pdf.PdfDocument

interface Iterator {
    fun getNext() : Page
    fun getPrev() : Page
}

class Book:Cookbook {
    inner class CookbookIterator() : Iterator {
        override fun getNext(): Category
        {
        var titlePageIterator: Category = titlePage as Category
        var categoryLengthNext: Int
            categoryLengthNext = titlePageIterator.returnPagesCount()
            var index: Int
            index = pages[0]
            if (categoryLengthNext >= 1)
            {
                for(i in 0..categoryLengthNext) {
                    if (titlePage is Category) {
                        return pages[index++]
                    }
                }
            }
        }

        override fun getPrev(): Category
        {
            var titlePageIterator: Category = titlePage as Category
            var categoryLengthPrev: Int
            categoryLengthPrev = titlePageIterator.returnPagesCount()
            var index: Int
            index = pages.lastIndex
            if ((categoryLengthPrev >= 1) {
                        for(i in 0..categoryLengthPrev) {
                            if (titlePage is Category) {
                                return pages[index--]
                            }
                        }
            }
        }
    }

}