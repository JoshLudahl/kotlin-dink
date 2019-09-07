interface PersonInfoProvider {
    val providerInfo: String
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printNames()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic Info Provider, Yooo"

    open val sessionIdPrefix = "Session id: fd fwe23faswef332323vcxzcvp"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Goats Rock, Yo")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
    val provider = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "Fish Tacos for days!!!"

        fun getSessionId() = "id"
    }

    provider.printInfo(Person("Marge", "Simpson"))
    println("Session ID: ${provider.getSessionId()}")

    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("Not a session provider")
    } else {
        println("Yup, all good, son!")
        infoProvider.getSessionId()
    }
}