package enemy
import heros.Hero
import resetColor

// Ober-Klasse der Gegner
// Name der Gegner
// Lebenspunkte welche mutabel sind
// Rüstungspunkte Standartwert zum Berechnen
// Rüstungspunkte welche abgezogen werden falls über 0
// Attacken der Gegner
// Abfrage ob der Helfer im Kampf ist
// Abfrage ob der Helfer am Leben ist (Wenn bereits Tot, kann es nicht beschworen werden)
// Mutable liste der Gegner im Kampf -> wenn gestorben werden sie aus der Liste entfernt
// Farben der Gegner

open class Enemy(
    var name: String,
    var lp: Int,
    var armor: Int,
    var armorReduction: Int,
    var attacks: List<AttacksEnemy> = listOf(),
    var korathIsInFight: Boolean,
    var korathIsAlive: Boolean,
    private var inFight: MutableList<Enemy> = mutableListOf(),
    val colorName: String
) {

    // Funktion für die Attacke der Schock-Welle
    // Greift alle lebenden Helden an
    // Wenn Lebenspunkte unterhalb der verrichteten Schadenspunkte
    // wird der Held aus der KampfListe entfernt und in die Liste der Toten übertragen
    fun shockWave(heroes: MutableList<Hero>, deadHeros: MutableList<Hero>) {
        println("${this.name} schlägt seinen Hammer auf den Boden und löst damit eine Schockwelle aus die sämliche Rüstungs-" +
                "punkte ignoriert! ")
        println()
        for (hero in heroes) {
            val damage: Int = this.attacks[0].damage!!
            println("${this.colorName}${this.name}${resetColor} hat ${hero.colorName}${hero.name}${resetColor} um 300 Lebenspunkte verletzt!!")
            println("${hero.colorName}${hero.name}${resetColor} hat noch ${hero.lp} Lebenspunkte")
            if (hero.lp < damage) {
                heroes.remove(hero)
                deadHeros.add(hero)
            } else {
                hero.lp -= damage
            }
        }
        println()
    }

    // Funktion um den Endgegner ins Spiel zu holen
    fun ronanInFight(enemy : Enemy){
        println("Während ihr euch auf Ronans Versteck zubewegt, bemerkt ihr düstere Zeichen am Himmel. Gewitterwolken brauen sich zusammen, " +
                "als ob das Universum selbst euren Kampf vorausahnt. Die Welt um euch herum wird ruhig, als würden die Sterne selbst auf den Ausgang dieser Schlacht warten.")
        println()
        inFight.add(enemy)
    }

    // Funktion um den Helfer des Endgegners ins Spiel zu holen
    fun putKorathInFight(korath : EnemyKorath){
        println("${this.colorName}${this.name}${resetColor} beschwört einen treuen Anhänger der Kree-Krieger!!")
        println("Eine große schwarze Wolke taucht vor ${this.colorName}${this.name}${resetColor} auf und daraus entspringt: ${korath.colorName}${korath.name}${resetColor}")
        inFight.add(korath)
    }

    // Simple Attacke mit vorgegebenen Schadenspunkte welche in der MainKt initialisiert wird
    // zieht je nach höhe der Rüstungspunkte Lebenspunkte ab
    // Je höher die Rüstungspunkte dessto geringer der Schaden auf die Lebenspunkte
    fun attackSimple(heroes: MutableList<Hero>, attack: AttacksEnemy, deadHeros: MutableList<Hero>) {
        val randomHero = heroes.random()
        // Schadenspunkte übersteigen die Lebenspunkte -> Held ist tot
        // wird von der Liste der kämpfenden Helden übertragen in die Liste der toten Helden
        if (attack.damage!! >= randomHero.lp) {
            randomHero.lp = 0
            println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand und damit ${randomHero.colorName}${randomHero.name}${resetColor} besiegt")
            println("${randomHero.colorName}${randomHero.name}${resetColor} ist besiegt!")
            heroes.remove(randomHero)
            deadHeros.add(randomHero)
            println()
        // Wenn gegner noch Rüstungspunkte hat:
        // Ausgabe der Rüstungspunke unabhängig vom Schaden
        } else {
            val remainingArmorPercent = if (randomHero.armor != 0) (randomHero.armorReduction * 100) / randomHero.armor else 0
            if (remainingArmorPercent > 0) {
                println("${randomHero.colorName}${randomHero.name}${resetColor} hat $remainingArmorPercent % Rüstung")
            }
            // Wenn der Gegner zwischen 90 und 100 % der Rüstung hat
            if (remainingArmorPercent in 90..100) {
                val realDamage = (attack.damage!! / 100) * 10
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 80 und 90 % der Rüstung hat
            } else if (remainingArmorPercent in 80..90) {
                val realDamage = (attack.damage!! / 100) * 20
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 70 und 80 % der Rüstung hat
            } else if (remainingArmorPercent in 70..80) {
                val realDamage = (attack.damage!! / 100) * 30
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 60 und 70 % der Rüstung hat
            } else if (remainingArmorPercent in 60..70) {
                val realDamage = (attack.damage!! / 100) * 40
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 50 und 60 % der Rüstung hat
            } else if (remainingArmorPercent in 50..60) {
                val realDamage = (attack.damage!! / 100) * 50
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 40 und 50 % der Rüstung hat
            } else if (remainingArmorPercent in 40..50) {
                val realDamage = (attack.damage!! / 100) * 60
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 30 und 40 % der Rüstung hat
            } else if (remainingArmorPercent in 30..40) {
                val realDamage = (attack.damage!! / 100) * 70
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 20 und 30 % der Rüstung hat
            } else if (remainingArmorPercent in 20..30) {
                val realDamage = (attack.damage!! / 100) * 80
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen 10 und 20 % der Rüstung hat
            } else if (remainingArmorPercent in 10..20) {
                val realDamage = (attack.damage!! / 100) * 90
                randomHero.armorReduction -= attack.damage!!
                randomHero.lp -= realDamage
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            // Wenn der Gegner zwischen unter 10 % der Rüstung hat
            } else if (remainingArmorPercent < 10) {
                // restliste Rüstungspunkte werden auf 0 gesetzt
                randomHero.armor = 0
                // volle Schadenspunkte werden nun von Lebenspunkten abgezogen
                randomHero.lp -= attack.damage!!
                println("${randomHero.colorName}${randomHero.name}${resetColor} hat keine schützende Rüstung mehr! Der Schaden geht nun komplett auf die Lebenspunkte!")
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand!")
                println("${randomHero.colorName}${randomHero.name}${resetColor} verliert ${attack.damage} Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            }
        }
    }

    // Simple Attacke mit vorgegebenen Schadenspunkte welche in der MainKt initialisiert wird
    // zieht die häfte der Schadenspunkte von den Rüstungspunkten ab wenn vorhanden
    // wenn keine Rüstungspunkte vorhanden -> zieht das 1.5 fache des festen schadens von den Lebenspunkten ab
    fun doubleAttack(heroes: MutableList<Hero>, attack: AttacksEnemy, deadHeros: MutableList<Hero>) {
        val hero1 : Hero = heroes.first()
        val hero2 : Hero = heroes.last()
        val heroListHammerBlast : MutableList<Hero> = mutableListOf(hero1, hero2)
        val armorDamage : Int = attack.damage!! / 2
        val damageWOarmor : Int = attack.damage!! + armorDamage
        val damage : Int = attack.damage!!

        println("${this.name} schwingt seinen Hammer und trifft ${hero1.colorName}${hero1.name}${resetColor} und ${hero2.colorName}${hero2.name}${resetColor} kritisch...")
        println()
        // Für beide Gegner überprüfung nach Rüstungs und Lebenspunkten
        for (heros in heroListHammerBlast) {
            if (heros.armorReduction >= armorDamage) {
                heros.armorReduction -= armorDamage
                heros.lp -= damage
                println("Der Hammer zerfetzt ${heros.colorName}${heros.name}'s${resetColor} $armorDamage Rüstungspunkte!")
                println("Und zieht bei ${heros.colorName}${heros.name}${resetColor} ${attack.damage} Lebenspunkte ab!")
                println()
            } else if (heros.lp > damage){
                heros.armorReduction = 0
                heros.lp -= damageWOarmor
                println("Der Hammer zerfetzt ${heros.colorName}${heros.name}'s${resetColor} verbleibende Rüstung!")
                println("Und zieht bei ${heros.colorName}${heros.name}${resetColor} $damageWOarmor Lebenspunkte ab!")
                println()
            // Im Falle von zu niedigrigen Lebenspunkten wird der Gegner aus der KampfListe genommen
            } else {
                heros.lp = 0
                println("${this.colorName}${this.name}${resetColor} hat ${attack.name} angewand und damit ${heros.colorName}${heros.name}${resetColor} besiegt")
                println("${heros.colorName}${heros.name}${resetColor} ist besiegt!")
                heroes.remove(heros)
                deadHeros.add(heros)
                println()
            }
        }
    }

}

