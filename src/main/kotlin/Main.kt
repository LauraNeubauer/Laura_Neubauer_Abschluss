import BagClass.Bag
import enemy.AttacksEnemys
import enemy.Enemy
import enemy.EnemyKorath
import enemy.EnemyBossRonan
import Heros.*

var deadHeros: MutableList<Hero> = mutableListOf()

var attacksGamora: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Tritt", 500),
    AttacksHeros("Kampfkunstattacke", 500),
    AttacksHeros("Wurfwaffe", 500),
    AttacksHeros("Kombikampf", 500),
)
var attacksDrax: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Hieb", 500),
    AttacksHeros("Messerattacke", 500),
    AttacksHeros("Tritt", 500),
    AttacksHeros("Round-House-Kick", 600)
)
var attacksRocket: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Präzisionsschüsse", 500),
    AttacksHeros("Hacking", 500),
    AttacksHeros("Modifizierung", 500),
    AttacksHeros("Bombe", 500),
)
var attacksGroot: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Astpfeile", 500),
    AttacksHeros("Peitschenäste", 400),
    AttacksHeros("Durchbohren", 550),
    AttacksHeros("Würgen", 400),
)
var attacksPeter: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Blast", 500),
    AttacksHeros("Manipulieren", 300),
    AttacksHeros("Jet-Pack", 500),
    AttacksHeros("Doppelschuss", 500)
)

var gamora: HeroDraxAndGamora = HeroDraxAndGamora("Gamora", 3200, 3200, 400, 400, 135, attacksGamora)
var drax: HeroDraxAndGamora = HeroDraxAndGamora("Drax", 4500, 4500, 550, 550, 100, attacksDrax)
var rocket: HeroRocket = HeroRocket("Rocket", 400, 400, 1400, 1400, 145, attacksRocket)
var groot: HeroGroot = HeroGroot("Groot", 5000, 5000, 5000, 5000, 80, attacksGroot)
var peter: HeroPeter = HeroPeter("Peter Quill (Star-Lord)", 800, 800, 2300, 2300, 140, attacksPeter)

var listHeros = mutableListOf(gamora, drax, rocket, groot, peter)

var bag: MutableList<Bag> = mutableListOf(
    Bag("Gamoras Upgrade-Kit", 2, 5),
    Bag("Groot's Vitaltrunk", 10, 5),
)

var attacksBossRonan: MutableList<AttacksEnemys> = mutableListOf(
    AttacksEnemys("Hammer-Schock-Welle", 300),  //0
    AttacksEnemys("Packen", 100),               //1
    AttacksEnemys("Schuss", 350),               //2
    AttacksEnemys("Tritt", 440),                //3
    AttacksEnemys("Hammerhieb", 700),           //4
    AttacksEnemys("Beschwören", null),          //5
)
var attacksKorath: MutableList<AttacksEnemys> = mutableListOf(
    AttacksEnemys("Tritt", 440),                //0
    AttacksEnemys("Schuss", 350),               //1
    AttacksEnemys("Doppelschuss", 350),         //2
    AttacksEnemys("Feuer", 350),                //3
)

var inFight: MutableList<Enemy> = mutableListOf()
var deadEnemy: MutableList<Enemy> = mutableListOf()

var bossRonan: EnemyBossRonan =
    EnemyBossRonan("Ronan the Accuser", 5000, 3500, 2500, 2500, attacksBossRonan, false, true, inFight, deadEnemy)
var korath: EnemyKorath =
    EnemyKorath("Korath the Pursuer", 4000, 3500, 1500, 1500, attacksKorath, false, true, inFight, deadEnemy)

var enemyList: MutableList<Enemy> = mutableListOf(bossRonan, korath)

