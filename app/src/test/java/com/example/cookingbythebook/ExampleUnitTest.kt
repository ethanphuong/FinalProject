package com.example.cookingbythebook

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.cookbookpackage.CookBook
import com.example.cookingbythebook.strategypackage.CompileStrategy
import com.example.cookingbythebook.strategypackage.IngredientsCompileStrategy
import com.example.cookingbythebook.strategypackage.TagCompileStrategy
import com.example.cookingbythebook.strategypackage.TitleCompileStrategy
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
    var cookBook = CookBook("Vy's Cook Book")
    var page1 = Recipe("Chocolate Cake")
    var page2 = Recipe("Red Velvet Cake")
    var page3 = Recipe("Brownie")
    var page4 = Recipe("Cheesecake")
    var page5 = Recipe("Mochi Donuts")
    var page6 = Recipe("Glazed Donuts")
    var page7 = Recipe("Tiramisu Cake")
    var page8 = Recipe ("Vanilla Latte")
    var page9 = Recipe("Chocolate Ice Cream")
    var page10 = Recipe("Vanilla Ice Cream")

    //add pages to cookbook
    var categoryName: String = "Dessert"
    var categoryPage = Category(categoryName)
    cookBook.addPage("", categoryPage)
    cookBook.addPage(categoryName, page1)
    cookBook.addPage(categoryName, page2)
    cookBook.addPage(categoryName, page3)
    cookBook.addPage(categoryName, page4)
    cookBook.addPage(categoryName, page5)
    cookBook.addPage(categoryName, page6)
    cookBook.addPage(categoryName, page7)
    cookBook.addPage(categoryName, page8)
    cookBook.addPage(categoryName, page9)
    cookBook.addPage(categoryName, page10)

    var titleStrategy: CompileStrategy = TitleCompileStrategy()
    cookBook.setListCompiler(titleStrategy)

    var searchInput: String = "Cake"
    var titleList: ArrayList<Page> = cookBook.compile(searchInput)

    assertEquals(titleList.get(0).returnTitle(), "Chocolate Cake")
    assertEquals(titleList.get(1).returnTitle(), "Red Velvet Cake")
    assertEquals(titleList.get(2).returnTitle(), "Cheesecake")
    assertEquals(titleList.get(3).returnTitle(), "Tiramisu Cake")

}
@Test
fun tag_compile_list() {
    var cookBook: CookBook = CookBook("Vy's Cook Book")

    var page1 = Recipe("Supreme Pizza")
    page1.addTag("Italian")
    page1.addTag("cheesy")

    var page2 = Recipe("Red Velvet Cake")
    page2.addTag("dessert")
    page2.addTag("cake")

    var page3 = Recipe("Spaghetti")
    page3.addTag("Italian")
    page3.addTag("pasta")

    var page4 = Recipe("Macaroni and Cheese")
    page4.addTag("pasta")
    page4.addTag("cheesy")

    var page5 = Recipe("Mochi Donuts")
    page5.addTag("dessert")
    page5.addTag("donuts")

    var page6 = Recipe("Iced Americano")
    page6.addTag("coffee")
    page6.addTag("drinks")

    var page7 = Recipe("Lasagna")
    page7.addTag("Italian")
    page7.addTag("pasta")
    page7.addTag("cheesy")

    var page8 = Recipe ("Vanilla Latte")
    page8.addTag("drinks")
    page8.addTag("coffee")

    var page9 = Recipe("Cheese Foam Green Tea")
    page9.addTag("drinks")
    page9.addTag("cheesy")
    page9.addTag("tea")

    var page10 = Recipe("Caramel Macchiato")
    page10.addTag("coffee")
    page10.addTag("drinks")

    var page11 = Recipe("Cheesecake")
    page11.addTag("dessert")
    page11.addTag("cheesy")

    var categoryName1: String = "Dessert"
    var categoryPage1 = Category(categoryName1)

    var categoryName2: String = "Beverages"
    var categoryPage2 = Category(categoryName2)

    var categoryName3: String = "Dinner"
    var categoryPage3 = Category(categoryName3)

    cookBook.addPage("", categoryPage1)
    cookBook.addPage("", categoryPage2)
    cookBook.addPage("", categoryPage3)

    cookBook.addPage(categoryName3, page1)
    cookBook.addPage(categoryName1, page2)
    cookBook.addPage(categoryName3, page3)
    cookBook.addPage(categoryName3, page4)
    cookBook.addPage(categoryName1, page5)
    cookBook.addPage(categoryName2, page6)
    cookBook.addPage(categoryName3, page7)
    cookBook.addPage(categoryName2, page8)
    cookBook.addPage(categoryName2, page9)
    cookBook.addPage(categoryName2, page10)
    cookBook.addPage(categoryName1, page11)

    var tagStrategy: CompileStrategy = TagCompileStrategy()
    cookBook.setListCompiler(tagStrategy)

    var searchInput: String = "cheesy"
    var tagList: ArrayList<Page> = cookBook.compile(searchInput)

    assertEquals(tagList.get(0).returnTitle(), "Pizza")
    assertEquals(tagList.get(1).returnTitle(), "Macaroni and Cheese")
    assertEquals(tagList.get(2).returnTitle(), "Lasagna")
    assertEquals(tagList.get(3).returnTitle(), "Cheese Foam Green Tea")
    assertEquals(tagList.get(4).returnTitle(), "Cheesecake")
}
@Test
fun ingredient_compile_list() {
    var cookBook: CookBook = CookBook("Vy's Cook Book")

    var page1 = Recipe("Supreme Pizza")
    page1.addIngredient("dough")
    page1.addIngredient("tomato")
    page1.addIngredient("cheese")
    page1.addIngredient("bell pepper")
    page1.addIngredient("olive")
    page1.addIngredient("sausages")
    page1.addIngredient("pepperoni")

    var page2 = Recipe("Red Velvet Cake")
    page2.addIngredient("eggs")
    page2.addIngredient("flour")
    page2.addIngredient("baking soda")
    page2.addIngredient("cocoa powder")
    page2.addIngredient("sugar")

    var page3: Recipe = Recipe("Spaghetti")
    page3.addIngredient("noodles")
    page3.addIngredient("tomato")
    page3.addIngredient("sausage")
    page3.addIngredient("meatball")

    var page4 = Recipe("Macaroni and Cheese")
    page4.addIngredient("macaroni")
    page4.addIngredient("cheese")
    page3.addIngredient("salt")

    var page5 = Recipe("Mochi Donuts")
    page5.addIngredient("rice flour")
    page5.addIngredient("sugar")
    page5.addIngredient("tofu")
    page5.addIngredient("milk")
    page5.addIngredient("eggs")

    var page6 = Recipe("Lasagna")
    page6.addIngredient("pasta")
    page6.addIngredient("ground beef")
    page6.addIngredient("cheese")
    page6.addIngredient("tomato")
    page6.addIngredient("cheese")

    var page7 = Recipe("Ravioli")
    page7.addIngredient("pasta")
    page7.addIngredient("cheese")
    page7.addIngredient("ground beef")
    page7.addIngredient("tomato")

    var categoryName1: String = "Dessert"
    var categoryPage1 = Category(categoryName1)

    var categoryName2: String = "Dinner"
    var categoryPage2 = Category(categoryName2)

    cookBook.addPage("", categoryPage1)
    cookBook.addPage("", categoryPage2)
    cookBook.addPage(categoryName2, page1)
    cookBook.addPage(categoryName1, page2)
    cookBook.addPage(categoryName2, page3)
    cookBook.addPage(categoryName2, page4)
    cookBook.addPage(categoryName1, page5)
    cookBook.addPage(categoryName2, page6)
    cookBook.addPage(categoryName2, page7)

    var ingredientStrategy: CompileStrategy = IngredientsCompileStrategy()
    cookBook.setListCompiler(ingredientStrategy)

    var searchInput: String = "tomato"
    var tagList: ArrayList<Page> = cookBook.compile(searchInput)

    assertEquals(tagList.get(0).returnTitle(), "Pizza")
    assertEquals(tagList.get(1).returnTitle(), "Spaghetti")
    assertEquals(tagList.get(2).returnTitle(), "Lasagna")
    assertEquals(tagList.get(3).returnTitle(), "Ravioli")
}