## SWEN 383 - Software Design Principles and Patterns

## NUTRiAPP Business Requirements

The purpose of the project is to build skills in developing and managing the software engineering process with special attention to design process. The project is sufficiently complex to demonstrate most of the software development lifecycle phases and will not burden the development team with a lot of programming and testing efforts.  The following sections categorize the business requirements for the intended NUTRiAPP.

 

### A. Functional Requirements

1. A user may enter statistics about themselves including:
     - Name
     - Height
     - Weight
     - Birth-date - this is used to calculate the user's age
     
2. The user may choose from one of several different goals.

     - Maintain Weight - sets a target number of calories so that the user maintains their current weight.
     - Lose weight - sets a target number of calories based on the user's stats such that they lose an average of 1-2 pounds per week until reaching a target weight goal.
     - Gain weight - sets a target number of calories based on the user's stats such that they gain an average of 1-2 pounds per week until reaching a target weight goal.

     - The user may choose to combine maintaining/losing/gaining weight with improving physical fitness; this will adjust the target calories per day based on the recommended amount of exercise and the user's weight goal.
      
3. In some circumstances, the app will automatically transition from one goal to another:

     - When reaching a target weight goal, the app will transition from lose/gain weight to maintaining weight.
      
     - If the user's weight changes by +/-5 or more pounds, the app will transition from the maintain weight goal to the lose/gain weight goals respectively.

4. The app will keep track of various forms of food. All food has the following properties:

     - A name.
     - A number of calories per unit (e.g., per gram or per fluid ounce).
     - Grams of fat, protein, fiber, and carbohydrates per unit.
     
5. Ingredients are the most basic food type. In addition to the basic properties above, ingredients also have an amount in stock (e.g., grams or fluid ounces).

     - The app will maintain a searchable database of ingredients.
     - The stock of any ingredient is 0 unless the user indicates that they have purchased some amount of the ingredient.
     
6. Recipes are also a type of food. The user may create a new recipe by specifying:

     - A unique name for the new recipe.
     - The ingredients (and amount of each) required to make the recipe.
     - The preparation instructions for the recipe.
     
7. Meals are also a type of food. The user may create a meal by specifying:

     - A unique name for the meal.
     - The recipes included in the meal, e.g., salad, soup, entree, dessert, etc.
     
8. The app helps users to prepare meals when the user chooses recipes to combine.

     - The user is guided through the steps to prepare each recipe.
     - Ingredients are automatically deducted from the current stock.
     - Calories are automatically deducted from the user's daily target.
     - The user is warned if they try to prepare a meal, but the ingredients are not in stock or if they will exceed their daily target of calories by consuming the meal.
     
9. The app helps users to create shopping lists based on specific criteria:

     - Ingredients that are low in stock/out of stock
     - Ingredients required by a specific recipe such that are low/out of stock
     - Additional criteria may be added in a future release
     
10. The app allows users to track workouts (which add calories to the daily target) including:

     - A whole number of minutes
     - Intensity
     - High: 10 calories/minute
     - Medium: 7.5 calories/minute (rounded down)
     - Low: 5 calories/minute
     - The time/date of the exercise is recorded automatically at the time of entry.
     
11. If the user exceeds their daily target for calories, the app will suggest an amount of exercise based on their previously recorded workouts. For example, if the user is 100 calories over their target and typically does low-intensity workouts, the app will suggest that the user exercise at low intensity for 20 minutes to burn the excess calories.

12. The user may browse their personal history including:

     - Weight
     - Calories consumed vs. target for that day
     - Meals
     - Workouts
     
13. At the beginning of each day, the user's previous daily activity should be saved to their history and the user should be prompted to enter their current weight.

### B. Non-Functional Requirements

The application must provide a plain text user interface (PTUI) through which a user may interact with the application using simple, menu-driven commands.

The user's profile must be stored persistently between restarts of the application.
You have been provided with a database of available ingredients in CSV format. The database contains much more information than is necessary to store in the user's stock of ingredients. The user should be able to search the database for ingredients to add to their stock and/or recipes.
Any OO programming language may be used for implementation.
