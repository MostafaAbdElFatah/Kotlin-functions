import java.util.*

fun main(args: Array<String>){

    val hour = "12".toInt() //args[0].toInt()
    if (hour < 12)
        print("Good morning, Kotlin")
    else
        print("Good night, Kotlin")

    println("${if ("10".toInt() < 12) "Good Morning Kotlin" else "Good Night Kotlin"}")
    dayOfWeek()
    feedTheFish()
    println("\nYour fortune is: ${getFortune()}")
    println(whatShouldIDoToday(mood = "happy"))
    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel?")
    println(whatShouldIDoToday(readLine()!!))
    var fortune: String = ""
    while (!fortune.contains("Take it easy")) {
        fortune = getFortune()
        println("\nYour fortune is: $fortune")
    }

    repeat (10) {
        fortune = getFortune()
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy"))
            return
    }
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    // Create a filter that gets all the curries and sorts them by string length.
    var result = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println(result)
    //Filter the list of spices to return all the spices that start with 'c' and end in 'e'. Do it
    result = spices.filter{it.startsWith('c')}.filter{it.endsWith('e')}
    println(result)
    result = spices.filter { it.startsWith('c') && it.endsWith('e') }
    println(result)
    result = spices.filter { it[0] == 'c' && it[it.length - 1 ] == 'e' }
    println(result)
    // Filtering the first 3 items by 'c'
    result = spices.take(3).filter{it.startsWith('c')}
    println(result)
    doOperation()
}
var dirty = 20
var waterFilter :(Int)->Int = { localDirty -> localDirty / 2}
fun fishFeed(localDirty:Int) = localDirty + 40
fun updateDirty(localDirty:Int , operation:(Int)->Int):Int{
    return operation(localDirty)
}
fun doOperation() {
    println("Dirty :$dirty")
    dirty = updateDirty(dirty,waterFilter)
    println("Dirty :$dirty")
    dirty = updateDirty(dirty,::fishFeed )
    println("Dirty :$dirty")
    dirty = updateDirty(dirty){localDirty -> localDirty + 50 }
    println("Dirty :$dirty")
    dirty = updateDirty(dirty, { localDirty -> localDirty + 80 })
    println("Dirty :$dirty")

}

fun isVeryHot (temperature: Int) = temperature > 35
fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
        mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    return when {
        isVeryHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHappySunny(mood, weather) -> "go for a walk"
        else -> "Stay home and read."
    }
}
/**
fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24) : String {
    return when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        else -> "Stay home and read."
    }
}
*/
fun getFortune() : String {
    val fortunes = listOf( "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends, because they are your greatest fortune.")
    print("\nEnter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    return fortunes[birthday.rem(fortunes.size)]
}

fun feedTheFish() {
    //val day = randomDay()
    val food = "pellets"
    println("Today is ${randomDay()} and the fish eat $food")
    println("Today is ${randomDay()} and the fish eat $food")
}

fun randomDay () :String  {
    var days = listOf("Sunday","Monday","Tuesday" ,"Wednesday","Thursday","Friday","Saturday")
    return days[Random().nextInt(7)]
}

fun dayOfWeek(){
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println( when (day) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped"
    })
}