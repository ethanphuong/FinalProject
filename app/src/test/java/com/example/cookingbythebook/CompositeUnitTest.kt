package com.example.cookingbythebook

import com.example.cookingbythebook.compositepackage.Category
import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CompositeUnitTest {
    @Test
    fun addition_isCorrect() { //example unit test
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_all(){
        test_recipe()
        test_category()
    }

    @Test
    fun test_recipe(){
        recipe_title_isCorrect()
        recipe_tags_number_isCorrect()
        recipe_tags_return_isCorrect()
        recipe_ingredients_number_isCorrect()
        recipe_ingredients_return_isCorrect()
        recipe_instructions_number_isCorrect()
        recipe_instructions_return_isCorrect()
    }

    @Test
    fun test_category(){
        category_title_isCorrect()
        category_returnPagesCount_isCorrect()
        category_returnPages_isCorrect()
    }

    @Test
    fun recipe_title_isCorrect() {
        var testTitle: String = "Pizza"
        var testPage: Page = Recipe(testTitle)
        assertEquals(testPage.returnTitle(), testTitle)

        var testRecipe: Recipe = testPage as Recipe
        assertEquals(testRecipe.returnTitle(), testTitle)
    }

    @Test
    fun recipe_tags_number_isCorrect() {
        //page and recipe creation
        var testTitle: String = "Pizza"
        var testPage: Page = Recipe(testTitle)
        var testRecipe : Recipe = testPage as Recipe
        assertEquals(testRecipe.returnTagsCount(), 0)

        //adding tags
        testRecipe.addTag("dairy")
        assertEquals(testRecipe.returnTagsCount(), 1)
        testRecipe.addTag("bread")
        assertEquals(testRecipe.returnTagsCount(), 2)
        testRecipe.addTag("Italian")
        assertEquals(testRecipe.returnTagsCount(), 3)

        //removing tags
        testRecipe.removeTag("dairy")
        assertEquals(testRecipe.returnTagsCount(), 2)
        testRecipe.removeTag("bread")
        assertEquals(testRecipe.returnTagsCount(), 1)
        testRecipe.removeTag("Italian")
        assertEquals(testRecipe.returnTagsCount(), 0)
    }

    @Test
    fun recipe_tags_return_isCorrect() {
        //page and recipe creation
        var testTitle: String = "Pizza"
        var testPage: Page = Recipe(testTitle)
        var testRecipe : Recipe = testPage as Recipe
        assertEquals(testRecipe.returnTagsCount(), 0)

        //adding tags
        testRecipe.addTag("dairy")
        assertEquals(testRecipe.returnTag(0), "dairy")
        testRecipe.addTag("bread")
        assertEquals(testRecipe.returnTag(1), "bread")
        testRecipe.addTag("Italian")
        assertEquals(testRecipe.returnTag(2), "Italian")

        //removing tags
        testRecipe.removeTag("dairy")
        assertEquals(testRecipe.returnTag(0), "bread")
        assertEquals(testRecipe.returnTag(1), "Italian")
        testRecipe.removeTag("bread")
        assertEquals(testRecipe.returnTag(0), "Italian")
        testRecipe.removeTag("Italian")
        assertEquals(testRecipe.returnTagsCount(), 0)
    }

    @Test
    fun recipe_ingredients_number_isCorrect(){
        var sushi: Recipe = Recipe("Sushi")
        assertEquals(sushi.returnIngredientsCount(), 0)

        sushi.addIngredient("Rice")
        assertEquals(sushi.returnIngredientsCount(), 1)
        sushi.addIngredient("Seaweed")
        assertEquals(sushi.returnIngredientsCount(), 2)
        sushi.addIngredient("Fish")
        assertEquals(sushi.returnIngredientsCount(), 3)

        sushi.removeIngredient("Seaweed")
        assertEquals(sushi.returnIngredientsCount(), 2)
        sushi.removeIngredient("Rice")
        assertEquals(sushi.returnIngredientsCount(), 1)
        sushi.removeIngredient("Fish")
        assertEquals(sushi.returnIngredientsCount(), 0)
    }

    @Test
    fun recipe_ingredients_return_isCorrect(){
        var sushi: Recipe = Recipe("Sushi")
        assertEquals(sushi.returnIngredientsCount(), 0)

        sushi.addIngredient("Rice")
        assertEquals(sushi.returnIngredient(0), "Rice")
        sushi.addIngredient("Seaweed")
        assertEquals(sushi.returnIngredient(0), "Rice")
        assertEquals(sushi.returnIngredient(1), "Seaweed")
        sushi.addIngredient("Fish")
        assertEquals(sushi.returnIngredient(0), "Rice")
        assertEquals(sushi.returnIngredient(1), "Seaweed")
        assertEquals(sushi.returnIngredient(2), "Fish")

        sushi.removeIngredient("Seaweed")
        assertEquals(sushi.returnIngredient(0), "Rice")
        assertEquals(sushi.returnIngredient(1), "Fish")
        sushi.removeIngredient("Rice")
        assertEquals(sushi.returnIngredient(0), "Fish")
        sushi.removeIngredient("Fish")
    }

    @Test
    fun recipe_instructions_number_isCorrect() {
        //page and recipe creation
        var testTitle: String = "Eggs"
        var testPage: Page = Recipe(testTitle)
        var testRecipe : Recipe = testPage as Recipe
        assertEquals(testRecipe.returnTagsCount(), 0)

        //adding instructions
        assertEquals(testRecipe.returnInstructionsCount(), 0)
        testRecipe.addInstruction("Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstructionsCount(), 1)
        testRecipe.addInstruction("Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstructionsCount(), 2)
        testRecipe.addInstruction("Add chicken powder, salt, and water to bowl.")
        assertEquals(testRecipe.returnInstructionsCount(), 3)
        testRecipe.addInstruction("Whisk ingredients in bowl thoroughly with fork or chopsticks.")
        assertEquals(testRecipe.returnInstructionsCount(), 4)
        testRecipe.addInstruction("Pour mixture into skillet when skillet is hot enough.")
        assertEquals(testRecipe.returnInstructionsCount(), 5)
        testRecipe.addInstruction("Using a pair of chopsticks, scoop cooked (yellow) edges of the egg inward.")
        assertEquals(testRecipe.returnInstructionsCount(), 6)
        testRecipe.addInstruction("Add ground pepper to egg and turn off heat when egg is done cooking, and serve.")
        assertEquals(testRecipe.returnInstructionsCount(), 7)

        //removing instructions
        val originalInstructionsLength = testRecipe.returnIngredientsCount()
        for(i in 1..testRecipe.returnIngredientsCount()) {
            testRecipe.removeInstruction(testRecipe.returnInstruction(i - 1))
            assertEquals(testRecipe.returnInstructionsCount(), originalInstructionsLength - i)
        }
    }

    @Test
    fun recipe_instructions_return_isCorrect() {
        //page and recipe creation
        var testTitle: String = "Eggs"
        var testPage: Page = Recipe(testTitle)
        var testRecipe : Recipe = testPage as Recipe
        assertEquals(testRecipe.returnTagsCount(), 0)

        //adding instructions
        testRecipe.addInstruction("Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")

        testRecipe.addInstruction("Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(1), "Break the eggs into a bowl.")

        testRecipe.addInstruction("Add chicken powder, salt, and water to bowl.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(1), "Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstruction(2), "Add chicken powder, salt, and water to bowl.")

        testRecipe.addInstruction("Whisk ingredients in bowl thoroughly with fork or chopsticks.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(1), "Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstruction(2), "Add chicken powder, salt, and water to bowl.")
        assertEquals(testRecipe.returnInstruction(3), "Whisk ingredients in bowl thoroughly with fork or chopsticks.")

        testRecipe.addInstruction("Pour mixture into skillet when skillet is hot enough.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(1), "Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstruction(2), "Add chicken powder, salt, and water to bowl.")
        assertEquals(testRecipe.returnInstruction(3), "Whisk ingredients in bowl thoroughly with fork or chopsticks.")
        assertEquals(testRecipe.returnInstruction(4), "Pour mixture into skillet when skillet is hot enough.")

        testRecipe.addInstruction("Using a pair of chopsticks, scoop cooked (yellow) edges of the egg inward.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(1), "Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstruction(2), "Add chicken powder, salt, and water to bowl.")
        assertEquals(testRecipe.returnInstruction(3), "Whisk ingredients in bowl thoroughly with fork or chopsticks.")
        assertEquals(testRecipe.returnInstruction(4), "Pour mixture into skillet when skillet is hot enough.")
        assertEquals(testRecipe.returnInstruction(5), "Using a pair of chopsticks, scoop cooked (yellow) edges of the egg inward.")

        testRecipe.addInstruction("Add ground pepper to egg and turn off heat when egg is done cooking, and serve.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(1), "Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstruction(2), "Add chicken powder, salt, and water to bowl.")
        assertEquals(testRecipe.returnInstruction(3), "Whisk ingredients in bowl thoroughly with fork or chopsticks.")
        assertEquals(testRecipe.returnInstruction(4), "Pour mixture into skillet when skillet is hot enough.")
        assertEquals(testRecipe.returnInstruction(5), "Using a pair of chopsticks, scoop cooked (yellow) edges of the egg inward.")
        assertEquals(testRecipe.returnInstruction(6), "Add ground pepper to egg and turn off heat when egg is done cooking, and serve.")

        //removing instructions
        testRecipe.removeInstruction("Add ground pepper to egg and turn off heat when egg is done cooking, and serve.")
        assertEquals(testRecipe.returnInstruction(0), "Put skillet on stove, add oil, and turn the heat to medium.")
        assertEquals(testRecipe.returnInstruction(1), "Break the eggs into a bowl.")
        assertEquals(testRecipe.returnInstruction(2), "Add chicken powder, salt, and water to bowl.")
        assertEquals(testRecipe.returnInstruction(3), "Whisk ingredients in bowl thoroughly with fork or chopsticks.")
        assertEquals(testRecipe.returnInstruction(4), "Pour mixture into skillet when skillet is hot enough.")
        assertEquals(testRecipe.returnInstruction(5), "Using a pair of chopsticks, scoop cooked (yellow) edges of the egg inward.")
    }

    @Test
    fun category_title_isCorrect() {
        var testTitle: String = "Lunch"
        var testPage: Page = Category(testTitle)
        assertEquals(testPage.returnTitle(), testTitle)

        var testCategory: Category = testPage as Category
        assertEquals(testCategory.returnTitle(), testTitle)
    }

    @Test
    fun category_returnPagesCount_isCorrect() {
        var testTitle: String = "Dinner"
        var testPage: Page = Category(testTitle)

        var testCategory: Category = testPage as Category
        assertEquals(testCategory.returnPagesCount(), 0)

        var testPage2: Page = Recipe("Ramen")
        var ramen: Recipe = testPage2 as Recipe
        testCategory.addPage(ramen)
        assertEquals(testCategory.returnPagesCount(), 1)

        var beefTongue: Recipe = Recipe("Beef tongue")
        testCategory.addPage(beefTongue)
        assertEquals(testCategory.returnPagesCount(), 2)

        var friedRice: Recipe = Recipe("Fried Rice")
        testCategory.addPage(friedRice)
        assertEquals(testCategory.returnPagesCount(), 3)

        testCategory.removePage(beefTongue)
        assertEquals(testCategory.returnPagesCount(), 2)
        testCategory.removePage(ramen)
        assertEquals(testCategory.returnPagesCount(), 1)
        testCategory.removePage(friedRice)
        assertEquals(testCategory.returnPagesCount(), 0)
    }

    @Test
    fun category_returnPages_isCorrect() {
        var testCategory: Category = Category("Dinner")


        var ramen: Recipe = Recipe("Ramen")
        testCategory.addPage(ramen)
        assertEquals(testCategory.returnPage(0), ramen)

        var beefTongue: Recipe = Recipe("Beef tongue")
        testCategory.addPage(beefTongue)
        assertEquals(testCategory.returnPage(0), ramen)
        assertEquals(testCategory.returnPage(1), beefTongue)

        var friedRice: Recipe = Recipe("Fried Rice")
        testCategory.addPage(friedRice)
        assertEquals(testCategory.returnPage(0), ramen)
        assertEquals(testCategory.returnPage(1), beefTongue)
        assertEquals(testCategory.returnPage(2), friedRice)


        testCategory.removePage(beefTongue)
        assertEquals(testCategory.returnPage(0), ramen)
        assertEquals(testCategory.returnPage(1), friedRice)

        testCategory.removePage(ramen)
        assertEquals(testCategory.returnPage(0), friedRice)
        testCategory.removePage(friedRice)
    }
}