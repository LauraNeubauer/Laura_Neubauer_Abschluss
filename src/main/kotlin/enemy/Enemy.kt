package enemy
import heros.Hero

open class Enemy(
    var name: String,
    var lp: Int,
    var armor: Int,
    var armorReduction: Int,
    var attacks: MutableList<AttacksEnemy> = mutableListOf(),
    var korathIsInFight: Boolean,
    var korathIsAlive: Boolean,
    private var inFight: MutableList<Enemy> = mutableListOf(),
) {
    fun shockWave(heroes: MutableList<Hero>, deadHeros: MutableList<Hero>) {
        for (hero in heroes) {
            val damage: Int = this.attacks[0].healOrDamage!!
            println("${this.name} hat ${hero.name} um 300 Lebenspunkte verletzt!!")
            println("${hero.name} hat noch ${hero.lp} Lebenspunkte")
            if (hero.lp < damage) {
                heroes.remove(hero)
                deadHeros.add(hero)
            } else {
                hero.lp -= damage
            }
        }
        println()
    }

    fun ronanInFight(enemy : Enemy){
        println("Während ihr euch auf Ronans Versteck zubewegt, bemerkt ihr düstere Zeichen am Himmel. Gewitterwolken brauen sich zusammen, " +
                "als ob das Universum selbst euren Kampf vorausahnt. Die Welt um euch herum wird ruhig, als würden die Sterne selbst auf den Ausgang dieser Schlacht warten.")
        println()
        inFight.add(enemy)
    }

    fun putKorathInFight(korath : EnemyKorath){
        println("${this.name} beschwört einen treuen Anhänger der Kree-Krieger!!")
        println("Eine große schwarze Wolke taucht vor ${this.name} auf und daraus entspringt: ${korath.name}")
        inFight.add(korath)
    }

    fun attackSimple(heroes: MutableList<Hero>, attack: AttacksEnemy, deadHeros: MutableList<Hero>) {
        val randomHero = heroes.random()
        if (attack.healOrDamage!! >= randomHero.lp) {
            randomHero.lp = 0
            println("${this.name} hat ${attack.name} angewand und damit ${randomHero.name} besiegt")
            println("${randomHero.name} ist besiegt!")
            heroes.remove(randomHero)
            deadHeros.add(randomHero)
            println()
        } else {
            val remainingArmorPercent = if (randomHero.armor != 0) (randomHero.armorReduction * 100) / randomHero.armor else 0
            if (remainingArmorPercent > 0) {
                println("${randomHero.name} hat $remainingArmorPercent % Rüstung")
            }
            if (remainingArmorPercent in 90..100) {
                val realDamage = (attack.healOrDamage!! / 100) * 10
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 80..90) {
                val realDamage = (attack.healOrDamage!! / 100) * 20
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 70..80) {
                val realDamage = (attack.healOrDamage!! / 100) * 30
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 60..70) {
                val realDamage = (attack.healOrDamage!! / 100) * 40
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 50..60) {
                val realDamage = (attack.healOrDamage!! / 100) * 50
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 40..50) {
                val realDamage = (attack.healOrDamage!! / 100) * 60
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 30..40) {
                val realDamage = (attack.healOrDamage!! / 100) * 70
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 20..30) {
                val realDamage = (attack.healOrDamage!! / 100) * 80
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent in 10..20) {
                val realDamage = (attack.healOrDamage!! / 100) * 90
                randomHero.armorReduction -= attack.healOrDamage!!
                randomHero.lp -= realDamage
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Rüstungspunkte und $realDamage Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            } else if (remainingArmorPercent < 10) {
                randomHero.armor = 0
                randomHero.lp -= attack.healOrDamage!!
                println("${randomHero.name} hat keine schützende Rüstung mehr! Der Schaden geht nun komplett auf die Lebenspunkte!")
                println("${this.name} hat ${attack.name} angewand!")
                println("${randomHero.name} verliert ${attack.healOrDamage} Lebenspunkte und hat noch ${randomHero.lp} Lebenspunkte!")
                println()
            }
        }
    }
}