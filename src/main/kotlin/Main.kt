import Beutel.Beutel
import Enemy.Attacke_Enemys
import Enemy.Enemy
import Enemy.Enemy_Taktiker
import Enemy.Enemy_Übernatürlicher
import Heros.*

private var deadHeros: MutableList<Hero> = mutableListOf()

private var attacksGamora: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Tritt", 500),
    Attacke_Heros("Kampfkunstattacke", 500),
    Attacke_Heros("Wurfwaffe", 500),
    Attacke_Heros("Kombikampf", 500),
)
private var attacksDrax: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Hieb", 500),
    Attacke_Heros("Messerattacke", 500),
    Attacke_Heros("Tritt", 500),
    Attacke_Heros("Round-House-Kick", 600)
)
private var attacksRocket: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Präzisionsschüsse", 500),
    Attacke_Heros("Hacking", 500),
    Attacke_Heros("Modifizierung", 500),
    Attacke_Heros("Bombe", 500),
)
private var attacksGroot: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Astpfeile", 500),
    Attacke_Heros("Peitschenäste", 400),
    Attacke_Heros("Durchbohren", 550),
    Attacke_Heros("Würgen", 400),
)
private var attacksPeter: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Blast", 500),
    Attacke_Heros("Manipulieren", 300),
    Attacke_Heros("Jet-Pack", 500),
    Attacke_Heros("Doppelschuss", 500)
)

var gamora: Hero_Nahkaempfer = Hero_Nahkaempfer("Gamora", 3200, 3200, 400, 400, 135, "Taktiker", attacksGamora, false)
var drax: Hero_Nahkaempfer = Hero_Nahkaempfer("Drax", 4500, 4500, 550, 550, 100, "Taktiker", attacksDrax, false)
var rocket: Hero_Ingenieur = Hero_Ingenieur("Rocket", 400, 400, 1400, 1400, 145, "Nahkämpfer", attacksRocket, false)
var groot: Hero_Plantoid = Hero_Plantoid("Groot", 5000, 5000, 5000, 5000, 80, "Nahkämpfer", attacksGroot, false)
var peter: Hero_Taktiker = Hero_Taktiker("Peter Quill (Star-Lord)", 800, 800, 2300, 2300, 140, "Nahkämpfer", attacksPeter, false)

var listeDerHelden = mutableListOf(gamora, drax, rocket, groot, peter)

var rucksack: MutableList<Beutel> = mutableListOf(
    Beutel("Groot's Vitalttrank", 2, 5),
    Beutel("Elementar Kristalle", 10, 4),
)

var attacken_endgegner_ronan: MutableList<Attacke_Enemys> = mutableListOf(
    Attacke_Enemys("Hammer-Schock-Welle", 300),
    Attacke_Enemys("Packen", 10),
    Attacke_Enemys("Beschwören", null),
    Attacke_Enemys("Tritt", 440),
    Attacke_Enemys("Hammerhieb", 700),
    Attacke_Enemys("Schuss", 350),
)
var attacken_helfer: MutableList<Attacke_Enemys> = mutableListOf(
    Attacke_Enemys("Tritt", 440),
    Attacke_Enemys("Schuss", 350),
    Attacke_Enemys("Doppelschuss", 350),
    Attacke_Enemys("Heilungsblitz", 350),
)

var inFight : MutableList<Enemy> = mutableListOf()
var toteEndgegner : MutableList<Enemy> = mutableListOf()

var endgegner_ronan: Enemy_Übernatürlicher = Enemy_Übernatürlicher("Ronan the Accuser", 3500, 3500, 2500, 2500, 120, "Taktiker", attacken_endgegner_ronan, false, true, inFight, toteEndgegner)
var helfer_Endgegner: Enemy_Taktiker = Enemy_Taktiker("Korath the Pursuer", 1000, 3500, 1500, 1500, 110, "Nahkampf", attacken_helfer, false, true, inFight, toteEndgegner)

