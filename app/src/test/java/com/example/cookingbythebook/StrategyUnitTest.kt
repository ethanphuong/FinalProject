package com.example.cookingbythebook

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
import com.example.cookingbythebook.cookbookpackage.CookBook
import com.example.cookingbythebook.iteratorpackage.PreorderIterator
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
class StrategyUnitTest {
    @Test
    fun test_all() {
        build_cookbook_1()
        build_cookbook_2()
        build_cookbook_3()
        build_cookbook_4()
        title_compile_list()
        tag_compile_list()
        ingredient_compile_list()
    }

    @Test
    fun build_cookbook_1() {
        val cookBook = CookBook("Brandon's Cook Book")

        val category1 = Category("Italian")
        val category2 = Category("Beverages")
        val page1 = Recipe("Chicken Alfredo")
        val page2 = Recipe("Spaghetti")
        val page3 = Recipe("Ravioli")
        val page4 = Recipe("Thai Tea")
        val page5 = Recipe("Taro Tea")

        cookBook.addPage("", category1)
        cookBook.addPage("", category2)
        cookBook.addPage("Italian", page1)
        cookBook.addPage("Italian", page2)
        cookBook.addPage("Italian", page3)
        cookBook.addPage("Beverages", page4)
        cookBook.addPage("Beverages", page5)

        assertEquals(cookBook.returnPageCount(), 8)
    }

    @Test
    fun build_cookbook_2() {
        val cookBook = CookBook("Vy's Cook Book")
        val page1 = Recipe("Chocolate Cake")
        val page2 = Recipe("Red Velvet Cake")
        val page3 = Recipe("Brownie")
        val page4 = Recipe("Cheesecake")
        val page5 = Recipe("Mochi Donuts")
        val page6 = Recipe("Glazed Donuts")
        val page7 = Recipe("Tiramisu Cake")
        val page8 = Recipe("Chocolate Cookies")
        val page9 = Recipe("Chocolate Ice Cream")
        val page10 = Recipe("Vanilla Ice Cream")

        //add pages to cookbook
        val categoryPage = Category("Dessert")

        cookBook.addPage("", categoryPage)
        cookBook.addPage("Dessert", page1)
        cookBook.addPage("Dessert", page2)
        cookBook.addPage("Dessert", page3)
        cookBook.addPage("Dessert", page4)
        cookBook.addPage("Dessert", page5)
        cookBook.addPage("Dessert", page6)
        cookBook.addPage("Dessert", page7)
        cookBook.addPage("Dessert", page8)
        cookBook.addPage("Dessert", page9)
        cookBook.addPage("Dessert", page10)

        assertEquals(cookBook.returnPageCount(), 12)
    }

    @Test
    fun build_cookbook_3() {
        val cookBook = CookBook("Vy's Cook Book")

        val category1 = Category("Dinner")
        val category2 = Category("Beverages")
        val category3 = Category("Dessert")

        val page1 = Recipe("Supreme Pizza")
        page1.addTag("Italian")
        page1.addTag("cheesy")

        val page2 = Recipe("Red Velvet Cake")
        page2.addTag("dessert")
        page2.addTag("cake")

        val page3 = Recipe("Spaghetti")
        page3.addTag("Italian")
        page3.addTag("pasta")

        val page4 = Recipe("Macaroni and Cheese")
        page4.addTag("pasta")
        page4.addTag("cheesy")

        val page5 = Recipe("Mochi Donuts")
        page5.addTag("dessert")
        page5.addTag("donuts")

        val page6 = Recipe("Iced Americano")
        page6.addTag("coffee")
        page6.addTag("drinks")

        val page7 = Recipe("Lasagna")
        page7.addTag("Italian")
        page7.addTag("pasta")
        page7.addTag("cheesy")

        val page8 = Recipe("Vanilla Latte")
        page8.addTag("drinks")
        page8.addTag("coffee")

        val page9 = Recipe("Cheese Foam Green Tea")
        page9.addTag("drinks")
        page9.addTag("cheesy")
        page9.addTag("tea")

        val page10 = Recipe("Caramel Macchiato")
        page10.addTag("coffee")
        page10.addTag("drinks")

        val page11 = Recipe("Cheesecake")
        page11.addTag("dessert")
        page11.addTag("cheesy")

        cookBook.addPage("", category1)
        cookBook.addPage("", category2)
        cookBook.addPage("", category3)
        cookBook.addPage("Dinner", page1)
        cookBook.addPage("Beverages", page2)
        cookBook.addPage("Dinner", page3)
        cookBook.addPage("Dinner", page4)
        cookBook.addPage("Dessert", page5)
        cookBook.addPage("Beverages", page6)
        cookBook.addPage("Dinner", page7)
        cookBook.addPage("Beverages", page8)
        cookBook.addPage("Beverages", page9)
        cookBook.addPage("Beverages", page10)
        cookBook.addPage("Dessert", page11)

        assertEquals(cookBook.returnPageCount(), 15)
    }

