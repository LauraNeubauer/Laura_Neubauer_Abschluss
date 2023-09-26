import bagClass.Bag
import enemy.AttacksEnemy
import enemy.Enemy
import enemy.EnemyKorath
import enemy.EnemyBossRonan
import heros.*
import colors.GuardiansColors




// Ideen für morgen:
//

// Implementierung der FarbCodes für die Helden
val colorList = listOf(
    GuardiansColors.GAMORA.code,
    GuardiansColors.DRAX.code,
    GuardiansColors.ROCKET.code,
    GuardiansColors.GROOT.code,
    GuardiansColors.PETER.code
)

// Implementierung der FarbCodes für die Gegner
val enemyColorList = listOf(
    GuardiansColors.RONAN.code,
    GuardiansColors.KORATH.code,
)

// Implementierung der FarbCodes für Reset
val resetColor = GuardiansColors.RESET.code

// Tote Helden werden hier eingespeichert und aus der ursprünglichen Liste "ListHeros" gelöscht
var deadHeros: MutableList<Hero> = mutableListOf()


// HELDEN-ATTACKEN (veränderbare Schadenspunkte durch "Gamoras Upgrade-Kit")
// Attacken von Gamora
var attacksGamora: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Tritt", 350),
    AttacksHeros("Kampfkunstattacke", 425),
    AttacksHeros("Wurfwaffe", 200),
    AttacksHeros("Kombikampf", 540),
)
// Attacken von Drax
var attacksDrax: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Hieb", 500),
    AttacksHeros("Messerattacke", 500),
    AttacksHeros("Tritt", 500),
    AttacksHeros("Round-House-Kick", 600)
)
// Attacken von Rocket
var attacksRocket: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Präzisionsschüsse", 500),
    AttacksHeros("Hacking", 500),
    AttacksHeros("Modifizierung", 500),
    AttacksHeros("Bombe", 500),
)
// Attacken von Groot
var attacksGroot: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Astpfeile", 500),
    AttacksHeros("Peitschenäste", 400),
    AttacksHeros("Durchbohren", 550),
    AttacksHeros("Würgen", 400),
)
// Attacken von Peter
var attacksPeter: MutableList<AttacksHeros> = mutableListOf(
    AttacksHeros("Blast", 500),
    AttacksHeros("Manipulieren", 300),
    AttacksHeros("Jet-Pack", 500),
    AttacksHeros("Doppelschuss", 500)
)

// HELDEN
// Name,
// veränderbaren Lebenspunkten,
// den Standartlebenspunkten (Nötig für Berechnung von Groot's Vitaltrunk)
// Rüstungspunkte-Standart (Für Berechnungen)
// Rüstungspunkte (Schützen die Lebenspunkte -> werden bei angriffen abgezogen prozentual, wenn 0 = voller schaden geht auf Lebenspunkte)
// Schnelligkeit -> der schnellste Held greift zuerst an
// Attacken-Liste für den Helden

var gamora: HeroDraxAndGamora = HeroDraxAndGamora("Gamora", 3200, 3200, 400, 400, 135, attacksGamora, colorList[0])
var drax: HeroDraxAndGamora = HeroDraxAndGamora("Drax", 4500, 4500, 550, 550, 100, attacksDrax, colorList[1])
var rocket: HeroRocket = HeroRocket("Rocket", 400, 400, 1400, 1400, 145, attacksRocket, colorList[2])
var groot: HeroGroot = HeroGroot("Groot", 5000, 5000, 5000, 5000, 80, attacksGroot, colorList[3])
var peter: HeroPeter = HeroPeter("Peter Quill (Star-Lord)", 800, 800, 2300, 2300, 140, attacksPeter, colorList[4])

// Zusammenfassung der Helden in eine Liste -> nötig für Spiellogik
var listHeros = mutableListOf(gamora, drax, rocket, groot, peter)

// Rucksack mit Dingen die die Lebenspunkte oder Angriffpunkte erhöhen
// Berechnung findet in Funktion "usingBag" statt
// Sobald "Amount" auf 0 steht, wird der Gegenstand aus dem Rucksack gelöscht
// Sobald keine Gegenstände mehr in dem Rucksack sind, wird der Rucksack nicht mehr in der Auswahl angezegt
// und es wird direkt um eine Auswahl der Attacke gebeten
var bag: MutableList<Bag> = mutableListOf(
    Bag("Groot's Vitaltrunk", 2, 5),
    Bag("Gamoras Upgrade-Kit", 10, 5),
)

