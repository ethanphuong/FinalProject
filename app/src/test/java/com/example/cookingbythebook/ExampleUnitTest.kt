package com.example.cookingbythebook

import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
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
    @Test
    fun page_title_isCorrect() {
        var tempTitle: String = "Pizza"
        var tempPage: Page = Recipe(tempTitle)
        assertEquals(tempPage.returnTitle(), tempTitle)
    }
}