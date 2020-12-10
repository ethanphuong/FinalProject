package com.example.cookingbythebook.iteratorpackage

import java.util.Stack

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page


import android.graphics.pdf.PdfDocument

interface Iterator {
    fun getNext()
    fun isDone(): Boolean
    fun first()
}
interface CategoryIteratorInterface : Iterator{
    var atEnd: Boolean
    fun current(): Page
}

interface PreorderIteratorInterface : Iterator {
    var iterators: Stack<Iterator>
    fun current(): Iterator
}

interface NullIteratorInterface : Iterator {
    fun current()
}

class CategoryIterator(var arr: ArrayList<Page>, var index : Int) : Iterator, CategoryIteratorInterface {

    override var atEnd: Boolean = false

    constructor(){
        index = 0
    }
    override fun getNext() {
        when {
            index < arr.size -> {
                var temp: Int = index
                temp += 1
                index = temp
            }
            index == arr.size - 1 -> {
                atEnd = true
            }
            else -> {
                atEnd = true
            }
        }
    }

    override fun isDone(): Boolean {
        if(atEnd)
        {
            return true
        }
        return false
    }

    override fun first() {
        index = 0
    }

    override fun current(): Page {
        return arr[index]
    }
}

class PreorderIterator(var titlePage: Page?) : Iterator, PreorderIteratorInterface {

    override var iterators: Stack<Iterator> = Stack<Iterator>()

    constructor(){
        iterators = Stack<Iterator>()
    }

    override fun first(){
        while(!iterators.empty())
        {
            iterators.pop()
        }
        var rootIterator = Category.createIterator()
        rootIterator.first()
        iterators.push(rootIterator)
    }

    override fun getNext() {
        var topIterator: Iterator = current()
        topIterator = Category.createIterator()
        topIterator.first()
        iterators.push(topIterator)
        while(!iterators.empty() && iterators.peek().isDone())
        {
            iterators.pop()
            if(!iterators.empty())
            {
                iterators.peek().getNext()
            }
        }
    }

    override fun isDone(): Boolean {
        return iterators.empty()
    }

    override fun current() : Iterator {
        return iterators.peek()
    }
}

class NullIterator(var titlePage: Page?) : Iterator, NullIteratorInterface
{
    override fun current() {
    }

    override fun getNext() {
    }

    override fun isDone(): Boolean {
        return true
    }

    override fun first() {
    }

}




