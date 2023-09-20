package Enemy

import Heros.Attacke_Heros
import Heros.Hero

open class Enemy(
    var name : String,
    var lp : Int,
    var lpStandart : Int,
    var armor : Int,
    var armorReduction : Int,
    var speed : Int,
    var weakness : String,
    var attaken : MutableList<Attacke_Enemys> = mutableListOf()
) {
    fun HammerSchockWelle( heroes : List<Hero>) {
        for ( hero in heroes ) {
            var damage : Int? = this.attaken[0].healOrDamage
            println("${this.name} hat ${hero.name} um 300 Lebenspunkte verletzt!!")
            println("${hero.name} hat noch ${hero.lp} Lebenspunkte")
            hero.lp -= damage!!
        }
    }
    fun Packen( hero: Hero) {

    }

    //Eine Aktion ist ein Fluch oder Ähnliches. Dieser soll maximal einen der Helden
    //betreffen und von diesem Helden solange die HP um 10% pro Runde verringeren, bis
    //die HP des entsprechenden Helden weniger als 20% seiner gesamten HP beträgt.

    fun Beschwören () {

    }
    fun attacke_simple( hero: Hero , attacke: Attacke_Heros) {
        if (attacke.healOrdamage > hero.lp) {
            hero.lp = 0
            println("${this.name} hat ${attacke.name} angewand und damit ${hero.name} besiegt")
            println("${hero.name} ist besiegt!")
        } else {
            val remainingArmorPercent = if (hero.armor != 0) (hero.armorReduction * 100) / hero.armor else 0
            println("${hero.name} hat $remainingArmorPercent % Rüstung")
            if (remainingArmorPercent in 90..100) {
                var realDamage = (attacke.healOrdamage / 100) * 10
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 80..90) {
                var realDamage = (attacke.healOrdamage / 100) * 20
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 70..80) {
                var realDamage = (attacke.healOrdamage / 100) * 30
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 60..70) {
                var realDamage = (attacke.healOrdamage / 100) * 40
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 50..60) {
                var realDamage = (attacke.healOrdamage / 100) * 50
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 40..50) {
                var realDamage = (attacke.healOrdamage / 100) * 60
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 30..40) {
                var realDamage = (attacke.healOrdamage / 100) * 70
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 20..30) {
                var realDamage = (attacke.healOrdamage / 100) * 80
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 10..20) {
                var realDamage = (attacke.healOrdamage / 100) * 90
                hero.armorReduction -= attacke.healOrdamage
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent < 10) {
                hero.armor = 0
                hero.lp -= attacke.healOrdamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            }
        }
    }
}