package com.example.cookingbythebook.iteratorpackage
package com.example.cookingbythebook.compositepackage
import android.graphics.pdf.PdfDocument

interface Iterator {
    fun hasNext() : Boolean
    fun hasPrev() : Boolean
    fun getNext() : Page
    fun getPrev() : Page
}

class Book {
    private val pages = ArrayList<Page>()

    fun add(page: Page) {
        pages.add(page)
    }
    class PageIterator(private val collection: pageList, var index : Int) : Iterator {
        override fun getNext(): Page {
            return collection.pages[index++]
        }
        override fun getPrev(): Page {
            return collection.pages[index--]
        }
        override fun hasNext(): Page {
            return index < collection.pages.size
        }
        override fun hasPrev() : Page {
            return index > collection.pages.size
        }
    }

}