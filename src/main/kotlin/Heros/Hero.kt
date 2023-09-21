package Heros

import Beutel.Beutel
import Enemy.Enemy

open class Hero(
    var name: String,
    var lp: Int,
    var lpStandart: Int,
    var armor: Int,
    var armorReduction: Int,
    var speed: Int,
    var weakness: String,
    var attacks: MutableList<Attacke_Heros>
) {

    private var hasUsedBeutelThisRound: Boolean = false

    open fun useBeutel(beutel: Beutel) {
        if (hasUsedBeutelThisRound) {
            println("$name hat den Beutel bereits in dieser Runde verwendet.")
            return
        }
        beutel.use()
        hasUsedBeutelThisRound = true
    }
    fun attackEnemy(enemy: Enemy, attacke: Attacke_Heros) {
        if (attacke.healOrdamage!! > enemy.lp) {
            enemy.lp = 0
            println("${this.name} hat ${attacke.name} angewand und damit ${enemy.name} besiegt")
            println("${enemy.name} ist besiegt!")
        } else {
            val remainingArmorPercent = if (enemy.armor != 0) (enemy.armorReduction * 100) / enemy.armor else 0
            println("${enemy.name} hat $remainingArmorPercent % Rüstung")
            if (remainingArmorPercent in 90..100) {
                val realDamage = (attacke.healOrdamage!! / 100) * 10
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 80..90) {
                val realDamage = (attacke.healOrdamage!! / 100) * 20
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 70..80) {
                val realDamage = (attacke.healOrdamage!! / 100) * 30
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 60..70) {
                val realDamage = (attacke.healOrdamage!! / 100) * 40
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 50..60) {
                val realDamage = (attacke.healOrdamage!! / 100) * 50
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 40..50) {
                val realDamage = (attacke.healOrdamage!! / 100) * 60
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 30..40) {
                val realDamage = (attacke.healOrdamage!! / 100) * 70
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 20..30) {
                val realDamage = (attacke.healOrdamage!! / 100) * 80
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 10..20) {
                val realDamage = (attacke.healOrdamage!! / 100) * 90
                enemy.armorReduction -= attacke.healOrdamage!!
                enemy.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            } else if (remainingArmorPercent < 10) {
                enemy.armor = 0
                enemy.lp -= attacke.healOrdamage!!
                println("${this.name} hat ${attacke.name} angewand!")
                println("${enemy.name} verliert ${attacke.healOrdamage} Lebenspunkte und hat noch ${enemy.lp} Lebenspunkte!")
            }
        }
    }
}


// Taktiker                 // Peter Quill (Star-Lord) : Blast / Ablenken / Jet-Pack / Doppelschuss
//                             800 ( 2300 Rüstung / Schnelligkeit : 140 % / Schwäche : Nahkampf )
// Nahkämpfer               // Gamora : Tritt / Kampfkunstattacke / Wurfwaffe / Kombikampf
//                             3200 ( 400 Rüstung / Schnelligkeit : 135 % / Schwäche : Taktiker )
// Nahkämpfer               // Drax : Hieb / Messerattacke / Waffen-zerstören / Spürsinn
//                             4500 ( 550 Rüstung / Schnelligkeit : 100 % / Schwäche : Taktiker )
// Ingenieur                // Rocket : Präzisionsschüsse / Hacking / Modifizierung / Bombe
//                             400  ( 1400 Rüstung / Schnelligkeit : 145 % / Schwäche : Nahkampf )
// Plantoid                 // Groot : Formwandel / Schutz / Heilung-der-Natur / Kontrolle
//                             5000 ( 5000 Rüstung / Schnelligkeit : 80 % / Schwäche : Nahkämpfer )

//                  Rucksack : 5 x Groot's Vitaltrank : Alle Kategorien : heilt um die Hälfte seiner Lebenspunkte
//                           / 1 x Elementar Kristalle : Alle Kategorien : erhöhen den Schadenswert für einen Helden dauerhaft um 10%
//                           / 1 x Star-Lord's Mixtape : Taktiker : verdoppelt den Schaden der nächsten Attacke
//                           / 1 x Ingenieurshandbuch : Ingenieur : verdoppelt den Schaden der nächsten Attacke
//                           / 1 x Kampfhandschuhe : Nahkämpfer : erhöhen den Schadenswert für einen Helden dauerhaft um 10%
