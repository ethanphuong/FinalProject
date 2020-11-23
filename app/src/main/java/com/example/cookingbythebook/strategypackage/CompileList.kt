package com.example.cookingbythebook.strategypackage

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
        tagInput = tagInput.toLowerCase();

        //iterate through each page in the cookbook to grab information
        while (page != null) {
            //initialize temporary page's tagList
            var tagsList: ArrayList<String> = page.getTags() // initializing tag ArrayList

            //iterate through tag vector in a recipe page
            for (tag in tagsList) {
                //compare recipe's tag to user's input
                if (tag == tagInput) {
                    tagRecipeList.add(page)
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
            //page's recipe's title
            var title: String = page.title;

            //length of page's title
            var titleLength: Int = title.count();

            //to lower title
            title = title.toLowerCase();

            //compare recipe's title to user's input
            if (title.contains(titleInput)) {
                titleRecipeList.add(page);
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

        //iterate through each page in the cookbook to grab information
        while (page != null) {
            //initialize temporary page's ingredientsList
            var ingredientsList: ArrayList<String> = page.getIngredients();

            //iterate through each ingredients in the recipe
            for (ingredient in ingredientsList) {
                //compare recipe's ingredients to user's input
                if (ingredient == ingredientInput) {
                    ingredientRecipeList.add(page)
                }
            }

            page.getNext();
        }
    }
}