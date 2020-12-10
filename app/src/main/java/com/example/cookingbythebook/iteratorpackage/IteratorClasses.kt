package com.example.cookingbythebook.iteratorpackage

import java.util.Stack

import com.example.cookingbythebook.compositepackage.Page

interface CookbookIterator {
    fun getNext()
    fun isDone(): Boolean
    fun first()
    fun current(): Page?
}
interface CategoryIteratorInterface : CookbookIterator{
    var atEnd: Boolean
}

interface PreorderIteratorInterface : CookbookIterator {
    var iterators: Stack<CookbookIterator>
}

class CategoryIterator(var arr: MutableList<Page>, var index : Int) : CookbookIterator, CategoryIteratorInterface {

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

    override fun current(): Page? {
        return arr[index]
    }
}

class PreorderIterator(var titlePage: Page?) : CookbookIterator, PreorderIteratorInterface {

    override var iterators: Stack<CookbookIterator> = Stack<CookbookIterator>()

    constructor(){
        iterators = Stack<CookbookIterator>()
    }

    override fun first(){
        while(!iterators.empty())
        {
            iterators.pop()
        }
        val rootIterator = titlePage?.createIterator()
        rootIterator?.first()
        iterators.push(rootIterator)
    }

    override fun getNext() {
        val topIterator: CookbookIterator? = iterators.peek().current()?.createIterator()
        topIterator?.first()
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

    override fun current(): Page? {
        return iterators.peek().current()
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