// Attacken von Boss Ronan the Accuser
// name der Attacken und den Schadenwert
var attacksBossRonan: MutableList<AttacksEnemy> = mutableListOf(
    AttacksEnemy("Hammer-Schock-Welle", 300),  //0
    AttacksEnemy("Packen", 100),               //1
    AttacksEnemy("Schuss", 350),               //2
    AttacksEnemy("Tritt", 440),                //3
    AttacksEnemy("Hammerhieb", 700),           //4
    AttacksEnemy("Beschwören", null),          //5
)

// Attacken von Boss Korath the Pursuer
// name der Attacken und den Schadenwert
var attacksKorath: MutableList<AttacksEnemy> = mutableListOf(
    AttacksEnemy("Tritt", 440),                //0
    AttacksEnemy("Schuss", 350),               //1
    AttacksEnemy("Doppelschuss", 350),         //2
    AttacksEnemy("Feuer", 350),                //3
)

// Liste der Gegner die sich im Kampf befinden -> werden durch putKorathInFight und ronanInFight hinzugefügt
var inFight: MutableList<Enemy> = mutableListOf()
// Liste der toten Gegner -> werden hinzugefügt sobald Lebenspunkte auf 0 stehen
var deadEnemy: MutableList<Enemy> = mutableListOf()

// GEGNER
// Name,
// veränderbaren Lebenspunkten,
// Rüstungspunkte-Standart (Für Berechnungen)
// Rüstungspunkte (Schützen die Lebenspunkte -> werden bei angriffen abgezogen prozentual, wenn 0 = voller schaden geht auf Lebenspunkte)
// Attacken-Liste für den Helden

var bossRonan: EnemyBossRonan =
    EnemyBossRonan("Ronan the Accuser", 5000, 3500, 2500, attacksBossRonan,
        korathInFight = false,
        korathAlive = true,
        inFight = inFight,
        colorName = enemyColorList[0]
    )
var korath: EnemyKorath =
    EnemyKorath("Korath the Pursuer", 4000, 3500, 1500, attacksKorath,
        korathInFight = false,
        korathAlive = true,
        inFight = inFight,
        colorName = enemyColorList[1]
    )

// Zusammenfassung der Gegner in eine Liste -> nötig für Spiellogik
var enemyList: MutableList<Enemy> = mutableListOf(bossRonan, korath)

// usingBag
// ---> 1 = gibt die gegenstände in val Bag aus, die Amount > 0 haben
// ---> 2 = nimmt die Auswahl auf
// ---> 3 = verändert die Lebenspunkte oder Schadenswerte
fun usingBag(hero: Hero) {
    // ---> 1
    val itemsInBag = bag.filter { it.amount > 0 }.toMutableList()
    // ---> 1
    while (true) {
        for ((index, bagItem) in itemsInBag.withIndex()) {
            println("${index}. ${bagItem.amount}x ${bagItem.name}")
        }

        try {
            // ---> 2
            val itemChoice: Int = readln().toInt()

            if (itemChoice in 0..<itemsInBag.size) {
                val selectedItem = itemsInBag[itemChoice]

                when (itemChoice) {
                    // ---> 3
                    0 -> {
                        println("${hero.name} hat ${hero.lp} Lebenspunkte")
                        println("${hero.name} trinkt ${selectedItem.name}!")
                        println("${hero.name} Lebenspunkte werden um die Hälfte seiner ursprünglichen Lebenspunkte geheilt")
                        if (hero.lp < (hero.lpStandard / 2)) {
                            hero.lp += (hero.lpStandard / selectedItem.value)
                        } else {
                            // falls die Lebenspunkte nicht weniger als die hälfte sind werden sie zum
                            // Standart-wert zurückgesetzt
                            val fullLp = hero.lpStandard
                            hero.lp = fullLp
                        }
                        println("${hero.name} hat nun ${hero.lp} Lebenspunkte!")
                        println()
                        // genutzter Gegenstand wird bei Amount abgezogen
                        selectedItem.amount -= 1
                        if (selectedItem.amount <= 0) {
                            // falls genutzter Gegenstand letzter war, wird er aus dem Rucksack entfernt
                            itemsInBag.remove(selectedItem)
                        }
                        break
                    }
                    // ---> 3
                    1 -> {
                        println("${hero.name} nutzt ${selectedItem.name}")
                        println("${hero.name}'s Attacken werden stärker um 10%")
                        println()
                        for (heroAttack in hero.attacks) {
                            // berechnet 10 % des Schadenswert
                            val plus = (heroAttack.damage!! / 100) * 10
                            print("${heroAttack.name}'s Schaden: ${heroAttack.damage} steigt auf ")
                            // rechnet die 10 % auf den ursprünglichen Schadenswert
                            heroAttack.damage = heroAttack.damage!! + plus
                            println("${heroAttack.damage}")
                        }
                        println()
                        // genutzter Gegenstand wird bei Amount abgezogen
                        selectedItem.amount -= 1
                        if (selectedItem.amount <= 0) {
                            // falls genutzter Gegenstand letzter war, wird er aus dem Rucksack entfernt
                            itemsInBag.remove(selectedItem)
                        }
                        break
                    }
                }
            } else {
                // Safety für falsche Zahlen
                println("Ungültige Auswahl.")
            }
        } catch (e: Exception) {
            // Safety für falsche Eingaben
            println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
        }
    }
}

