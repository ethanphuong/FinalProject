package com.example.cookingbythebook

import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.iteratorpackage.BinaryIterator
import com.example.cookingbythebook.iteratorpackage.PreorderIterator
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
class SecondUnitTest{
    @Test
    fun testBinary(){
        val testArr: MutableList<Page> = mutableListOf<Page>()
        val page1 = Page("Page 1")
        val page2 = Page("Page 2")
        val page3 = Page("Page 3")
        var expected = page2
        testArr.add(page1)
        testArr.add(page2)
        testArr.add(page3)

        val binaryTest = BinaryIterator(testArr, 1)
        var output = binaryTest.getCurrent()
        assertEquals(output, expected)

        expected = page1
        output = binaryTest.left()
        assertEquals(output, expected)

        expected = page3
        output = binaryTest.right()
        assertEquals(output, expected)
    }
}