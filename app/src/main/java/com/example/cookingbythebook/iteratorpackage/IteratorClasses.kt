package com.example.cookingbythebook.iteratorpackage

import java.util.*

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.cookbookpackage.Book
import com.example.cookingbythebook.cookbookpackage.CookBook


import android.graphics.pdf.PdfDocument

interface Iterator {
    fun right(): Page
    fun left(): Page
    fun getCurrent(): Page
}


class BinaryIterator(var arr: ArrayList<Page>, var index : Int) : Iterator {
    override fun right(): Page {
        return if(index < arr.size)
        {
            arr[index++]
        }
        else {
            arr[index]
        }
    }

    override fun left(): Page {
        return if(index > 0)
        {
            arr[index++]
        }
        else {
            arr[index]
        }
    }

    override fun getCurrent(): Page {
        return arr[index]
    }
}

class PreorderIterator(var arr: ArrayList<Page>) : Iterator {
    override fun right() : Page {
        val binaryRight = BinaryIterator(arr, 0)
        val size: Int = arr.size - 1
        var x: Int = 0
        while (x < size) {
            if (arr[x] is Page) {
                binaryRight.right()
                x++
            } else {
                x++
            }
        }
        return arr[x]
    }

    override fun left() : Page{
        val binaryLeft = BinaryIterator(arr, arr.size - 1)
        val sizeLeft: Int = arr.size - 1
        var xLeft: Int = 0
        while (xLeft < sizeLeft) {
            if (arr[xLeft] is Page) {
                binaryLeft.left()
                xLeft++
            } else {
                xLeft++
            }
        }
        return arr[xLeft]
    }

    override fun getCurrent() : Page {
        return arr[0]
    }
}