// Angriffe der Helden
fun fightHeros() {
    // Erstellt Liste für gekämpfte Helden in der Runde
    val fightingHero = mutableListOf<Hero>()
    var continueBattle = true
    // wählt Helden aus -->
    for (chosenHero in listHeros) {
        while (continueBattle && listHeros.isNotEmpty()) {
            // schnellster Held wird zuerst gewählt
            for (hero in listHeros.sortedByDescending { it.speed }) {
                // Alle Gegner tot = Abbruch
                if (inFight.isEmpty()) {
                    break
                }
                if (hero in fightingHero) {
                    continue
                }
                // überprüft ob der Beutel leer ist
                val isBagEmpty = bag.all { it.amount == 0 }
                var playerAction: Int? = null
                // wenn der Beutel nicht leer ist und noch Gegner leben wird die auswahl gegeben
                if (!isBagEmpty && inFight.isNotEmpty()) {
                    println("Es ist ${hero.colorName}${hero.name}'s$resetColor Zug.")
                    println("Was möchtest du tun?")
                    println("1. Kämpfen und Attacke wählen")
                    println("2. Den Beutel nutzen")
                    // safety
                    while (playerAction == null || playerAction < 1 || playerAction > 2) {
                        val input = readln()
                        try {
                            playerAction = input.toInt()

                            if (playerAction < 1 || playerAction > 2) {
                                println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                            }
                        } catch (e: Exception) {
                            println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
                        }
                    }
                    when (playerAction) {
                        1 -> {
                            // auswahl 1 -> attackieren eines Gegners sofern dieser lebt
                            println("Du kämpfst mit ${hero.colorName}${hero.name}$resetColor")
                            println("Welche Attacke willst du ausführen?")
                            println()
                            // gibt mögliche Attacken aus
                            for ((index, attack) in hero.attacks.withIndex()) {
                                println("$index. ${attack.name}")
                            }
                            //safety -> eingabe der auswahl
                            var attackChoice: Int? = null
                            while (attackChoice == null || attackChoice < 0 || attackChoice > 3) {
                                val input = readln()
                                try {
                                    attackChoice = input.toInt()

                                    if (attackChoice < 0 || attackChoice > 3) {
                                        println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                                    }
                                } catch (e: Exception) {
                                    println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
                                }
                            }
                            // 3 Möglichekeiten
                            // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
                            // -----> 2 Boss im Kampf und Helfer im Kampf
                            // -----> 3 Boss gestorben und Helfer im Kampf

                            // -----> 2
                            if (inFight.contains(korath) && inFight.contains(bossRonan)) {
                                // auswahl des Gegners wird gegeben
                                printEnemys(inFight)
                                var chosenEnemy : Int? = null
                                // safety-auswahl
                                while ((chosenEnemy == null) || (chosenEnemy < 0) || (chosenEnemy > 1)){
                                    try {
                                        chosenEnemy = readln().toInt()
                                        if (chosenEnemy in 0..1) {
                                            hero.attackEnemy(
                                                inFight[chosenEnemy],
                                                hero.attacks[attackChoice],
                                                deadEnemy,
                                                inFight
                                            )
                                            fightingHero.add(hero)
                                            // Schleife wird beendet und nächster Held ist an der reihe falls nicht letzter
                                            continueBattle = false
                                        } else {
                                            println("Bitte gebe eine gültige Zahl ein!")
                                        }
                                    } catch (e: Exception) {
                                        println("Bitte gebe eine gültige Zahl ein!")
                                    }
                                }
                            // -----> 3
                            } else if (inFight.contains(korath) && !inFight.contains(bossRonan)){
                                hero.attackEnemy(korath, hero.attacks[attackChoice], deadEnemy, inFight)
                                fightingHero.add(hero)
                                // Schleife wird beendet und nächster Held ist an der reihe falls nicht letzter
                                continueBattle = false
                            // -----> 1
                            } else if (!inFight.contains(korath) && inFight.contains(bossRonan)) {
                                hero.attackEnemy(bossRonan, hero.attacks[attackChoice], deadEnemy, inFight)
                                fightingHero.add(hero)
                                // Schleife wird beendet und nächster Held ist an der Reihe falls nicht letzter
                                continueBattle = false
                            }
                        }
                        // auswahl 2 -> Beutel wird geöffnet sofern dieser noch inhalt hat
                        2 -> {
                            println("Du öffnest deinen Beutel und siehst, was darin ist.")
                            usingBag(hero)
                            fightingHero.add(hero)
                            // Schleife wird beendet und nächster Held ist an der Reihe falls nicht letzter
                            continueBattle = false
                        }

                        else -> {
                            println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                        }
                    }
                // falls Beutel leer ist wird direkt zum Kampf gesprungen
                } else {
                    println("Du kämpfst mit ${hero.colorName}${hero.name}$resetColor")
                    println("Welche Attacke willst du ausführen?")
                    // auflistung der möglichen Attacken
                    for ((index, attack) in hero.attacks.withIndex()) {
                        println("$index. ${attack.name}")
                    }
                    // safety-eingabe
                    var attackChoice: Int? = null
                    while (attackChoice == null || attackChoice < 0 || attackChoice > 3) {
                        try {
                            val input = readln()
                            attackChoice = input.toInt()

                            if (attackChoice < 0 || attackChoice > 3) {
                                println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                            }
                        } catch (e: Exception) {
                            println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
                        }
                    }
                    // ebenfalls 3 Möglichekeiten
                    // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
                    // -----> 2 Boss im Kampf und Helfer im Kampf
                    // -----> 3 Boss gestorben und Helfer im Kampf

                    // -----> 2
                    if (inFight.contains(korath) && inFight.contains(bossRonan)) {
                        printEnemys(enemyList)
                        val chosenEnemy = readln().toInt()
                        var attackChoice2: Int? = null
                        while (attackChoice2 == null || attackChoice2 < 0 || attackChoice2 > 3) {
                            val input = readln()
                            try {
                                attackChoice2 = input.toInt()
                                if (chosenEnemy <= enemyList.size) {
                                    hero.attackEnemy(inFight[chosenEnemy], hero.attacks[attackChoice2], deadEnemy, inFight)
                                    fightingHero.add(hero)
                                    continueBattle = false
                                }
                                if (attackChoice2 < 0 || attackChoice2 > 3) {
                                    println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                                }
                            } catch (e: Exception) {
                                println("Ungültige Eingabe. Bitte gib eine gültige Zahl ein.")
                            }
                        }
                    // -----> 3
                    } else if (inFight.contains(korath) && !inFight.contains(bossRonan)){
                        hero.attackEnemy(korath, hero.attacks[attackChoice], deadEnemy, inFight)
                        fightingHero.add(hero)
                        // Schleife wird beendet und nächster Held ist an der Reihe falls nicht letzter
                        continueBattle = false
                    // -----> 1
                    } else if (!inFight.contains(korath) && inFight.contains(bossRonan)) {
                        hero.attackEnemy(bossRonan, hero.attacks[attackChoice], deadEnemy, inFight)
                        fightingHero.add(hero)
                        // Schleife wird beendet und nächster Held ist an der Reihe falls nicht letzter
                        continueBattle = false
                    }
                }
            }
        }
    }
}

