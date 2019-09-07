import java.lang.StringBuilder

object Joat : Snopp {

    fun sniffs() {
        println("I sniffs.")
    }

    val sum = {x: Int, y: Int -> x + y}

}

interface Snopp

data class Names(val name: String, val age: Int) {
    fun reverse(str: String): String = str.reversed()
}

class Fosh {
    fun double(vararg ts:String) = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        for (element in ts) {
            append("/$element")
        }
        toString()
    }

    fun vol() = StringBuilder("JOSHY").apply {
        for (number in 1..10) {
            append(number)
        }
    }
}

fun main() {

    val people = listOf(Names("Joshy", 38), Names("Jo", 31))

    val minAge = people.minBy { it.age }
    val maxAge = people.maxBy { it.age }

    val aver = (minAge?.age!! + maxAge?.age!!) / 2

    println("average age: $aver")
    println(people.minBy { it.age })
    println(people.sumBy { it.age })
    println(people.joinToString(", ") { it.name })
    var ages = people.filter { it.age < 33 }.map { it.name }
    println(ages).apply { println("See???") }

    val fish = Fosh()
    println(fish.double("a", "b", "c"))
    println(fish.vol())
}