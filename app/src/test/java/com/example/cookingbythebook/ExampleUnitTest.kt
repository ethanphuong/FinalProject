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

    var page1: Page = Recipe("Supreme Pizza")
    var recipe1: Recipe = page1 as Recipe
    recipe1.addTag("Italian")
    recipe1.addTag("cheesy")

    var page2: Page = Recipe("Red Velvet Cake")
    var recipe2: Recipe = page2 as Recipe
    recipe2.addTag("dessert")
    recipe2.addTag("cake")

    var page3: Page = Recipe("Spaghetti")
    var recipe3: Recipe = page3 as Recipe
    recipe3.addTag("Italian")
    recipe3.addTag("pasta")

    var page4: Page = Recipe("Macaroni and Cheese")
    var recipe4: Recipe = page4 as Recipe
    recipe4.addTag("pasta")
    recipe4.addTag("cheesy")

    var page5: Page = Recipe("Mochi Donuts")
    var recipe5: Recipe = page5 as Recipe
    recipe5.addTag("dessert")
    recipe5.addTag("donuts")

    var page6: Page = Recipe("Iced Americano")
    var recipe6: Recipe = page6 as Recipe
    recipe6.addTag("coffee")
    recipe6.addTag("drinks")

    var page7: Page = Recipe("Lasagna")
    var recipe7: Recipe = page7 as Recipe
    recipe7.addTag("Italian")
    recipe7.addTag("pasta")
    recipe7.addTag("cheesy")

    var page8: Page = Recipe ("Vanilla Latte")
    var recipe8: Recipe = page8 as Recipe
    recipe8.addTag("drinks")
    recipe8.addTag("coffee")

    var page9: Page = Recipe("Cheese Foam Green Tea")
    var recipe9: Recipe = page9 as Recipe
    recipe9.addTag("drinks")
    recipe9.addTag("cheesy")
    recipe9.addTag("tea")

    var page10: Page = Recipe("Caramel Macchiato")
    var recipe10: Recipe = page10 as Recipe
    recipe10.addTag("coffee")
    recipe10.addTag("drinks")

    var page11: Page = Recipe("Cheesecake")
    var recipe11: Recipe = page11 as Recipe
    recipe11.addTag("dessert")
    recipe11.addTag("cheesy")

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