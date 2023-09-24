package Enemy
import Heros.Hero

open class Enemy(
    var name: String,
    var lp: Int,
    var lpStandart: Int,
    var armor: Int,
    var armorReduction: Int,
    var speed: Int,
    var weakness: String,
    var attaken: MutableList<AttacksEnemys> = mutableListOf(),
    var korathIsInFight: Boolean,
    var korathIsAlive: Boolean,
    var inFight: MutableList<Enemy> = mutableListOf(),
    var dead: MutableList<Enemy> = mutableListOf()
) {
    fun HammerSchockWelle(heroes: MutableList<Hero>, deadHeros: MutableList<Hero>) {
        for (hero in heroes) {
            val damage: Int = this.attaken[0].healOrDamage!!
            if (hero.lp > damage){
                println("${this.name} hat ${hero.name} um 300 Lebenspunkte verletzt!!")
                println("${hero.name} hat noch ${hero.lp} Lebenspunkte")
                hero.lp -= damage
            } else {
                hero.lp = 0
                heroes.remove(hero)
                deadHeros.add(hero)
            }
        }
    }

    fun EndgegnerinFight(endgegner : Enemy){
        println("Während ihr euch auf Ronans Versteck zubewegt, bemerkt ihr düstere Zeichen am Himmel. Gewitterwolken brauen sich zusammen, " +
                "als ob das Universum selbst euren Kampf vorausahnt. Die Welt um euch herum wird ruhig, als würden die Sterne selbst auf den Ausgang dieser Schlacht warten.")
        println()
        inFight.add(this)
    }

    fun HelferBeschwören(helfer : EnemyKorath){
        println("${this.name} beschwört einen treuen Anhänger der Kree-Krieger!!")
        println("Eine große schwarze Wolke taucht vor ${this.name} auf und daraus entspringt: ${helfer.name}")
        inFight.add(helfer)
    }

    fun grab(hero: Hero) {
        while (hero.cursed) {
            val startLP = hero.lp
            val wert = hero.lpStandart * 0.2
            val damagePerRound: Double = (startLP * 0.1)
            if (hero.lp > wert) {
                hero.lp -= damagePerRound.toInt()
                if (hero.lp < wert) {
                    hero.lp = wert.toInt()
                }
                println("${hero.name} hat ${hero.name} gepackt!")
                println("${hero.name} hat nun ${hero.lp} Lebenspunkte.")
            }
        }
    }

    fun attacke_simple(heroes: MutableList<Hero>, attacke: AttacksEnemys, deadHeros: MutableList<Hero>) {
        var randomHero = heroes.random()
        if (attacke.healOrDamage!! >= randomHero.lp) {
            randomHero.lp = 0
            println("${this.name} hat ${attacke.name} angewand und damit ${randomHero.name} besiegt")
            println("${randomHero.name} ist besiegt!")
            heroes.remove(randomHero)
            deadHeros.add(randomHero)
        } else {
            val remainingArmorPercent = if (randomHero.armor != 0) (randomHero.armorReduction * 100) / randomHero.armor else 0
            if (remainingArmorPercent > 0) {
                println("${randomHero.name} hat $remainingArmorPercent % Rüstung")
            }
            if (remainingArmorPercent in 90..100) {
                val realDamage = (attacke.healOrDamage!! / 100) * 10
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 80..90) {
                val realDamage = (attacke.healOrDamage!! / 100) * 20
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 70..80) {
                val realDamage = (attacke.healOrDamage!! / 100) * 30
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 60..70) {
                val realDamage = (attacke.healOrDamage!! / 100) * 40
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 50..60) {
                val realDamage = (attacke.healOrDamage!! / 100) * 50
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 40..50) {
                val realDamage = (attacke.healOrDamage!! / 100) * 60
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 30..40) {
                val realDamage = (attacke.healOrDamage!! / 100) * 70
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 20..30) {
                val realDamage = (attacke.healOrDamage!! / 100) * 80
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 10..20) {
                val realDamage = (attacke.healOrDamage!! / 100) * 90
                randomHero.armorReduction -= attacke.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent < 10) {
                randomHero.armor = 0
                randomHero.lp -= attacke.healOrDamage!!
                println("${randomHero.name} hat keine schützende Rüstung mehr! Der Schaden geht nun komplett auf die Lebenspunkte!")
                println("${this.name} hat ${attacke.name} angewand!")
                println("${randomHero.name} verliert ${attacke.healOrDamage} Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            }
        }
    }
}