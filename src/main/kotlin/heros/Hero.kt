package heros
import enemy.Enemy
import resetColor

// Ober-Klasse der Helden
// Name der Helden
// Lebenspunkte welche mutabel sind
// Lebenspunkte nicht mutabel für Berechnungen
// Rüstungspunkte Standartwert zum Berechnen
// Rüstungspunkte welche abgezogen werden falls über 0
// Schnelligkeit der Helden (Ausschlaggebend für Reihenfolge im Kampf)
// Attacken der Gegner
// Farben der Gegner
open class Hero(
    var name: String,
    var lp: Int,
    var lpStandard: Int,
    var armor: Int,
    var armorReduction: Int,
    var speed: Int,
    var attacks: MutableList<AttacksHeros>,
    val colorName: String
) {

    // Simple Attacke mit vorgegebenen Schadenspunkte welche in der MainKt initialisiert wird
    // zieht je nach höhe der Rüstungspunkte Lebenspunkte ab
    // Je höher die Rüstungspunkte dessto geringer der Schaden auf die Lebenspunkte
    fun attackEnemy(enemy: Enemy, attacke: AttacksHeros, dead: MutableList<Enemy>, inFight: MutableList<Enemy>) {
        // Schadenspunkte übersteigen die Lebenspunkte -> Held ist tot
        // wird von der Liste der kämpfenden Gegnern übertragen in die Liste der toten Gegner
        if (attacke.damage!! > enemy.lp) {
            println("${this.colorName}${this.name} hat ${attacke.name} angewand und damit $resetColor${enemy.colorName}${enemy.name} ${this.colorName}besiegt$resetColor")
            println("${enemy.colorName}${enemy.name} ist besiegt!$resetColor")
            enemy.lp = 0
            println()
            dead.add(enemy)
            inFight.remove(enemy)
        // Wenn gegner noch Rüstungspunkte hat:
        // Ausgabe der Rüstungspunke unabhängig vom Schaden
        } else {
            val remainingArmorPercent = if (enemy.armor != 0) (enemy.armorReduction * 100) / enemy.armor else 0
            if (remainingArmorPercent > 0) {
                println("${enemy.colorName}${enemy.name}${resetColor} hat $remainingArmorPercent % Rüstung")
            }
            // Wenn der Gegner zwischen 90 und 100 % der Rüstung hat
            if (remainingArmorPercent in 90..100) {
                val realDamage = (attacke.damage!! / 100) * 10
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 80 und 90 % der Rüstung hat
            } else if (remainingArmorPercent in 80..90) {
                val realDamage = (attacke.damage!! / 100) * 20
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 70 und 80 % der Rüstung hat
            } else if (remainingArmorPercent in 70..80) {
                val realDamage = (attacke.damage!! / 100) * 30
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 60 und 70 % der Rüstung hat
            } else if (remainingArmorPercent in 60..70) {
                val realDamage = (attacke.damage!! / 100) * 40
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 50 und 60 % der Rüstung hat
            } else if (remainingArmorPercent in 50..60) {
                val realDamage = (attacke.damage!! / 100) * 50
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 40 und 50 % der Rüstung hat
            } else if (remainingArmorPercent in 40..50) {
                val realDamage = (attacke.damage!! / 100) * 60
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 30 und 40 % der Rüstung hat
            } else if (remainingArmorPercent in 30..40) {
                val realDamage = (attacke.damage!! / 100) * 70
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 20 und 30 % der Rüstung hat
            } else if (remainingArmorPercent in 20..30) {
                val realDamage = (attacke.damage!! / 100) * 80
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 10 und 20 % der Rüstung hat
            } else if (remainingArmorPercent in 10..20) {
                val realDamage = (attacke.damage!! / 100) * 90
                enemy.armorReduction -= attacke.damage!!
                enemy.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen unter 10 % der Rüstung hat
            } else if (remainingArmorPercent < 10) {
                // restliste Rüstungspunkte werden auf 0 gesetzt
                enemy.armor = 0
                // volle Schadenspunkte werden nun von Lebenspunkten abgezogen
                enemy.lp -= attacke.damage!!
                println("${enemy.colorName}${enemy.name}$resetColor hat keine Rüstung mehr! ${this.colorName}${this.name}'s${resetColor} Attacke macht nun mehr Schaden auf die Lebenspunkte!")
                println("${this.colorName}${this.name}${resetColor}  hat ${attacke.name} angewand!")
                println("${enemy.colorName}${enemy.name} ${resetColor}verliert ${attacke.damage} Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            }
        }
    }
}
