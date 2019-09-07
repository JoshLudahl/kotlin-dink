interface Wheel {
    var diameter: Double
    var width: Double
}

data class Car(override var diameter: Double, override var width: Double) : Wheel

class WheelFactory {
    companion object MakeWheel {
        fun makeCar(diameter: Double, width: Double): Wheel {
            return Car(diameter, width)
        }
    }
}

fun main() {
    var newWheel = WheelFactory.makeCar(9.0, 10.0)
    println("The diameter is ${newWheel.diameter} and the width is ${newWheel.width}")
    println(newWheel)
    var wheelFactory = WheelFactory
    var goats = wheelFactory.makeCar(9.1, 8.0)
    var snips = wheelFactory.makeCar(7.0, 10.0)

    println(goats)
    println(snips)
}