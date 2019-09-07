

class Greeting {
    private var name: String? = ""
    private  var animal: String? = ""

    constructor(name: String, animal: String) {
        this.name = name
        this.animal = animal
    }

    fun packageAndReturnGreeting(): String {

        return when (name) {
            null-> "Who are you, even?"
            "" -> "no name, eh?"
            else->"Hello ${this.name}, welcome to the dog and ${animal} show!"

        }
    }
}