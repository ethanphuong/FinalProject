package com.example.cookingbythebook

import com.example.cookingbythebook.cookbookpackage.CookBook
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.iteratorpackage.CookbookIterator
import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.iteratorpackage.CategoryIterator
import com.example.cookingbythebook.iteratorpackage.PreorderIterator
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class FirstUnitTest {
    @Test
    fun testNullIterator() {
        val testCookbook: CookBook = CookBook("First Cookbook")
        val page1 = Recipe("Page 1")
        val page2 = Recipe("Page 2")
        val page3 = Recipe("Page 3")
        testCookbook.addPage("", page1)
        testCookbook.addPage("", page2)
        testCookbook.addPage("", page3)

        val testRecipeIterator: CookbookIterator = page1.createIterator()
        assertEquals(testRecipeIterator.isDone(), true)
    }
    @Test
    fun testNullIterator2() {
        val testCookbook: CookBook = CookBook("First Cookbook")
        val page1 = Recipe("Page 1")
        val page2 = Recipe("Page 2")
        val page3 = Recipe("Page 3")
        testCookbook.addPage("", page1)
        testCookbook.addPage("", page2)
        testCookbook.addPage("", page3)

        val testRecipeIterator: CookbookIterator = page1.createIterator()
        assertEquals(testRecipeIterator.getNext(), kotlin.Unit)
    }
    @Test
    fun testNullIterator3() {
        val testCookbook: CookBook = CookBook("First Cookbook")
        val page1 = Recipe("Page 1")
        val page2 = Recipe("Page 2")
        val page3 = Recipe("Page 3")
        testCookbook.addPage("", page1)
        testCookbook.addPage("", page2)
        testCookbook.addPage("", page3)

        val testRecipeIterator: CookbookIterator = page1.createIterator()
        assertEquals(testRecipeIterator.current(), null)
    }
    @Test
    fun testNullIterator4() {
        val testCookbook: CookBook = CookBook("First Cookbook")
        val page1 = Recipe("Page 1")
        val page2 = Recipe("Page 2")
        val page3 = Recipe("Page 3")
        testCookbook.addPage("", page1)
        testCookbook.addPage("", page2)
        testCookbook.addPage("", page3)

        val testRecipeIterator: CookbookIterator = page1.createIterator()
        assertEquals(testRecipeIterator.first(), kotlin.Unit)
    }
}

class SecondUnitTest{
    @Test
    fun testCategoryIterator1() {

        val testCategory: CookBook = CookBook("First Cookbook")
        val categoryCookBook = testCategory.titlePage
        val page1 = Recipe("Page 1")
        val page2 = Recipe("Page 2")
        val page3 = Recipe("Page 3")

        testCategory.addPage("", page1)
        testCategory.addPage("", page2)
        testCategory.addPage("", page3)

        val testRecipeIterator: CookbookIterator? = categoryCookBook?.createIterator()

        assertEquals(testRecipeIterator?.current(), page1)
        assertEquals(testRecipeIterator?.getNext(), kotlin.Unit)
        assertEquals(testRecipeIterator?.current(), page2)
        assertEquals(testRecipeIterator?.getNext(), kotlin.Unit)
        assertEquals(testRecipeIterator?.current(), page3)
        assertEquals(testRecipeIterator?.getNext(), kotlin.Unit)
        assertEquals(testRecipeIterator?.isDone(), true)

        assertEquals(testRecipeIterator?.first(), kotlin.Unit)
        assertEquals(testRecipeIterator?.current(), page1)

    }
}

class ThirdUnitTest{
    @Test
    fun testPreorder(){

        val testPreorder: CookBook = CookBook("Second Cookbook")
        val preOrderCookbook = testPreorder.titlePage

        val category1 = Recipe("Category 1")
        val page2 = Recipe("Page 2")
        val page3 = Recipe("Page 3")

        testPreorder.addPage("", category1)
        testPreorder.addPage("", page2)
        testPreorder.addPage("", page3)

        val testPreorderIterator: PreorderIterator = PreorderIterator(preOrderCookbook)

        assertEquals(testPreorderIterator.first(), kotlin.Unit)
        assertEquals(testPreorderIterator.current(), category1)
        assertEquals(testPreorderIterator.getNext(), kotlin.Unit)
        assertEquals(testPreorderIterator.current(), page2)
        assertEquals(testPreorderIterator.getNext(), kotlin.Unit)
        assertEquals(testPreorderIterator.current(), page3)
        assertEquals(testPreorderIterator.getNext(), kotlin.Unit)
        assertEquals(testPreorderIterator.isDone(), true)
    }

}