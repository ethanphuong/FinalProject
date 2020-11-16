 > As you complete each section you **must** remove the prompt text. Every *turnin* of this project includes points for formatting of this README so keep it clean and keep it up to date. 
 > Prompt text is any lines beginning with "\<"
 > Replace anything between \<...\> with your project specifics and remove angle brackets. For example, you need to name your project and replace the header right below this line with that title (no angle brackets). 
# Cooking by the Book
 > Your author list below should include links to all members GitHub and should begin with a "\<" (remove existing author).
 
 > Authors: [Brandon Tran](https://github.com/bran-dont), [Ethan Phuong](https://github.com/ethanphuong), [Vy Vo](https://github.com/vyvanvo)
 
 > You will be forming a group of **THREE** students and work on an interesting project that you will propose yourself (in this `README.md` document). You can pick any project that you'd like, but it needs ot implement three design patterns. Each of the members in a group is expected to work on at least one design pattern and its test cases. You can, of course, help each other, but it needs to be clear who will be responsible for which pattern and for which general project features.
 
 ## Expectations
 > * Incorporate **three** distinct design patterns, *two* of the design patterns need to be taught in this course:
 >   * Composite, Strategy, Abstract Factory, Visitor
 > * All three design patterns need to be linked together (it can't be three distinct projects)
 > * Your project should be implemented in C/C++. If you wish to choose anoher programming language (e.g. Java, Python), please discuss with your lab TA to obtain permission.
 > * You can incorporate additional technologies/tools but they must be approved (in writing) by the instructor or the TA.
 > * Each member of the group **must** be committing code regularly and make sure their code is correctly attributed to them. We will be checking attributions to determine if there was equal contribution to the project.

## Project Description
 > * Our application is designed to help cooks store their many recipes in one organized area. Each cook has their own way of remembering their recipes: some remember them by heart, others use online resources to find them. However, with our digitalized cookbook, every cook can now keep their recipes in one place as well as add recipes easily, without having to go through the trouble of creating a physical book or constantly searching for the recipe that they found online.
 > * We will be using Kotlin and AndroidStudio in order to implement our project.
 >   * [AndroidStudio](https://developer.android.com/studio/) - AndroidStudio is an IDE that can be used to create Android applications, as well as test them quickly using their phone emulator feature. 
 > * Our application will take a user input of recipes (ingredients, instructions, images) and output a large collection of recipes as a cookbook. This cookbook will have categories and labels that will allow the user to search for and access desired recipes easily. The cookbook can also be output as a smaller list of specific recipes based on how the user filters the cookbook.
 > * Our project will use the Composite, Abstract Factory, and Iterator design patterns:
 >   * Composite – We chose to implement Composite because of the structure of our classes. With a digital cookbook, we will have pages that can act either as directories to recipes, or the recipes themselves. Due to this recursive nature, implementing the Composite design structure will be beneficial now and if we need to add more layers of recursion in the future.  For example, if we later want to group all Asian foods, we can create a new directory (and thus a new layer of recursion) to group all Asian foods (Thai, Vietnamese, etc).
 >   * Strategy - We chose to implement Strategy because we want to be able to compile a customized list based on different stategies. For a person using this app, having a compiled list of recipes based on the recipes' tags, recipes' ingredients, or recipes' title would give them a variety of options based on the keyword they chose. For instance, we can compile a list of all lunch food for the user, or a list that has all food with eggs, depending on the user’s specifications. 
 >   * Iterator - We chose to implement Iterator because we are storing our recipes into a tree structure. We decided that it would be best to use an iterator to traverse the tree in order to delegate the duty of data traversal to another class, rather than implementing multiple traversal methods in our code. In addition, implementing the Iterator design pattern will allow us to utilize multiple traversal methods such as breadth-first search and depth-first search. The Iterator design pattern will also help users search through their recipes when they are filtering the entire cookbook by tags/labels (such as eggs, gluten-free, vegan, etc).
 > * This description should be in enough detail that the TA/instructor can determine the complexity of the project and if it is sufficient for the team members to complete in the time allotted. 

 ## Phase II
 > In addition to completing the "Class Diagram" section below, you will need to 
 > * Set up your GitHub project board as a Kanban board for the project. It should have columns that map roughly to 
 >   * Backlog, TODO, In progress, In testing, Done
 >   * You can change these or add more if you'd like, but we should be able to identify at least these.
 > * There is no requirement for automation in the project board but feel free to explore those options.
 > * Create an "Epic" (note) for each feature and each design pattern and assign them to the appropriate team member. Place these in the `Backlog` column
 > * Complete your first *sprint planning* meeting to plan out the next 7 days of work.
 >   * Create smaller development tasks as issues and assign them to team members. Place these in the `Backlog` column.
 >   * These cards should represent roughly 7 days worth of development time for your team, taking you until your first meeting with the TA
## Class Diagram
 > Include a class diagram(s) for each design pattern and a description of the diagram(s). This should be in sufficient detail that another group could pick up the project this point and successfully complete it. Use proper OMT notation (as discussed in the course slides). You may combine multiple design patterns into one diagram if you'd like, but it needs to be clear which portion of the diagram represents which design pattern (either in the diagram or in the description). 
 
 > ![Cookbook class diagram](https://github.com/cs100/final-project-ephuo001-btran117-vvo025/blob/master/Cookbook.png?raw=true)
 
 > The cookbook has pages that are either categories or recipes. The category will have a list of pages which is how we will implement the composite pattern. It also has a strategy pattern to compile a list based on the user's specification. There are three different strategies for compiling a list base on tags, ingredients, and title. The cookbook also has a page iterator that iterates through each page or go back to the previous page in the cookbook.
 
 ## Phase III
 > You will need to schedule a check-in with the TA (during lab hours or office hours). Your entire team must be present. 
 > * Before the meeting you should perform a sprint plan like you did in Phase II
 > * In the meeting with your TA you will discuss: 
 >   - How effective your last sprint was (each member should talk about what they did)
 >   - Any tasks that did not get completed last sprint, and how you took them into consideration for this sprint
 >   - Any bugs you've identified and created issues for during the sprint. Do you plan on fixing them in the next sprint or are they lower priority?
 >   - What tasks you are planning for this next sprint.

 ## Final deliverable
 > All group members will give a demo to the TA during lab time. The TA will check the demo and the project GitHub repository and ask a few questions to all the team members. 
 > Before the demo, you should do the following:
 > * Complete the sections below (i.e. Screenshots, Installation/Usage, Testing)
 > * Plan one more sprint (that you will not necessarily complete before the end of the quarter). Your In-progress and In-testing columns should be empty (you are not doing more work currently) but your TODO column should have a full sprint plan in it as you have done before. This should include any known bugs (there should be some) or new features you would like to add. These should appear as issues/cards on your Kanban board. 
 ## Screenshots
 > Screenshots of the input/output after running your application
 ## Installation/Usage
 > Instructions on installing and running your application
 ## Testing
 > How was your project tested/validated? If you used CI, you should have a "build passing" badge in this README.
 
