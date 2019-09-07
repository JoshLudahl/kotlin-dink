import com.google.gson.Gson
import java.net.URL

fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if (predicate(it)) {
            println(it)
        }
    }
}


fun main(args: Array<String>) {
    var gson = Gson()
    var API_KEY = API_KEY.getKey()
    var json =
        URL("https://api.openweathermap.org/data/2.5/weather?id=5746545&units=imperial&appid=$API_KEY").readText()
    val currentWeather = gson.fromJson(json, CurrentWeather::class.java)

    println("The current weather is ${currentWeather.weather[0].description} and the temp is ${Math.ceil(currentWeather.main.temp).toInt()} degrees")
    println("The current humidity is ${currentWeather.main.humidity.toInt()}%")
    println("Current wind speed is ${currentWeather.wind.speed.toInt()}MPH")
    val icon = Icons()
    println("icon code is: ${icon.icon("052")}")

    val list = listOf("Kotlin", "JavaScript", "Java", "Bash")
    val mapList: Map<String, String> = mapOf("a" to "he", "b" to "red")

    mapList.forEach { key, value ->
        println("the ${key} and the $value are pretty good")
    }
    val create: (Double, Int, Int) -> String = {x, y, z -> (x.toInt() + y + z).toString()}
    println(create(5.0, 7, 3))

    val message = "Temp status: ${if (Math.ceil(currentWeather.main.temp).toInt() > 80) "It's Hot!" else "it's not hot yet" }"

    println(message)

    println("${args[0]} and ${args[1]}")
}

class Value() {
    companion object fighter {
        var score = 50

        fun reduceScore() {
            score--
        }
    }
}