    @Test
    fun build_cookbook_4() {
        val cookBook: CookBook = CookBook("Vy's Cook Book")

        val category1 = Category("Dessert")
        val category2 = Category("Dinner")

        val page1 = Recipe("Supreme Pizza")
        page1.addIngredient("dough")
        page1.addIngredient("tomato")
        page1.addIngredient("cheese")
        page1.addIngredient("bell pepper")
        page1.addIngredient("olive")
        page1.addIngredient("sausages")
        page1.addIngredient("pepperoni")

        val page2 = Recipe("Red Velvet Cake")
        page2.addIngredient("eggs")
        page2.addIngredient("flour")
        page2.addIngredient("baking soda")
        page2.addIngredient("cocoa powder")
        page2.addIngredient("sugar")

        val page3: Recipe = Recipe("Spaghetti")
        page3.addIngredient("noodles")
        page3.addIngredient("tomato")
        page3.addIngredient("sausage")
        page3.addIngredient("meatball")

        val page4 = Recipe("Macaroni and Cheese")
        page4.addIngredient("macaroni")
        page4.addIngredient("cheese")
        page3.addIngredient("salt")

        val page5 = Recipe("Mochi Donuts")
        page5.addIngredient("rice flour")
        page5.addIngredient("sugar")
        page5.addIngredient("tofu")
        page5.addIngredient("milk")
        page5.addIngredient("eggs")

        val page6 = Recipe("Lasagna")
        page6.addIngredient("pasta")
        page6.addIngredient("ground beef")
        page6.addIngredient("cheese")
        page6.addIngredient("tomato")
        page6.addIngredient("cheese")

        val page7 = Recipe("Ravioli")
        page7.addIngredient("pasta")
        page7.addIngredient("cheese")
        page7.addIngredient("ground beef")
        page7.addIngredient("tomato")

        cookBook.addPage("", category1)
        cookBook.addPage("", category2)
        cookBook.addPage("Dinner", page1)
        cookBook.addPage("Dessert", page2)
        cookBook.addPage("Dinner", page3)
        cookBook.addPage("Dinner", page4)
        cookBook.addPage("Dessert", page5)
        cookBook.addPage("Dessert", page6)
        cookBook.addPage("Dinner", page7)

        assertEquals(cookBook.returnPageCount(), 10)
    }

    @Test
    fun title_compile_list() {
        val cookBook = CookBook("Vy's Cook Book")
        val page1 = Recipe("Chocolate Cake")
        val page2 = Recipe("Red Velvet Cake")
        val page3 = Recipe("Brownie")
        val page4 = Recipe("Cheesecake")
        val page5 = Recipe("Mochi Donuts")
        val page6 = Recipe("Glazed Donuts")
        val page7 = Recipe("Tiramisu Cake")
        val page8 = Recipe("Chocolate Cookies")
        val page9 = Recipe("Chocolate Ice Cream")
        val page10 = Recipe("Vanilla Ice Cream")

        //add pages to cookbook
        val categoryPage = Category("Dessert")
        cookBook.addPage("", categoryPage)
        cookBook.addPage("Dessert", page1)
        cookBook.addPage("Dessert", page2)
        cookBook.addPage("Dessert", page3)
        cookBook.addPage("Dessert", page4)
        cookBook.addPage("Dessert", page5)
        cookBook.addPage("Dessert", page6)
        cookBook.addPage("Dessert", page7)
        cookBook.addPage("Dessert", page8)
        cookBook.addPage("Dessert", page9)
        cookBook.addPage("Dessert", page10)

        val titleStrategy: CompileStrategy = TitleCompileStrategy()
        cookBook.setListCompiler(titleStrategy)

        val searchInput: String = "Cake"
        val titleList: ArrayList<Page> = cookBook.compile(searchInput)

        assertEquals(cookBook.returnPageCount(), 12)

        assertEquals(titleList.get(0).returnTitle(), "Chocolate Cake")
        assertEquals(titleList.get(1).returnTitle(), "Red Velvet Cake")
        assertEquals(titleList.get(2).returnTitle(), "Cheesecake")
        assertEquals(titleList.get(3).returnTitle(), "Tiramisu Cake")

    }

