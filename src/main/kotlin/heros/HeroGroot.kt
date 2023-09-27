package heros

import deadHeros
import enemy.Enemy
import listHeros
import resetColor

class HeroGroot(
    name: String,
    lp: Int,
    lpStandard: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    attacks: MutableList<AttacksHeros>,
    colorName: String
) : Hero(name, lp, lpStandard, armor, armorReduction, speed, attacks, colorName) {

    fun armorDestroy(enemy : Enemy) {
        val leftArmor : Int = (enemy.armorReduction / 100) * 5

        if (enemy.armorReduction > 50){
            println("${this.colorName}Groot's${resetColor} Äste verlängern sich und reichen bis unter die Rüstung von ${enemy.colorName}${enemy.name}${resetColor}")
            println("Powww! Die Rüstung fliegt in alle Richtungen und ${enemy.colorName}${enemy.name}${resetColor} ist fast Schutzlos!")
            enemy.armorReduction = leftArmor
            println("${enemy.colorName}${enemy.name}${resetColor} hat nur noch ${enemy.armorReduction} Rüstungspunkte")
            println()
        } else if (enemy.armorReduction <= leftArmor && this.lp >= 101) {
            println("${enemy.colorName}${enemy.name}${resetColor} hat keine Rüstung zum zerstören...")
            println("${this.colorName}${this.name}${resetColor} verletzt sich selbst...")
            println("${this.colorName}${this.name}'s${resetColor} Lebenspunkte sinken um 100..")
            this.lp - 100
            println()
        } else {
            println("${enemy.colorName}${enemy.name}${resetColor} hat keine Rüstung zum zerstören...")
            println("${this.colorName}${this.name}${resetColor} verletzt sich selbst...")
            println("${this.colorName}${this.name}'s${resetColor} stirbt...")
            this.lp = 0
            listHeros.remove(this)
            deadHeros.add(this)
            println()
        }
    }
}