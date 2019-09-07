data class Fish(var name: String)

fun main() {
    fishExamples()

}

fun fishExamples() {
    val fish = Fish("splashy")
    val fish2 = Fish("crashy")
    println(fish2.snam(fish2.name))

    with (fish.name) {
        capitalize()
    }

    myWith(fish.name) {
        capitalize().also { println(it) }
    }
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun listCreateor(): List<Fish> {
    return mutableListOf<Fish>(Fish("Trout"), Fish("Salmon"), Fish("Shark"), Fish("Sturgeon"))
}

fun Fish.snam(string: String): String {
    return name.capitalize()
}