fun usingBag(hero: Hero) {
    val itemsInBag = bag.filter { it.amount > 0 }.toMutableList()

    while (true) {
        for ((index, bagItem) in itemsInBag.withIndex()) {
            println("${index}. ${bagItem.amount}x ${bagItem.name}")
        }

        try {
            val itemChoice: Int = readln().toInt()

            if (itemChoice in 0..<itemsInBag.size) {
                val selectedItem = itemsInBag[itemChoice]

                when (itemChoice) {
                    0 -> {
                        println("${hero.name} hat ${hero.lp} Lebenspunkte")
                        println("${hero.name} trinkt ${selectedItem.name}!")
                        println("${hero.name} Lebenspunkte werden um die Hälfte seiner ursprünglichen Lebenspunkte geheilt")
                        if (hero.lp < (hero.lpStandart / 2)) {
                            hero.lp += (hero.lpStandart / selectedItem.value)
                        } else {
                            val fullLp = hero.lpStandart
                            hero.lp = fullLp
                        }
                        println("${hero.name} hat nun ${hero.lp} Lebenspunkte!")
                        println()
                        selectedItem.amount -= 1
                        if (selectedItem.amount <= 0) {
                            itemsInBag.remove(selectedItem)
                        }
                        break
                    }

                    1 -> {
                        println("${hero.name} nutzt ${selectedItem.name}")
                        println("${hero.name}'s Attacken werden stärker um 10%")
                        println()
                        for (heroAttack in hero.attacks) {
                            val plus = (heroAttack.healOrdamage!! / 100) * 10
                            print("${heroAttack.name}'s Schaden: ${heroAttack.healOrdamage} steigt auf ")
                            heroAttack.healOrdamage = heroAttack.healOrdamage!! + plus
                            println("${heroAttack.healOrdamage}")
                        }
                        println()
                        selectedItem.amount -= 1
                        if (selectedItem.amount <= 0) {
                            itemsInBag.remove(selectedItem)
                        }
                        break
                    }
                }
            } else {
                println("Ungültige Auswahl.")
            }
        } catch (e: NumberFormatException) {
            println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
        }
    }
}

fun fightHeros() {
    val fightingHero = mutableListOf<Hero>()
    var continueBattle = true
    for (chosenHero in listHeros) {
        while (continueBattle && listHeros.isNotEmpty()) {
            for (hero in listHeros.sortedByDescending { it.speed }) {
                if (inFight.isEmpty()) {
                    break
                }
                if (hero in fightingHero) {
                    continue
                }
                val isBagEmpty = bag.all { it.amount == 0 }
                var playerAction: Int? = null
                if (!isBagEmpty && inFight.isNotEmpty()) {
                    println("Es ist ${hero.name}'s Zug.")
                    println("Was möchtest du tun?")
                    println("1. Kämpfen und Attacke wählen")
                    println("2. Den Beutel nutzen")
                    while (playerAction == null || playerAction < 1 || playerAction > 2) {
                        val input = readln()
                        try {
                            playerAction = input.toInt()

                            if (playerAction < 1 || playerAction > 2) {
                                println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                            }
                        } catch (e: NumberFormatException) {
                            println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
                        }
                    }
                    when (playerAction) {
                        1 -> {
                            println("Du kämpfst mit ${hero.name}")
                            println("Welche Attacke willst du ausführen?")
                            for ((index, attack) in hero.attacks.withIndex()) {
                                println("$index. ${attack.name}")
                            }
                            var attackChoice: Int? = null
                            while (attackChoice == null || attackChoice < 0 || attackChoice >= hero.attacks.size) {
                                val input = readln()
                                attackChoice = input.toInt()
                                if (attackChoice < 0 || attackChoice >= hero.attacks.size) {
                                    println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Attacken.")
                                }
                            }
                            if (inFight.contains(korath) && inFight.contains(bossRonan)) {
                                chooseEnemy(inFight)
                                val chosenEnemy = readln().toInt()
                                if (chosenEnemy <= enemyList.size) {
                                    hero.attackEnemy(
                                        inFight[chosenEnemy],
                                        hero.attacks[attackChoice],
                                        deadEnemy,
                                        inFight
                                    )
                                    fightingHero.add(hero)
                                    continueBattle = false
                                }
                            } else if (inFight.contains(korath) && !inFight.contains(bossRonan)){
                                hero.attackEnemy(korath, hero.attacks[attackChoice], deadEnemy, inFight)
                                fightingHero.add(hero)
                                continueBattle = false
                            } else if (!inFight.contains(korath) && inFight.contains(bossRonan)) {
                                hero.attackEnemy(bossRonan, hero.attacks[attackChoice], deadEnemy, inFight)
                                fightingHero.add(hero)
                                continueBattle = false
                            }
                        }

                        2 -> {
                            println("Du öffnest deinen Beutel und siehst, was darin ist.")
                            usingBag(hero)
                            fightingHero.add(hero)
                            continueBattle = false
                        }

                        else -> {
                            println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                        }
                    }
                } else {
                    println("Du kämpfst mit ${hero.name}")
                    println("Welche Attacke willst du ausführen?")
                    for ((index, attack) in hero.attacks.withIndex()) {
                        println("$index. ${attack.name}")
                    }
                    var attackChoice: Int? = null
                    while (attackChoice == null || attackChoice < 0 || attackChoice >= hero.attacks.size) {
                        val input = readln()
                        attackChoice = input.toInt()
                        if (attackChoice < 0 || attackChoice >= hero.attacks.size) {
                            println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Attacken.")
                        }
                    }
                    if (inFight.contains(korath) && inFight.contains(bossRonan)) {
                        chooseEnemy(enemyList)
                        val chosenEnemy = readln().toInt()
                        if (chosenEnemy <= enemyList.size) {
                            hero.attackEnemy(inFight[chosenEnemy], hero.attacks[attackChoice], deadEnemy, inFight)
                            fightingHero.add(hero)
                            continueBattle = false
                        }
                    } else if (inFight.contains(korath)){
                        hero.attackEnemy(korath, hero.attacks[attackChoice], deadEnemy, inFight)
                        fightingHero.add(hero)
                        continueBattle = false
                    } else {
                        hero.attackEnemy(bossRonan, hero.attacks[attackChoice], deadEnemy, inFight)
                        fightingHero.add(hero)
                        continueBattle = false
                    }
                }
            }
        }
    }
}

