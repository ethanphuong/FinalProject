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
    fun return_page_title() {
        var title: String = "Pizza"
        var page: Page = Recipe(title)
        assertEquals(page.returnTitle(), title)
    }
    @Test
    fun change_page_title() {
        var title: String = "Pizza"
        var page: Page = Recipe(title)
        assertEquals(page.returnTitle(), title)
        //change title
        var newTitle: String = "Supreme Pizza"
        page.changeTitle(newTitle)
        assertEquals(page.returnTitle(), newTitle)
    }
    @Test
    fun title_compile_list() {
        var cookBook: CookBook = CookBook("Vy's Cook Book")
        var page1: Page = Recipe("Chocolate Cake")
        var page2: Page = Recipe("Red Velvet Cake")
        var page3: Page = Recipe("Brownie")
        var page4: Page = Recipe("Cheesecake")
        var page5: Page = Recipe("Mochi Donuts")
        var page6: Page = Recipe("Glazed Donuts")
        var page7: Page = Recipe("Tiramisu Cake")
        var page8: Page = Recipe ("Vanilla Latte")
        var page9: Page = Recipe("Chocolate Ice Cream")
        var page10: Page = Recipe("Vanilla Ice Cream")


    }
}