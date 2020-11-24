package com.example.cookingbythebook.strategypackage

import com.example.cookingbythebook.compositepackage.Page
import com.example.cookingbythebook.compositepackage.Recipe

interface CompileStrategy {
    fun compileList(page: Page, input: String)
}

class TagCompileStrategy : CompileStrategy {
    override fun compileList(page: Page, _tagInput: String) {
        //create a new list with the user's input for tags
        var tagRecipeList = ArrayList<Page>();

        //initialize temporary tagInput
        var tagInput: String = _tagInput

        //to lower tagInput string
        tagInput = tagInput.toLowerCase()

        //iterate through each page in the cookbook to grab information
        while (page != null) {
            //check if page is a recipe
            if (page is Recipe) {

                //get size of recipe's tagsList
                val tagsListCount: Int = page.returnTagsCount();

                //iterate through tag vector in a recipe page
                for (i in 0 until tagsListCount) {
                    // get tag at an index
                    var tag: String = page.returnTag(i)

                    //to lower tag string
                    tag = tag.toLowerCase()

                    //compare recipe's tag to user's input
                    if (tag == tagInput) {
                        tagRecipeList.add(page)
                    }
                }
            }

            page.getNext(); //get next page
        }
    }
}

class TitleCompileStrategy : CompileStrategy {
    override fun compileList(page: Page, _titleInput: String) {
        //create a new list with the user's input for title
        var titleRecipeList = ArrayList<Page>();

        //initialize temporary titleInput
        var titleInput = _titleInput;

        //length of titleInput string
        var titleInputLength: Int = titleInput.count();

        //to lower titleInput
        titleInput = titleInput.toLowerCase();

        //iterate through each page in the cookbook to grab information
        while (page != null) {
            //check if page is a recipe
            if (page is Recipe) {

                //page's recipe's title
                var title: String = page.returnTitle();

                //to lower title
                title = title.toLowerCase();

                //compare recipe's title to user's input
                if (title.contains(titleInput)) {
                    titleRecipeList.add(page);
                }
            }

            page.getNext(); //get next page
        }
    }
}

class IngredientsCompileStrategy : CompileStrategy {
    override fun compileList(page: Page, _ingredientInput: String) {
        //create a new list with the user's input for ingredients
        var ingredientRecipeList = ArrayList<Page>();

        //initialize temporary ingredient
        var ingredientInput: String = _ingredientInput

        //to lower ingredientInput string
        ingredientInput = ingredientInput.toLowerCase()

        //iterate through each page in the cookbook to grab information
        while (page != null) {
            //check if page is a recipe
            if (page is Recipe) {

                //get size of recipe's ingredientsList
                var ingredientsListCount: Int = page.returnIngredientsCount();

                //iterate through each ingredients in the recipe
                for (i in 0 until ingredientsListCount) {
                    //get ingredient at an index
                    var ingredient: String = page.returnIngredient(i)

                    //to lower ingredient string
                    ingredient = ingredient.toLowerCase()

                    //compare recipe's ingredients to user's input
                    if (ingredient == ingredientInput) {
                        ingredientRecipeList.add(page)
                    }
                }

                page.getNext();
            }
        }
    }
}