package com.example.cookingbythebook

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
    var cookBook: CookBook = CookBook("Vy's Cook Book")
    var page1: Recipe = Recipe("Chocolate Cake")
    var page2: Recipe = Recipe("Red Velvet Cake")
    var page3: Recipe = Recipe("Brownie")
    var page4: Recipe = Recipe("Cheesecake")
    var page5: Recipe = Recipe("Mochi Donuts")
    var page6: Recipe = Recipe("Glazed Donuts")
    var page7: Recipe = Recipe("Tiramisu Cake")
    var page8: Recipe = Recipe ("Vanilla Latte")
    var page9: Recipe = Recipe("Chocolate Ice Cream")
    var page10: Recipe = Recipe("Vanilla Ice Cream")

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

    var page1: Recipe = Recipe("Supreme Pizza")
    page1.addTag("Italian")
    page1.addTag("cheesy")

    var page2: Recipe = Recipe("Red Velvet Cake")
    page2.addTag("dessert")
    page2.addTag("cake")

    var page3: Recipe = Recipe("Spaghetti")
    page3.addTag("Italian")
    page3.addTag("pasta")

    var page4: Recipe = Recipe("Macaroni and Cheese")
    page4.addTag("pasta")
    page4.addTag("cheesy")

    var page5: Recipe = Recipe("Mochi Donuts")
    page5.addTag("dessert")
    page5.addTag("donuts")

    var page6: Recipe = Recipe("Iced Americano")
    page6.addTag("coffee")
    page6.addTag("drinks")

    var page7: Recipe = Recipe("Lasagna")
    page7.addTag("Italian")
    page7.addTag("pasta")
    page7.addTag("cheesy")

    var page8: Recipe = Recipe ("Vanilla Latte")
    page8.addTag("drinks")
    page8.addTag("coffee")

    var page9: Recipe = Recipe("Cheese Foam Green Tea")
    page9.addTag("drinks")
    page9.addTag("cheesy")
    page9.addTag("tea")

    var page10: Recipe = Recipe("Caramel Macchiato")
    page10.addTag("coffee")
    page10.addTag("drinks")

    var page11: Recipe = Recipe("Cheesecake")
    page11.addTag("dessert")
    page11.addTag("cheesy")

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

    var page1: Page = Recipe("Supreme Pizza")
    var recipe1: Recipe = page1 as Recipe
    recipe1.addIngredient("dough")
    recipe1.addIngredient("tomato")
    recipe1.addIngredient("cheese")
    recipe1.addIngredient("bell pepper")
    recipe1.addIngredient("olive")
    recipe1.addIngredient("sausages")
    recipe1.addIngredient("pepperoni")

    var page2: Page = Recipe("Red Velvet Cake")
    var recipe2: Recipe = page2 as Recipe
    recipe2.addIngredient("eggs")
    recipe2.addIngredient("flour")
    recipe2.addIngredient("baking soda")
    recipe2.addIngredient("cocoa powder")
    recipe2.addIngredient("sugar")

    var page3: Page = Recipe("Spaghetti")
    var recipe3: Recipe = page3 as Recipe
    recipe3.addIngredient("noodles")
    recipe3.addIngredient("tomato")
    recipe3.addIngredient("sausage")
    recipe3.addIngredient("meatball")

    var page4: Page = Recipe("Macaroni and Cheese")
    var recipe4: Recipe = page4 as Recipe
    recipe4.addIngredient("macaroni")
    recipe4.addIngredient("cheese")
    recipe3.addIngredient("salt")

    var page5: Page = Recipe("Mochi Donuts")
    var recipe5: Recipe = page5 as Recipe
    recipe5.addIngredient("rice flour")
    recipe5.addIngredient("sugar")
    recipe5.addIngredient("tofu")
    recipe5.addIngredient("milk")
    recipe5.addIngredient("eggs")

    var page6: Page = Recipe("Lasagna")
    var recipe6: Recipe = page6 as Recipe
    recipe6.addIngredient("pasta")
    recipe6.addIngredient("ground beef")
    recipe6.addIngredient("cheese")
    recipe6.addIngredient("tomato")
    recipe6.addIngredient("cheese")

    var page7: Page = Recipe("Ravioli")
    var recipe7: Recipe = page7 as Recipe
    recipe7.addIngredient("pasta")
    recipe7.addIngredient("cheese")
    recipe7.addIngredient("ground beef")
    recipe7.addIngredient("tomato")

    var ingredientStrategy: CompileStrategy = IngredientsCompileStrategy()
    cookBook.setListCompiler(ingredientStrategy)

    var searchInput: String = "tomato"
    var tagList: ArrayList<Page> = cookBook.compile(searchInput)

    assertEquals(tagList.get(0).returnTitle(), "Pizza")
    assertEquals(tagList.get(1).returnTitle(), "Spaghetti")
    assertEquals(tagList.get(2).returnTitle(), "Lasagna")
    assertEquals(tagList.get(3).returnTitle(), "Ravioli")
}