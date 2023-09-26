package Heros

import Enemy.Enemy

open class Hero(
    var name: String,
    var lp: Int,
    var lpStandart: Int,
    var armor: Int,
    var armorReduction: Int,
    var speed: Int,
    var attacks: MutableList<AttacksHeros>,
) {
    fun attackEnemy(enemy: Enemy, attacke: AttacksHeros, dead: MutableList<Enemy>, inFight: MutableList<Enemy>) {
        if (attacke.healOrdamage!! > enemy.lp) {
            println("${this.name} hat ${attacke.name} angewand und damit ${enemy.name} besiegt")
            println("${enemy.name} ist besiegt!")
            enemy.lp = 0
            println()
            dead.add(enemy)
            inFight.remove(enemy)
        } else {
            val remainingArmorPercent = if (enemy.armor != 0) (enemy.armorReduction * 100) / enemy.armor else 0
            if (remainingArmorPercent > 0) {
                println("${enemy.name} hat $remainingArmorPercent % Rüstung")
            }
            if (remainingArmorPercent in 90..100) {
                val realDamage = (attacke.healOrdamage!! / 100) * 10
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 80..90) {
                val realDamage = (attacke.healOrdamage!! / 100) * 20
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 70..80) {
                val realDamage = (attacke.healOrdamage!! / 100) * 30
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 60..70) {
                val realDamage = (attacke.healOrdamage!! / 100) * 40
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 50..60) {
                val realDamage = (attacke.healOrdamage!! / 100) * 50
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 40..50) {
                val realDamage = (attacke.healOrdamage!! / 100) * 60
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 30..40) {
                val realDamage = (attacke.healOrdamage!! / 100) * 70
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 20..30) {
                val realDamage = (attacke.healOrdamage!! / 100) * 80
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 10..20) {
                val realDamage = (attacke.healOrdamage!! / 100) * 90
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent < 10) {
                enemy.armor = 0
                enemy.lp -= attacke.healOrdamage!!
                println("${enemy.name} hat keine Rüstung mehr! ${this.name}'s Attacke macht nun mehr Schaden auf die Lebenspunkte!")
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
                println()
            }
        }
    }
}