fun useBeutel(hero: Hero) {
    if (hero.hasUsedBeutel == true) {
        println("${hero.name} hat den Beutel bereits in dieser Runde verwendet.")
    } else if (rucksack.isEmpty()) {
        println("Der Rucksack ist leer! ")
    } else {
        for ((index, beutel) in rucksack.withIndex()) {
            println("${index}. ${beutel.name}")
        }
        val beutelChoice : Int = readln().toInt()
        if (beutelChoice in (0..1)) {
            when (beutelChoice) {
                0 -> {
                    println("${hero.name} hat ${hero.lp} Lebenspunkte")
                    println("${hero.name} trinkt ${rucksack[0].name}!")
                    println("${hero.name} Lebenspunkte werden um die Hälfte seiner ursprünglichen Lebenspunkte geheilt")
                    if (hero.lp < (hero.lpStandart / 2)) {
                        hero.lp + (hero.lpStandart / rucksack[0].value)
                    } else {
                        val fullLp = hero.lpStandart
                        hero.lp = fullLp
                    }
                    println("${hero.name} hat nun ${hero.lp} Lebenspunkte!")
                    println()
                    rucksack[beutelChoice].amount - 1
                }
                1 -> {
                    //erhöhen den Schadenswert für einen Helden dauerhaft um 10%
                    println("${hero.name} nutzt ${rucksack[1].name}")
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
            hero.hasUsedBeutel = true
        } else {
            println("Ungültige Auswahl.")
        }
    }
}

fun FirstRound() {
    println()
    val gezogeneHelden = mutableListOf<Hero>()
    var continueBattle = true
    for (held in listeDerHelden) {
        while (continueBattle && listeDerHelden.isNotEmpty()) {
            for (held in listeDerHelden.sortedByDescending { it.speed }) {
                if (listeDerHelden.isEmpty()) {
                    break
                }
                if (held in gezogeneHelden) {
                    continue
                }
                println("Es ist ${held.name}'s Zug.")
                println("Was möchtest du tun?")
                println("1. Kämpfen und Attacke wählen")
                println("2. Den Beutel nutzen")
                var spielerAktion: Int? = null
                while (spielerAktion == null || spielerAktion < 0 || spielerAktion > 2) {
                    val input = readln()

                    try {
                        spielerAktion = input.toInt()

                        if (spielerAktion < 0 || spielerAktion > 2) {
                            println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                        }
                    } catch (e: NumberFormatException) {
                        println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
                    }
                }
                when (spielerAktion) {
                    1 -> {
                        println("Du kämpfst mit ${held.name}")
                        println("Welche Attacke willst du ausführen?")
                        for ((index, attack) in held.attacks.withIndex()) {
                            println("$index. ${attack.name}")
                        }
                        var attackChoice: Int? = null
                        while (attackChoice == null || attackChoice < 0 || attackChoice >= held.attacks.size) {
                            val input = readln()
                            attackChoice = input.toInt()
                            if (attackChoice == null || attackChoice < 0 || attackChoice >= held.attacks.size) {
                                println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Attacken.")
                            }
                        }
                        held.attackEnemy(endgegner_ronan, held.attacks[attackChoice])

                        val gestorben = listeDerHelden.filter { it.lp <= 0 }
                        for (helden in gestorben) {
                            deadHeros.add(helden)
                            listeDerHelden.remove(helden)
                            println("${helden.name} ist gestorben")
                        }
                        gezogeneHelden.add(held)
                        continueBattle = false
                    }
                    2 -> {
                        println("Du öffnest deinen Beutel und siehst, was darin ist.")
                        useBeutel(held)
                    }
                    else -> {
                        println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                    }
                }
            }
        }
    }
}
fun firstRoundEnemy(){
    StoryLine2()
    println()
    var randomAttack = (0..5).random()
    if (randomAttack == 2 && endgegner_ronan.helferLebt == true && endgegner_ronan.helferBeschworen == false){
        endgegner_ronan.HelferBeschwören(helfer_Endgegner)
    } else if (randomAttack == 0) {
        endgegner_ronan.HammerSchockWelle(listeDerHelden)
    } else if (randomAttack == 1) {
        endgegner_ronan.Packen(listeDerHelden.random())
    } else if (randomAttack == 3) {
        endgegner_ronan.attacke_simple(listeDerHelden.random(), endgegner_ronan.attaken[3])
    } else if (randomAttack == 4) {
        endgegner_ronan.attacke_simple(listeDerHelden.random(), endgegner_ronan.attaken[4])
    } else if (randomAttack == 5) {
        endgegner_ronan.attacke_simple(listeDerHelden.random(), endgegner_ronan.attaken[5])
    }
}

fun main(){
    endgegner_ronan.EndgegnerinFight(endgegner_ronan)
    FirstRound()
    firstRoundEnemy()
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