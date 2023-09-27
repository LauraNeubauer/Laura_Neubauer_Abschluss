package heros

import enemy.Enemy
import resetColor

class HeroPeter(
    name: String,
    lp: Int,
    lpStandard: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    attacks: MutableList<AttacksHeros>,
    colorName: String
) : Hero(name, lp, lpStandard, armor, armorReduction, speed, attacks, colorName) {


    // Lenkt Ronan ab und lässt ihn eine Runde aussetzen
    // Nur einmal möglich
    fun distract(enemy: Enemy){
        println("${this.colorName}${this.name}$resetColor fängt an zu singen:")
        println()
        println("Ooh child, things are gonna get easier\n" +
                "Ooh child, things'll get brighter\n" +
                "Ooh child, things are gonna get easier\n" +
                "Ooh child, things'll get brighter")
        println("Ohhhhhhhhh!!!!")
        println()
        if (!enemy.wasDistracted){
            println("${enemy.colorName}${enemy.name}$resetColor ist abgelenkt und greift nicht an!")
        } else {
            println("${enemy.colorName}${enemy.name}$resetColor ifällt darauf nicht nochmal herein!")
        }
        println()
    }
}