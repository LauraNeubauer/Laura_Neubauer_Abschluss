import Beutel.Beutel
import Enemy.Attacke_Enemys
import Enemy.Enemy
import Enemy.Enemy_Taktiker
import Enemy.Enemy_Übernatürlicher
import Heros.*

/*
Grundlagen der Programmierung
Abschlussaufgabe
Hinweis: Lies die Aufgabe aufmerksam. Versuche vor Beginn, die Aufgabe zu strukturieren. Notiere
dir skizzenartig, was dein Programm braucht und setze deinen Plan Schritt für Schritt um.

1. Szenario
Du bist neuerdings App-Developer und bekommst deinen ersten Auftrag: Du sollst das neue
Videospiel „Golden Syntax“ mitentwickeln. Bei diesem Spiel handelt es sich um ein RPG (Rollenspiel)
mit Kämpfen gegen NPCs (computergesteuerte Charaktere). In deinem Developer-Team wird dir die
Aufgabe zugeteilt, das rundenbasierte Kampfsystem zu entwickeln. Danach sollst du dem Team dein
Kampfsystem anhand eines Beispielkampfes gegen den Endgegner vorstellen.

2. Details
Erstelle ein neues Projekt in IntelliJ. Es gibt eine main.kt, in der das Spiel abläuft. Alle Klassen
erhalten jeweils eine eigene Datei. Funktionen kannst du zusammen in eine Datei verlagern.
Informationen zu den Helden:
● Es gibt ein Team von drei Helden, die gemeinsam als Team in dem Kampf antreten sollen.
● Die Helden können zum Beispiel Magier, Krieger oder Ähnliches sein. Alle Arten von Helden
sollen eine eigene Klasse erhalten, die von einer allgemeinen Klasse Held erben.
● Sie alle sollen unterschiedliche Eigenschaften bzw. Werte haben:
Einen Namen, HP (Gesundheitspunkte) und vier Aktionen
● Beispiele für Aktionen:
Angriffe mit unterschiedlichen Schadenswerten, Heilungsmöglichkeiten, oder Schutzzauber,
die einen Helden einmalig vor dem nächsten Angriff schützen.
● Deine Heldengruppe hat einen Beutel. Dieser kann einmalig pro Runde genutzt werden.
Wenn du ihn benutzt, kann ein Held aus deinem Team in dieser Runde keine weitere Aktion
ausführen. In dem Beutel sind Gegenstände, die einen direkten Effekt auswirken, z.B.:
o 3x Heiltrank: heilt einen frei wählbaren Helden um die Hälfte seiner Lebenspunkte
o 1x Vitamine: erhöhen den Schadenswert für einen Helden dauerhaft um 10%.

Informationen zum Endgegner:
● Dieser kann beispielsweise ein Dunkler Magier oder ein Drache sein.
● Auch er hat gewisse Eigenschaften: (Hohe) HP und sechs mögliche Aktionen.
● Besonderheiten zu seinen Aktionen:
o Eine Aktion (z.B. ein Feueratem) verursacht Flächenschaden. D.h. dass diese Aktion
alle Helden gleichzeitig trifft und allen Helden Schaden zufügt.
o Eine Aktion ist ein Fluch oder Ähnliches. Dieser soll maximal einen der Helden
betreffen und von diesem Helden solange die HP um 10% pro Runde verringeren, bis
die HP des entsprechenden Helden weniger als 20% seiner gesamten HP beträgt.
o Eine andere Aktion bewirkt, dass ein Unterboss (= Helfer) beschworen wird. Auch
dieser hat eigene (geringere) HP und vier mögliche Aktionen, um den Endgegner im
Kampf zu unterstützen. Wird der Helfer beschworen, muss auch dieser von den
Helden besiegt werden, um zu gewinnen.
Diese Aktion kann jedoch maximal einmal pro Kampf ausgeführt werden!
● Sowohl der Endgegner als auch der Unterboss sollen eine eigene Klasse erhalten, die von
einer allgemeinen Klasse Gegner erben.
Informationen zum Kampfsystem:
● Es ist rundenbasiert. D.h. die einzelnen Mitglieder deines Heldenteams führen nacheinander
eine Aktion aus und danach führt der Endgegner eine Aktion aus. Dies läuft so lange, bis die
HP aller einzelnen Teammitglieder oder des Endgegner(-teams) auf 0 sinken.
● Nachdem sowohl dein Team als auch das Gegnerteam jeweils eine Aktionen durchgeführt
hat, endet die Runde und der Kampf geht in die nächste Runde.
● Die Aktionen des Gegners werden völlig zufällig aus seinem Pool an möglichen Aktionen
ausgewählt.
● Die Aktionen der Helden werden mit einer Eingabe auf der Konsole ausgewählt.
Das bedeutet, du wirst in der Konsole jede Runde gefragt, welche Aktion du für jeden deiner
Helden durchführen möchtest.
● In der Konsole wird außerdem jede Runde geschrieben, welche Aktion der Gegner
ausgeführt hat und ggf. wie viele HP die betroffenen Helden / Gegner noch übrig haben. Ziel
ist hierbei vor allem, dass man als Nutzer des Programms erfährt, was gerade im Kampf
passiert.

3. Optionale, freiwillige Ergänzungen und Anmerkungen
Selbstverständlich darfst du dein Spiel mit deinen eigenen Ideen weiter ausschmücken.
Einige Ideen zur Erweiterung:
● Du kannst kritische Treffer implementieren.
D.h. dass Angriffe mit einer Wahrscheinlichkeit von 5% doppelten Schaden verursachen.
● Wenn du magst, kannst du auch sogenannte „Stats“ bei deinen Helden und Gegnern
einfügen. Stats könnten z.B. ein Grundschadenswert, Schnelligkeit (= Reihenfolge, in der die
Helden und Gegner ihre Aktionen durchführen), Rüstungswert und ähnliches sein. Der
Verteidigungswert könnte z.B. einen Angriff auf den betroffenen Charakter um seinen Wert
verringern.
● Noch komplexer wird es, wenn du unterschiedliche Stärken und Schwächen einbinden
möchtest. So könnten z.B. deine Helden und Gegner bestimmten Elementartypen
angehören. Wasserzauber könnten zum Beispiel gegen Feuertypen grundsätzlich mehr
Schaden verursachen – andersherum würde Feuer gegen Wasser nur einen verringerten
Schaden verursachen.

4. Eigene Projektideen
Du darfst natürlich auch kreativ sein und ein ganz eigenes Programm schreiben.
Voraussetzungen hierfür sind, dass der Aufwand in etwa vergleichbar ist mit der o.g. Aufgabe und
dass gewisse Grundfunktionalitäten wie Klassen, Vererbung, Schleifen, Verzweigungen und
Funktionen genutzt werden.
Eigene Projekte sind nur in Absprache mit dem Dozent erlaubt!
*/

