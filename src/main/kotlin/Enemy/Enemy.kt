package Enemy
import Heros.Attacke_Heros
import Heros.Hero
import kotlin.time.times

open class Enemy(
    var name: String,
    var lp: Int,
    var lpStandart: Int,
    var armor: Int,
    var armorReduction: Int,
    var speed: Int,
    var weakness: String,
    var attaken: MutableList<Attacke_Enemys> = mutableListOf(),
    var helferBeschworen: Boolean,
    var helferLebt: Boolean,
    var inFight: MutableList<Enemy> = mutableListOf(),
    var tot: MutableList<Enemy> = mutableListOf()
) {
    fun HammerSchockWelle(heroes: List<Hero>) {
        for (hero in heroes) {
            val damage: Int? = this.attaken[0].healOrDamage
            println("${this.name} hat ${hero.name} um 300 Lebenspunkte verletzt!!")
            println("${hero.name} hat noch ${hero.lp} Lebenspunkte")
            hero.lp -= damage!!
        }
    }

    fun EndgegnerinFight(endgegner : Enemy){
        println("Während ihr euch auf Ronans Versteck zubewegt, bemerkt ihr düstere Zeichen am Himmel. Gewitterwolken brauen sich zusammen, " +
                "als ob das Universum selbst euren Kampf vorausahnt. Die Welt um euch herum wird ruhig, als würden die Sterne selbst auf den Ausgang dieser Schlacht warten.")
        inFight.add(this)
    }

    fun HelferBeschwören(helfer : Enemy_Taktiker){
        println("${this.name} beschwört einen treuen Anhänger der Kree-Krieger!!")
        println("Eine große schwarze Wolke taucht vor ${this.name} auf und daraus entspringt: ${helfer.name}")
        inFight.add(helfer)
    }

    fun Packen(hero: Hero) {
        val startLP = hero.lp
        val wert = hero.lpStandart * 0.2
        val damagePerRound : Double = (startLP * 0.1)
        while ( hero.lp > wert ) {
            hero.lp -= damagePerRound.toInt()
            if (hero.lp < wert) {
                hero.lp = wert.toInt()
            }
            println("${this.name} hat ${hero.name} gepackt!")
            println("${hero.name} hat nun ${hero.lp} Lebenspunkte.")
        }
        println("${hero.name} hat nun nurnoch ${hero.lp} Lebenspunkte")
    }

    fun attacke_simple(hero: Hero, attacke: Attacke_Heros) {
        if (attacke.healOrdamage!! > hero.lp) {
            hero.lp = 0
            println("${this.name} hat ${attacke.name} angewand und damit ${hero.name} besiegt")
            println("${hero.name} ist besiegt!")
        } else {
            val remainingArmorPercent = if (hero.armor != 0) (hero.armorReduction * 100) / hero.armor else 0
            println("${hero.name} hat $remainingArmorPercent % Rüstung")
            if (remainingArmorPercent in 90..100) {
                val realDamage = (attacke.healOrdamage!! / 100) * 10
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 80..90) {
                val realDamage = (attacke.healOrdamage!! / 100) * 20
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 70..80) {
                val realDamage = (attacke.healOrdamage!! / 100) * 30
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 60..70) {
                val realDamage = (attacke.healOrdamage!! / 100) * 40
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 50..60) {
                val realDamage = (attacke.healOrdamage!! / 100) * 50
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 40..50) {
                val realDamage = (attacke.healOrdamage!! / 100) * 60
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 30..40) {
                val realDamage = (attacke.healOrdamage!! / 100) * 70
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 20..30) {
                val realDamage = (attacke.healOrdamage!! / 100) * 80
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent in 10..20) {
                val realDamage = (attacke.healOrdamage!! / 100) * 90
                hero.armorReduction -= attacke.healOrdamage!!
                hero.lp -= realDamage
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            } else if (remainingArmorPercent < 10) {
                hero.armor = 0
                hero.lp -= attacke.healOrdamage!!
                println("${this.name} hat ${attacke.name} angewand!")
                println("${hero.name} verliert ${attacke.healOrdamage} Lebenspunkte und hat noch ${hero.lp} Lebenspunkte!")
            }
        }
    }
}