    @Test
    fun tag_compile_list() {
        val cookBook = CookBook("Vy's Cook Book")

        val category1 = Category("Dinner")
        val category2 = Category("Beverages")
        val category3 = Category("Dessert")

        val page1 = Recipe("Supreme Pizza")
        page1.addTag("Italian")
        page1.addTag("cheesy")

        val page2 = Recipe("Red Velvet Cake")
        page2.addTag("dessert")
        page2.addTag("cake")

        val page3 = Recipe("Spaghetti")
        page3.addTag("Italian")
        page3.addTag("pasta")

        val page4 = Recipe("Macaroni and Cheese")
        page4.addTag("pasta")
        page4.addTag("cheesy")

        val page5 = Recipe("Mochi Donuts")
        page5.addTag("dessert")
        page5.addTag("donuts")

        val page6 = Recipe("Iced Americano")
        page6.addTag("coffee")
        page6.addTag("drinks")

        val page7 = Recipe("Lasagna")
        page7.addTag("Italian")
        page7.addTag("pasta")
        page7.addTag("cheesy")

        val page8 = Recipe("Vanilla Latte")
        page8.addTag("drinks")
        page8.addTag("coffee")

        val page9 = Recipe("Cheese Foam Green Tea")
        page9.addTag("drinks")
        page9.addTag("cheesy")
        page9.addTag("tea")

        val page10 = Recipe("Caramel Macchiato")
        page10.addTag("coffee")
        page10.addTag("drinks")

        val page11 = Recipe("Cheesecake")
        page11.addTag("dessert")
        page11.addTag("cheesy")

        cookBook.addPage("", category1)
        cookBook.addPage("", category2)
        cookBook.addPage("", category3)
        cookBook.addPage("Dinner", page1)
        cookBook.addPage("Beverages", page2)
        cookBook.addPage("Dinner", page3)
        cookBook.addPage("Dinner", page4)
        cookBook.addPage("Dessert", page5)
        cookBook.addPage("Beverages", page6)
        cookBook.addPage("Dinner", page7)
        cookBook.addPage("Beverages", page8)
        cookBook.addPage("Beverages", page9)
        cookBook.addPage("Beverages", page10)
        cookBook.addPage("Dessert", page11)

        val tagStrategy: CompileStrategy = TagCompileStrategy()
        cookBook.setListCompiler(tagStrategy)

        val searchInput: String = "cheesy"
        val tagList: ArrayList<Page> = cookBook.compile(searchInput)

        assertEquals(cookBook.returnPageCount(), 15)

        assertEquals(tagList.get(0).returnTitle(), "Supreme Pizza")
        assertEquals(tagList.get(1).returnTitle(), "Macaroni and Cheese")
        assertEquals(tagList.get(2).returnTitle(), "Lasagna")
        assertEquals(tagList.get(3).returnTitle(), "Cheese Foam Green Tea")
        assertEquals(tagList.get(4).returnTitle(), "Cheesecake")
    }

    @Test
    fun ingredient_compile_list() {
        val cookBook: CookBook = CookBook("Vy's Cook Book")

        val category1 = Category("Dessert")
        val category2 = Category("Dinner")

        val page1 = Recipe("Supreme Pizza")
        page1.addIngredient("dough")
        page1.addIngredient("tomato")
        page1.addIngredient("cheese")
        page1.addIngredient("bell pepper")
        page1.addIngredient("olive")
        page1.addIngredient("sausages")
        page1.addIngredient("pepperoni")

        val page2 = Recipe("Red Velvet Cake")
        page2.addIngredient("eggs")
        page2.addIngredient("flour")
        page2.addIngredient("baking soda")
        page2.addIngredient("cocoa powder")
        page2.addIngredient("sugar")

        val page3: Recipe = Recipe("Spaghetti")
        page3.addIngredient("noodles")
        page3.addIngredient("tomato")
        page3.addIngredient("sausage")
        page3.addIngredient("meatball")

        val page4 = Recipe("Macaroni and Cheese")
        page4.addIngredient("macaroni")
        page4.addIngredient("cheese")
        page3.addIngredient("salt")

        val page5 = Recipe("Mochi Donuts")
        page5.addIngredient("rice flour")
        page5.addIngredient("sugar")
        page5.addIngredient("tofu")
        page5.addIngredient("milk")
        page5.addIngredient("eggs")

        val page6 = Recipe("Lasagna")
        page6.addIngredient("pasta")
        page6.addIngredient("ground beef")
        page6.addIngredient("cheese")
        page6.addIngredient("tomato")
        page6.addIngredient("cheese")

        val page7 = Recipe("Ravioli")
        page7.addIngredient("pasta")
        page7.addIngredient("cheese")
        page7.addIngredient("ground beef")
        page7.addIngredient("tomato")

        cookBook.addPage("", category1)
        cookBook.addPage("", category2)
        cookBook.addPage("Dinner", page1)
        cookBook.addPage("Dessert", page2)
        cookBook.addPage("Dinner", page3)
        cookBook.addPage("Dinner", page4)
        cookBook.addPage("Dessert", page5)
        cookBook.addPage("Dinner", page6)
        cookBook.addPage("Dinner", page7)

        val ingredientStrategy: CompileStrategy = IngredientsCompileStrategy()
        cookBook.setListCompiler(ingredientStrategy)

        val searchInput: String = "tomato"
        val tagList: ArrayList<Page> = cookBook.compile(searchInput)

        assertEquals(cookBook.returnPageCount(), 10)

        assertEquals(tagList.get(0).returnTitle(), "Supreme Pizza")
        assertEquals(tagList.get(1).returnTitle(), "Spaghetti")
        assertEquals(tagList.get(2).returnTitle(), "Lasagna")
        assertEquals(tagList.get(3).returnTitle(), "Ravioli")
    }

}