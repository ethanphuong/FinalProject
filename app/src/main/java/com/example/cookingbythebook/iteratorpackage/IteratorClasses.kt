package com.example.cookingbythebook.iteratorpackage

import com.example.cookingbythebook.compositepackage.Category

import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.cookbookpackage.CookBook
import java.util.*

interface CookbookIterator {
    fun getNext()
    fun isDone(): Boolean
    fun first()
    fun current(): Page?
}


interface PreorderIteratorInterface : CookbookIterator {
    var iterators: ArrayDeque<CookbookIterator>
}

class CategoryIterator(var arr: Category) : CookbookIterator{
    private var atEnd: Boolean = false
    private var index: Int = 0
    override fun getNext() {
        when {
            index < arr.returnPagesCount() - 1 -> {
                index++
            }
            index == arr.returnPagesCount() - 1 -> {
                atEnd = true
            }
            else -> {
                atEnd = true
            }
        }
    }

    override fun isDone(): Boolean {
        if (atEnd) {
            return true
        }
        return false
    }

    override fun first() {
        index = 0
    }

    override fun current(): Page? {
        return arr.returnPage(index)
    }
}

class PreorderIterator(var titlePage: Page?) : CookbookIterator, PreorderIteratorInterface {

    override var iterators = ArrayDeque<CookbookIterator>()

    override fun first(){
        while(!iterators.isEmpty())
        {
            iterators.pop()
        }
        if(titlePage != null) {
            val rootIterator: CookbookIterator? = titlePage?.createIterator()
            rootIterator?.first()
            iterators.push(rootIterator)
        }
    }

    override fun getNext() {
        val topIterator: CookbookIterator? = iterators.first().current()?.createIterator()
        topIterator?.first()
        iterators.push(topIterator)
        while(!iterators.isEmpty() && iterators.first().isDone())
        {
            iterators.pop()
            if(!iterators.isEmpty())
            {
                iterators.first().getNext()
            }
        }
    }

    override fun isDone(): Boolean {
        if (iterators.isEmpty())
        {
            return true
        }
        return false
    }

    override fun current(): Page? {
        return iterators.first().current()
    }
}

class NullIterator(var titlePage: Page?) : CookbookIterator
{
    override fun current(): Page? {
        return null
    }

    override fun getNext() {
    }

    override fun isDone(): Boolean {
        return true
    }

    override fun first() {
    }

}





