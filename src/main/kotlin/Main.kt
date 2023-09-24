import BagClass.Bag
import Enemy.AttacksEnemys
import Enemy.Enemy
import Enemy.EnemyKorath
import Enemy.EnemyBossRonan
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

var gamora: HeroDraxAndGamora = HeroDraxAndGamora("Gamora", 3200, 3200, 400, 400, 135, attacksGamora, false)
var drax: HeroDraxAndGamora = HeroDraxAndGamora("Drax", 4500, 4500, 550, 550, 100, attacksDrax, false)
var rocket: HeroRocket = HeroRocket("Rocket", 400, 400, 1400, 1400, 145, attacksRocket, false)
var groot: HeroGroot = HeroGroot("Groot", 5000, 5000, 5000, 5000, 80, attacksGroot, false)
var peter: HeroPeter = HeroPeter("Peter Quill (Star-Lord)", 800, 800, 2300, 2300, 140, attacksPeter, false)

var listHeros = mutableListOf(gamora, drax, rocket, groot, peter)

var bag: MutableList<Bag> = mutableListOf(
    Bag("Gamoras Upgrade-Kit", 2, 5),
    Bag("Groot' Vitaltrunk", 10, 4),
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
var deadEnemys : MutableList<Enemy> = mutableListOf()

var bossRonan: EnemyBossRonan = EnemyBossRonan("Ronan the Accuser", 13500, 3500, 2500, 2500, attacksBossRonan, false, true, inFight, deadEnemys)
var korath: EnemyKorath = EnemyKorath("Korath the Pursuer", 12000, 3500, 1500, 1500, attacksKorath, false, true, inFight, deadEnemys)

var enemyList: MutableList<Enemy> = mutableListOf(bossRonan, korath)

fun useBag(hero: Hero) {
    if (hero.hasUsedBag == true) {
        println("${hero.name} hat den Beutel bereits in dieser Runde verwendet.")
    } else if (bag.isEmpty()) {
        println("Der Rucksack ist leer! ")
    } else {
        for ((index, Bag) in bag.withIndex()) {
            println("${index}. ${Bag.name}")
        }
        val bagChoice : Int = readln().toInt()
        if (bagChoice in (0..1)) {
            when (bagChoice) {
                0 -> {
                    println("${hero.name} hat ${hero.lp} Lebenspunkte")
                    println("${hero.name} trinkt ${bag[0].name}!")
                    println("${hero.name} Lebenspunkte werden um die Hälfte seiner ursprünglichen Lebenspunkte geheilt")
                    if (hero.lp < (hero.lpStandart / 2)) {
                        hero.lp + (hero.lpStandart / bag[0].value)
                    } else {
                        val fullLp = hero.lpStandart
                        hero.lp = fullLp
                    }
                    println("${hero.name} hat nun ${hero.lp} Lebenspunkte!")
                    println()
                    bag[bagChoice].amount - 1
                }
                1 -> {
                    println("${hero.name} nutzt ${bag[1].name}")
                    println("${hero.name}'s Attacken werden stärker um 10%")
                    println()
                    for (heroAttack in hero.attacks) {
                        val plus = (heroAttack.healOrdamage!! / 100) * 10
                        print("${heroAttack.name}'s Schaden: ${heroAttack.healOrdamage} steigt auf ")
                        heroAttack.healOrdamage = heroAttack.healOrdamage!! + plus
                        println("${heroAttack.healOrdamage}")
                    }
                    println()
                }
            }
            hero.hasUsedBag = true
        } else {
            println("Ungültige Auswahl.")
        }
    }
}
fun fightHeros() {
    println()
    val fightingHero = mutableListOf<Hero>()
    var continueBattle = true
    for (chosenHero in listHeros) {
        while (continueBattle && listHeros.isNotEmpty()) {
            for (hero in listHeros.sortedByDescending { it.speed }) {
                if (listHeros.isEmpty()) {
                    break
                }
                if (hero in fightingHero) {
                    continue
                }
                println("Es ist ${hero.name}'s Zug.")
                println("Was möchtest du tun?")
                println("1. Kämpfen und Attacke wählen")
                println("2. Den Beutel nutzen")
                var playerAction: Int? = null
                while (playerAction == null || playerAction < 0 || playerAction > 2) {
                    val input = readln()

                    try {
                        playerAction = input.toInt()

                        if (playerAction < 0 || playerAction > 2) {
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
                        if (inFight.contains(korath)){
                            chooseEnemy(enemyList)
                            val chosenEnemy = readln().toInt()
                            if (chosenEnemy <= enemyList.size) {
                                hero.attackEnemy(inFight[chosenEnemy], hero.attacks[attackChoice])
                                fightingHero.add(hero)
                                continueBattle = false
                            } else {
                                println("Wähle einen Gegner aus!")
                            }
                        } else {
                            hero.attackEnemy(bossRonan, hero.attacks[attackChoice])
                            fightingHero.add(hero)
                            continueBattle = false
                        }
                    }
                    2 -> {
                        println("Du öffnest deinen Beutel und siehst, was darin ist.")
                        useBag(hero)
                        fightingHero.add(hero)
                        continueBattle = false
                    }
                    else -> {
                        println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                    }
                }
            }
        }
    }
}
fun fightEnemy(){
    storyLine2()
    println()
    val randomAttackRonan = (0..5).random()
    val randomAttackKorath = (0..3).random()
    // 2 = Schuss ( simple Attacke )
    if (randomAttackRonan == 2){
        if (inFight.contains(korath)){
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[2], deadHeros)
            korath.attacke_simple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else {
            //funktioniert
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[2], deadHeros)
        }
    // 0 = Hammer-Schock-Welle ( alle Heros werden attackiert )
    } else if (randomAttackRonan == 0) {
        if (inFight.contains(korath)){
            bossRonan.HammerSchockWelle(listHeros, deadHeros)
            korath.attacke_simple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else {
            //funktioniert
            bossRonan.HammerSchockWelle(listHeros, deadHeros)
        }
    // 1 = Packen ( simple Attacke )
    } else if (randomAttackRonan == 1) {
        if (inFight.contains(korath)) {
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[1], deadHeros)
            korath.attacke_simple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else {
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[1], deadHeros)
        }
    // 3 = Tritt ( simple Attacke )
    } else if (randomAttackRonan == 3) {
        if (inFight.contains(korath)){
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[3], deadHeros)
            korath.attacke_simple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else {
            //funktioniert
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[3], deadHeros)
        }
    // 4 = Hammerhieb ( simple Attacke )
    } else if (randomAttackRonan == 4) {
        if (inFight.contains(korath)){
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[4], deadHeros)
            korath.attacke_simple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else {
            //funktioniert
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[4], deadHeros)
        }
    // 5 = Beschwören ( Korath )
    } else if (randomAttackRonan == 5) {
        if (inFight.contains(korath)){
            val alternative = (0..4).random()
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[alternative], deadHeros)
            println()
            korath.attacke_simple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else if (!bossRonan.korathIsInFight && bossRonan.korathIsAlive){
            bossRonan.HelferBeschwören(korath)
            inFight.add(korath)
            bossRonan.korathIsInFight = true
            println()
            korath.attacke_simple(listHeros, korath.attaken[randomAttackKorath], deadHeros)
        } else {
            val alternative = (0..4).random()
            bossRonan.attacke_simple(listHeros, bossRonan.attaken[alternative], deadHeros)
        }
    }
}

fun chooseEnemy(enemys: MutableList<Enemy>) {
    for ((index, enemy) in enemys.withIndex()) {
        println("$index: ${enemy.name}")
    }
}

fun main() {
    for (hero in listHeros) {
        bossRonan.EndgegnerinFight(bossRonan)
        while (inFight.isNotEmpty() && listHeros.isNotEmpty()) {
            fightHeros()
            fightEnemy()
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