// Angriffe der Gegner
fun fightEnemy() {
    storyLine2()
    println()
    // Wählt zufällige Attacke aus
    val randomAttackRonan = (0..5).random()
    val randomAttackKorath = (0..3).random()

    // 3 Möglichekeiten
    // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
    // -----> 2 Boss im Kampf und Helfer im Kampf
    // -----> 3 Boss gestorben und Helfer im Kampf

    // 2 = Schuss ( simple Attacke )
    if (randomAttackRonan == 2) {
        // -----> 2 Boss im Kampf und Helfer im Kampf
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attacks[2], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attacks[2], deadHeros)
        // -----> 3 Boss gestorben und Helfer im Kampf
        } else {
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        }
        // 0 = Hammer-Schock-Welle ( alle Heros werden attackiert )
    } else if (randomAttackRonan == 0) {
        // -----> 2 Boss im Kampf und Helfer im Kampf
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.shockWave(listHeros, deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)){
            bossRonan.shockWave(listHeros, deadHeros)
        // -----> 3 Boss gestorben und Helfer im Kampf
        } else {
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        }
        // 1 = Packen ( simple Attacke )
    } else if (randomAttackRonan == 1) {
        // -----> 2 Boss im Kampf und Helfer im Kampf
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attacks[1], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)){
            bossRonan.attackSimple(listHeros, bossRonan.attacks[1], deadHeros)
        // -----> 3 Boss gestorben und Helfer im Kampf
        } else {
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        }
        // 3 = Tritt ( simple Attacke )
    } else if (randomAttackRonan == 3) {
        // -----> 2 Boss im Kampf und Helfer im Kampf
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attacks[3], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)){
            bossRonan.attackSimple(listHeros, bossRonan.attacks[3], deadHeros)
        // -----> 3 Boss gestorben und Helfer im Kampf
        } else {
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        }
        // 4 = Hammerhieb ( simple Attacke )
    } else if (randomAttackRonan == 4) {
        // -----> 2 Boss im Kampf und Helfer im Kampf
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attacks[4], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören oder gestorben
        } else if (!inFight.contains(korath) && inFight.contains(bossRonan)) {
            bossRonan.attackSimple(listHeros, bossRonan.attacks[4], deadHeros)
        // -----> 3 Boss gestorben und Helfer im Kampf
        } else {
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        }
        // 5 = Beschwören ( Korath )
    } else if (randomAttackRonan == 5) {
        // -----> 2 Boss im Kampf und Helfer im Kampf
        if (inFight.contains(korath) && inFight.contains(bossRonan)) {
            val alternative = (0..4).random()
            bossRonan.attackSimple(listHeros, bossRonan.attacks[alternative], deadHeros)
            println()
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 1 Boss im Kampf und Helfer wurde noch nicht beschwören und noch am leben
        } else if (!bossRonan.korathIsInFight && bossRonan.korathIsAlive) {
            bossRonan.putKorathInFight(korath)
            bossRonan.korathIsInFight = true
            println()
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 3 Boss gestorben und Helfer im Kampf
        } else if (inFight.contains(korath) && !inFight.contains(bossRonan)) {
            korath.attackSimple(listHeros, korath.attacks[randomAttackKorath], deadHeros)
        // -----> 3 Boss im Kampf und helfer tot
        } else {
            val alternative = (0..4).random()
            bossRonan.attackSimple(listHeros, bossRonan.attacks[alternative], deadHeros)
        }
    }
}

// Ausgabe der Gegner wenn Helfer beschworen
fun printEnemys(enemys: MutableList<Enemy>) {
    for ((index, enemy) in enemys.withIndex()) {
        println("$index: ${enemy.name}")
    }
}

// Main mit schleife ( beendigung wenn -> Alle Gegner tot oder alle Helden tot )
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