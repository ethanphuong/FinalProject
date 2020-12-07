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
}