fun fightEnemy() {
    storyLine2()
    println()
    val randomAttackRonan = (0..5).random()
    val randomAttackKorath = (0..3).random()
    // 2 = Schuss ( simple Attacke )
    if (randomAttackRonan == 2) {
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attaken[2], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attaken[2], deadHeros)
        } else {
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        }
        // 0 = Hammer-Schock-Welle ( alle Heros werden attackiert )
    } else if (randomAttackRonan == 0) {
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.shockWave(listHeros, deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)){
            bossRonan.shockWave(listHeros, deadHeros)
        } else {
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        }
        // 1 = Packen ( simple Attacke )
    } else if (randomAttackRonan == 1) {
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attaken[1], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)){
            bossRonan.attackSimple(listHeros, bossRonan.attaken[1], deadHeros)
        } else {
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        }
        // 3 = Tritt ( simple Attacke )
    } else if (randomAttackRonan == 3) {
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attaken[3], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)){
            bossRonan.attackSimple(listHeros, bossRonan.attaken[3], deadHeros)
        } else {
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        }
        // 4 = Hammerhieb ( simple Attacke )
    } else if (randomAttackRonan == 4) {
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attaken[4], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attaken[4], deadHeros)
        } else {
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        }
        // 5 = Beschwören ( Korath )
    } else if (randomAttackRonan == 5) {
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            val alternative = (0..4).random()
            bossRonan.attackSimple(listHeros, bossRonan.attaken[alternative], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (!bossRonan.korathIsInFight && bossRonan.korathIsAlive) {
            bossRonan.putKorathInFight(korath)
            bossRonan.korathIsInFight = true
            println()
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (inFight.contains(korath) && !inFight.contains(bossRonan)) {
            korath.attackSimple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else {
            val alternative = (0..4).random()
            bossRonan.attackSimple(listHeros, bossRonan.attaken[alternative], deadHeros)
        }
    }
}

fun chooseEnemy(enemys: MutableList<Enemy>) {
    for ((index, enemy) in enemys.withIndex()) {
        println("$index: ${enemy.name}")
    }
}

fun main() {
    println()
    bossRonan.ronanInFight(bossRonan)
    while (inFight.isNotEmpty() || listHeros.isNotEmpty()) {
        fightHeros()
        if (inFight.isNotEmpty()) {
            fightEnemy()
        } else {
            break
        }
    }
}


//Textfarben:
//Schwarzer Text: \u001B[30m
//Rot: \u001B[31m
//Grün: \u001B[32m
//Gelb: \u001B[33m
//Blau: \u001B[34m
//Magenta: \u001B[35m
//Cyan: \u001B[36m
//Weiß: \u001B[37m
//Hintergrundfarben:
//Schwarzer Hintergrund: \u001B[40m
//Rot: \u001B[41m
//Grün: \u001B[42m
//Gelb: \u001B[43m
//Blau: \u001B[44m
//Magenta: \u001B[45m
//Cyan: \u001B[46m
//Weiß: \u001B[47m