// Guardians of the Galaxy
// Team : Peter Quill (Star-Lord), Gamora, Drax der Zerstörer, Rocket, Groot

// Taktiker                 // Peter Quill (Star-Lord) : Blast / Ablenken / Jet-Pack / Doppelschuss
//                             800 ( 2300 Rüstung / Schnelligkeit : 140 % / Schwäche : Nahkampf )
// Nahkämpfer               // Gamora : Tritt / Kampfkunstattacke / Wurfwaffe / Kombikampf
//                             3200 ( 400 Rüstung / Schnelligkeit : 135 % / Schwäche : Taktiker )
// Nahkämpfer               // Drax : Hieb / Messerattacke / Tritt / Spürsinn
//                             4500 ( 550 Rüstung / Schnelligkeit : 100 % / Schwäche : Taktiker )
// Ingenieur                // Rocket : Präzisionsschüsse / Hacking / Modifizierung / Bombe
//                             400  ( 1400 Rüstung / Schnelligkeit : 145 % / Schwäche : Nahkampf )
// Plantoid                 // Groot : Formwandel / Schutz / Heilung-der-Natur / Pfeile
//                             5000 ( 5000 Rüstung / Schnelligkeit : 80 % / Schwäche : Nahkämpfer )

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

//  5 x Groot's Vitaltrank : Alle Kategorien : heilt um die Hälfte seiner Lebenspunkte
//  1 x Elementar Kristalle : Alle Kategorien : erhöhen den Schadenswert für einen Helden dauerhaft um 10%
//  1 x Star-Lord's Mixtape : Taktiker : verdoppelt den Schaden der nächsten Attacke
//  1 x Ingenieurshandbuch : Ingenieur : verdoppelt den Schaden der nächsten Attacke
//  1 x Kampfhandschuhe : Nahkämpfer : erhöhen den Schadenswert für einen Helden dauerhaft um 10%

var rucksack: MutableList<Beutel> = mutableListOf(
    Beutel("Groot's Vitalttrank", 2,4, listeDerHelden),
    Beutel("Elementar Kristalle", 10, 4,listeDerHelden),
    Beutel("Star-Lord's Mixtape", 2, 4,taktikerListe),
    Beutel("Ingeneurshandbuch", 2, 4,ingenieurListe),
    Beutel("Kampfhandschuhe", 10, 4,nahkaempferListe)
)

