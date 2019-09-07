fun main() {
    genericExample()
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() = apply { needsProcessed = false }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() = apply { needsProcessed = false }
}

class Aquarium<T : WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessed) { "water supply needs processed" }
        println("adding water from $waterSupply")
    }

    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}
fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

fun genericExample() {
    val aquarium: Aquarium<TapWater> = Aquarium(TapWater())
    aquarium.hasWaterSupplyOfType<TapWater>()
}



