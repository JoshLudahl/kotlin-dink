import java.util.*

open class Person(var firstName: String, var lastName: String) {

    private var nickName: String? = null
    private val ssn: Int = 221
    private val aged: Int = 35

    fun createNickName(nickName: String?) {
        this.nickName = nickName
    }

    fun printNames() {
        val nicknameCheck: String = nickName ?: "CoolGuy"
        println("Hello $firstName, the $nicknameCheck, is your last name $lastName?")
    }


    fun numberCheck(): Boolean {

        if (ssn == aged) {
            println("fool")
            return true
        } else {
            return false
        }
    }
}

class Employee(person: Person, val uuid: UUID) {

    constructor(person: Person, uuid: UUID, who: String) : this(person, uuid) {
        println(who)
    }

    init {
        println("initializing...")
        println("initialization complete.")
    }


}

class Persons(val name: String) : User {
    override var nickName: String = name
        set(value: String) {
            println("Changing $nickName to $value")
            field = value
        }

    var children: MutableList<Persons> = mutableListOf<Persons>();

    constructor(name: String, parent: Persons) : this(name) {
        parent.children.add(this)
    }
}

interface User {
    val nickName: String
}

class Compject {
    companion object Goat {
        fun create(int: Int) {
            println("A companion object ${int}")
        }
    }
}


fun main() {
    Compject.create(9)
    var peeps = Person("Jason", "Smith")
    val john = Persons("Joshy")
    println("Johns nickname is ${john.nickName}")
    john.nickName = "Snags"
    println("Johns nickname is ${john.nickName}")
    val emp = Employee(peeps, UUID.randomUUID())
    println("${peeps.firstName} ${peeps.lastName} has the id of: ${emp.uuid}")

}