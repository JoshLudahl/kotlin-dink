import java.util.*

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType): Entity {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType.EASY -> type.getFormattedName()
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when (type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}


sealed class Entity() {
    object Help : Entity() {
        val name = "Help!"
    }

    data class Easy(val id: String, val name: String) : Entity()
    data class Medium(val id: String, val name: String) : Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float) : Entity()


}

val Entity.Help.groups: String
    get() = "Totes Info Dude!!!"

fun main() {
    val entity: Entity = EntityFactory.create(EntityType.HELP)
    val message = when (entity) {
        Entity.Help -> "Help class"
        is Entity.Easy -> "Easy Class"
        is Entity.Medium -> "Med class"
        is Entity.Hard -> "hard class"
    }

    println(message)
    val ent1 = Entity.Help
    println(ent1.groups)

}