/*
// Packen
o Eine Aktion ist ein Fluch oder Ähnliches. Dieser soll maximal einen der Helden
betreffen und von diesem Helden solange die HP um 10% pro Runde verringeren, bis
die HP des entsprechenden Helden weniger als 20% seiner gesamten HP beträgt.
// Korath the Pursuer wird gerufen
o Eine andere Aktion bewirkt, dass ein Unterboss (= Helfer) beschworen wird. Auch
dieser hat eigene (geringere) HP und vier mögliche Aktionen, um den Endgegner im
Kampf zu unterstützen. Wird der Helfer beschworen, muss auch dieser von den
Helden besiegt werden, um zu gewinnen.
Diese Aktion kann jedoch maximal einmal pro Kampf ausgeführt werden!

Informationen zum Kampfsystem:
● Es ist rundenbasiert. D.h. die einzelnen Mitglieder deines Heldenteams führen nacheinander
eine Aktion aus und danach führt der Endgegner eine Aktion aus. Dies läuft so lange, bis die
HP aller einzelnen Teammitglieder oder des Endgegner(-teams) auf 0 sinken.
● Nachdem sowohl dein Team als auch das Gegnerteam jeweils eine Aktionen durchgeführt
hat, endet die Runde und der Kampf geht in die nächste Runde.
● Die Aktionen des Gegners werden völlig zufällig aus seinem Pool an möglichen Aktionen
ausgewählt.
● Die Aktionen der Helden werden mit einer Eingabe auf der Konsole ausgewählt.
Das bedeutet, du wirst in der Konsole jede Runde gefragt, welche Aktion du für jeden deiner
Helden durchführen möchtest.
● In der Konsole wird außerdem jede Runde geschrieben, welche Aktion der Gegner
ausgeführt hat und ggf. wie viele HP die betroffenen Helden / Gegner noch übrig haben. Ziel
ist hierbei vor allem, dass man als Nutzer des Programms erfährt, was gerade im Kampf
passiert.
*/

/*
Sakaarans: Die Sakaarans sind die ersten Gegner, denen die Guardians begegnen.
Sie kämpfen gegen die Guardians während des Angriffs auf Morag, als Star-Lord den Orb stiehlt.

Nebula: Nebula ist die Adoptivtochter von Thanos und arbeitet für Ronan.
Sie tritt mehrmals gegen Gamora und die Guardians an.

Ronan the Accuser: Ronan ist der Hauptantagonist des Films und die größte Bedrohung.
Er ist ein Kree-Fanatiker und derjenige, der den Orb, der den Infinity-Stein enthält,
für seine eigenen Zwecke nutzen will. Die Guardians konfrontieren ihn in der finalen Schlacht des Films.
Korath the Pursuer: Korath ist ein Söldner im Dienst von Ronan und tritt gegen die Guardians an,
als sie auf Xandar auf Ronan treffen.
*/

// Übernatürlicher            // Ronan the Accuser : Hammer-Schock-Welle / Packen / Korath the Pursuer wird gerufen / Tritt / Hammerhieb / Schuss
//                             3500 ( 2500 Rüstung / Schnelligkeit : 120 % / Schwäche : Taktiker )
// Taktiker                 // Korath the Pursuer : Schuss / Doppelschuss / Tritt / Heilungsblitz
//                             1000 ( 1500 Rüstung / Schnelligkeit : 110 % / Schwäche : Nahkampf )

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

var endgegner_ronan: Enemy_Übernatürlicher =
    Enemy_Übernatürlicher("Ronan the Accuser", 3500, 3500, 2500, 2500, 120, "Taktiker", attacken_endgegner_ronan, false, true, inFight, toteEndgegner)
var helfer_Endgegner: Enemy_Taktiker =
    Enemy_Taktiker("Korath the Pursuer", 1000, 3500, 1500, 1500, 110, "Nahkampf", attacken_helfer, false, true, inFight, toteEndgegner)


fun main(){
    println()
    val game = GamePlay(listeDerHelden, rucksack)
    var continueBattle = true
    endgegner_ronan.EndgegnerinFight(endgegner_ronan)
    for (held in listeDerHelden){
        while (continueBattle && listeDerHelden.isNotEmpty()) {
            println("Was möchtest du tun?")
            println("1. Kämpfen und Attacke wählen")
            println("2. Den Beutel nutzen")
            val spielerAktion = readln()
            when (spielerAktion) {
                "1" -> {
                    val schnellsterHeld : Hero? = listeDerHelden.maxByOrNull { it.speed }
                    println("Du kämpfst zuerst mit ${schnellsterHeld!!.name}")
                    println("Welche Attacke willst du ausführen?")
                    println(listeDerHelden[0].attacks.toList())
                    val gestorben = listeDerHelden.filter { it.lp <= 0 }
                    for (helden in gestorben) {
                        gestorbeneHelden.add(helden)
                        listeDerHelden.remove(helden)
                        println("${helden.name} ist gestorben")
                    }
                }
                "2" -> {
                    println("Du öffnest deinen Beutel und siehst, was darin ist.")
                    for (i in 1..5) {
                        println("Runde $i:")
                        game.zugriffAufBeutel()
                    }
                }
                "3" -> {
                    println("Du gibst auf und verlässt den Kampf.")
                    break
                }
                else -> {
                    println("Ungültige Auswahl. Bitte wähle eine der verfügbaren Optionen.")
                }
            }
    }
}}


