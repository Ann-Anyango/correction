fun main() {

    val gazelle = Prey("Gazelle", "Herbivore", 10, "No migration")

    val result1 = lion.huntPrey(zebra)
    val result2 = lion.huntPrey(gazelle)

    println(result1)
    println(result2)


    val africanCuisine = AfricanCuisine()
    val moroccanRecipe = MoroccanRecipe(
        "Tagine",
        listOf("Chicken", "Onions", "Spices"),
        60,
        "Slow cooking",
        "High in protein",
        "Ras el Hanout"
    )
    val ethiopianRecipe = EthiopianRecipe(
        "Doro Wat",
        listOf("Chicken", "Onions", "Berbere spice"),
        90,
        "Stewing",
        "Spicy and flavorful",
        "Medium"
    )
    val nigerianRecipe = NigerianRecipe(
        "Jollof Rice",
        listOf("Rice", "Tomatoes", "Peppers"),
        45,
        "One-pot cooking",
        "Delicious and filling",
        "Easy"
    )
    africanCuisine.addRecipe(moroccanRecipe)
    africanCuisine.addRecipe(ethiopianRecipe)
    africanCuisine.addRecipe(nigerianRecipe)
    africanCuisine.displayRecipes()

    val student1 = Student("John Doe", 18, listOf(80, 75, 90))
    val student2 = Student("Jane Doe", 19, listOf(70, 85, 65))

    println("Student 1 information:")
    student1.displayStudentInformation()
    println("Student 1 has passed: ${student1.hasPassed()}")

    println("Student 2 information:")
    student2.displayStudentInformation()
    println("Student 2 has passed: ${student2.hasPassed()}")

}


open class Species(val name: String, val diet: String, val lifespan: Int)

class Predator(name: String, diet: String, lifespan: Int, val huntingStyle: String) : Species(name, diet, lifespan) {
    fun huntPrey(prey: Prey): String {
        println("The $name is hunting the ${prey.name}!")
        return if (prey.diet == "Herbivore") {
            "The $name successfully hunted the ${prey.name}!"
        } else {
            "The $name couldn't hunt the ${prey.name} because it's not a herbivore!"
        }
    }
}

class Prey(name: String, diet: String, lifespan: Int, val migrationPattern: String) : Species(name, diet, lifespan)

val lion = Predator("Lions", "Carnivorous", 15, "Ambush hunting")
val zebra = Prey("Zebra", "Herbivore", 20, "Seasonal migration")



open class Recipe(
    val name: String,
    val ingredients: List<String>,
    val preparationTime: Int,
    val cookingMethod: String,
    val nutritionalInfo: String
) {
    open fun getDetails(): Map<String, Any> {
        return mapOf(
            "Name" to name,
            "Ingredients" to ingredients.joinToString(", "),
            "Preparation Time" to "$preparationTime minutes",
            "Cooking Method" to cookingMethod,
            "Nutritional Information" to nutritionalInfo
        )
    }
}

class MoroccanRecipe(
    name: String,
    ingredients: List<String>,
    preparationTime: Int,
    cookingMethod: String,
    nutritionalInfo: String,
    val specialIngredient: String
) : Recipe(name, ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    override fun getDetails(): Map<String, Any> {
        val details = super.getDetails().toMutableMap()
        details["Special Ingredient"] = specialIngredient
        return details
    }
}

class EthiopianRecipe(
    name: String,
    ingredients: List<String>,
    preparationTime: Int,
    cookingMethod: String,
    nutritionalInfo: String,
    val spiceLevel: String
) : Recipe(name, ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    override fun getDetails(): Map<String, Any> {
        val details = super.getDetails().toMutableMap()
        details["Spice Level"] = spiceLevel
        return details
    }
}

class NigerianRecipe(
    name: String,
    ingredients: List<String>,
    preparationTime: Int,
    cookingMethod: String,
    nutritionalInfo: String,
    val complexityLevel: String
) : Recipe(name, ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    override fun getDetails(): Map<String, Any> {
        val details = super.getDetails().toMutableMap()
        details["Complexity Level"] = complexityLevel
        return details
    }
}

class AfricanCuisine {
    private val recipes = mutableListOf<Recipe>()

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun displayRecipes() {
        for (recipe in recipes) {
            val details = recipe.getDetails()
            for ((key, value) in details) {
                println("$key: $value")
            }
            println()
        }
    }
}
class Student(val name: String, val age: Int, val grades: List<Int>) {
    fun calculateAverageGrade(): Double = grades.sum()
    fun displayStudentInformation() {
        println("Name: $name")
        println("Age: $age")
        println("Grades: $grades")
        println("Average grade: ${calculateAverageGrade()}")
    }
    fun hasPassed(): Boolean = calculateAverageGrade() >= 60
}





