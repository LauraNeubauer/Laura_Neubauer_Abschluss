import Beutel.Beutel
import Enemy.Attacke_Enemys
import Enemy.Enemy
import Enemy.Enemy_Taktiker
import Enemy.Enemy_Übernatürlicher
import Heros.*

var gestorbeneHelden: MutableList<Hero> = mutableListOf()

var attackenGamora: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Tritt", 500),
    Attacke_Heros("Kampfkunstattacke", 500),
    Attacke_Heros("Wurfwaffe", 500),
    Attacke_Heros("Kombikampf", 500),
)
var attackenDrax: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Hieb", 500),
    Attacke_Heros("Messerattacke", 500),
    Attacke_Heros("Tritt", 500),
    Attacke_Heros("Spürsinn", null)
)
var attackenRocket: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Präzisionsschüsse", 500),
    Attacke_Heros("Hacking", 500),
    Attacke_Heros("Modifizierung", 500),
    Attacke_Heros("Bombe", 500),
)
var attackenGroot: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Pfeile", 500),
    Attacke_Heros("Formwandel", null),
    Attacke_Heros("Schutz", null),
    Attacke_Heros("Heilung der Natur", 400),
)
var attackenPeter: MutableList<Attacke_Heros> = mutableListOf(
    Attacke_Heros("Blast", 500),
    Attacke_Heros("Ablenken", null),
    Attacke_Heros("Jet-Pack", 500),
    Attacke_Heros("Doppelschuss", 500)
)

var gamora: Hero_Nahkaempfer = Hero_Nahkaempfer("Gamora", 3200, 3200, 400, 400, 135, "Taktiker", attackenGamora)
var drax: Hero_Nahkaempfer = Hero_Nahkaempfer("Drax", 4500, 4500, 550, 550, 100, "Taktiker", attackenDrax)
var rocket: Hero_Ingenieur = Hero_Ingenieur("Rocket", 400, 400, 1400, 1400, 145, "Nahkämpfer", attackenRocket)
var groot: Hero_Plantoid = Hero_Plantoid("Groot", 5000, 5000, 5000, 5000, 80, "Nahkämpfer", attackenGroot)
var peter: Hero_Taktiker = Hero_Taktiker("Peter Quill (Star-Lord)", 800, 800, 2300, 2300, 140, "Nahkämpfer", attackenPeter)

var listeDerHelden = mutableListOf(gamora, drax, rocket, groot, peter)
var taktikerListe: MutableList<Hero> = mutableListOf(peter)
var ingenieurListe: MutableList<Hero> = mutableListOf(rocket)
var nahkaempferListe: MutableList<Hero> = mutableListOf(gamora, drax)

var rucksack: MutableList<Beutel> = mutableListOf(
    Beutel("Groot's Vitalttrank", 2,4, listeDerHelden),
    Beutel("Elementar Kristalle", 10, 4,listeDerHelden),
    Beutel("Star-Lord's Mixtape", 2, 4,taktikerListe),
    Beutel("Ingeneurshandbuch", 2, 4,ingenieurListe),
    Beutel("Kampfhandschuhe", 10, 4,nahkaempferListe)
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

fun main() {
    println()
    val gezogeneHelden = mutableListOf<Hero>()
    val game = GamePlay(listeDerHelden, rucksack)
    var continueBattle = true
    endgegner_ronan.EndgegnerinFight(endgegner_ronan)
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
                val spielerAktion = readln()

                when (spielerAktion) {
                    "1" -> {
                        println("Du kämpfst mit ${held.name}")
                        println("Welche Attacke willst du ausführen?")
                        for ((index, attack) in held.attacks.withIndex()) {
                            println("$index. ${attack.name}")
                        }
                        val attackChoice = readln()
                        when (attackChoice) {
                            "0" -> {
                                held.attackEnemy(endgegner_ronan, held.attacks[0])
                            }
                            "1" -> {
                                held.attackEnemy(endgegner_ronan, held.attacks[1])
                            }
                            "2" -> {
                                held.attackEnemy(endgegner_ronan, held.attacks[1])
                            }
                            "3" -> {
                                held.attackEnemy(endgegner_ronan, held.attacks[1])
                            }
                            else -> {
                                println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Attacken.")
                            }
                        }
                        val gestorben = listeDerHelden.filter { it.lp <= 0 }
                        for (helden in gestorben) {
                            gestorbeneHelden.add(helden)
                            listeDerHelden.remove(helden)
                            println("${helden.name} ist gestorben")
                        }
                        gezogeneHelden.add(held)
                    }
                    "2" -> {
                        println("Du öffnest deinen Beutel und siehst, was darin ist.")
                    }
                    else -> {
                        println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                    }
                }
            }
        }
    }
}
