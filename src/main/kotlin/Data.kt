import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import java.net.HttpURLConnection
import java.net.URL

val url = "https://jsonplaceholder.typicode.com/users"

fun sendGet() {
    val url = URL(url)

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET

        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

        inputStream.bufferedReader().use {
            it.lines().forEach { line ->
                println(line)
            }
        }
    }
}

fun sendGet2() {
    val str = URL(url).readText()
    val str2 = """  {
    "word": "word",
    "label": "label"
  },
  {
    "word": "word2",
    "label": "label2"
  }"""
    val parser: Parser = Parser.default()
    val stringBuilder: StringBuilder = StringBuilder(str)

    val json: JsonArray<String> = parser.parse(stringBuilder) as JsonArray<String>
    println("Name : ${json.string("id".toString())}, Age : ${json.int("label").toString()}")

// Prints: Ages: JsonArray(value=[20, 25, 38])
}

open class Goat(num: Int) {
    open fun fish() {
        println("oh, hey")
    }
}

class Goater(numbers: Int) : Goat(numbers) {
    override fun fish() {
        super.fish()
        println("fish now, son!")
    }
}

fun main() {
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        println(x)
    }

    val <T> dog: List<String> = listOf("fish", "Apples")
    dog.forEach { item -> println(item) }
    val goat = Goater(1)
    goat.fish()
    sendGet2()
}
