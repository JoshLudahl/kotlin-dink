fun main(args: Array<String>) {

    val greeting: Greeting = Greeting("Josh", "cat")

    //  a list
    var catList = mutableListOf("Spud", "Tedward", "Hightops", "Jazzie")

    fun sayGreeting(greeting: String, cats:List<String>) {
        cats.forEach {item ->
            println("$greeting from $item")
        }
    }

    sayGreeting("hello", catList)

    for (cat in catList) {
        println(cat)
    }
    catList.forEach { cat ->
        println(cat)
    }

    catList.forEachIndexed { index, cat ->
        println("The cat ${cat.replace("Spud", "the bud")} is at index $index")
    }

    //  repeat
    repeat(catList.size) {println(catList[it])}
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    var goat = spices.filter { it.contains("curry") }.sortedByDescending { it.length }


    var snift = {int:Int -> int*2}
    println(snift(9))
    var snift2: (Int) -> Int = {it*2}
    println(snift2(9))
    println(goat)
    //  COLLECTIONS
    var map = mapOf("arm" to "fish", 1 to "hah", "goat" to "noise")

    map.forEach { key, value -> println("The key ($key) and value ($value) is good") }

    println(greeting.packageAndReturnGreeting())

    //  CLASSES
    val person = Person("Billy", "Bob")
    person.createNickName("FatMan2000")

    person.printNames()
    println(person.numberCheck())
    //INTERFACES

}