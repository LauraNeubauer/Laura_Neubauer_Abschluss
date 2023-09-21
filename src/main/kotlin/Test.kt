
fun main() {
    val game = GamePlay(listeDerHelden, rucksack)
    var continueBattle = true
    while (listeDerHelden.isNotEmpty() && continueBattle == true) {
        val gestorben = listeDerHelden.filter { it.lp <= 0 }
        for (helden in gestorben) {
            gestorbeneHelden.add(helden)
            listeDerHelden.remove(helden)
            println("${helden.name} ist gestorben")
        }
        if (listeDerHelden.isNotEmpty()) {

            for (i in 1..5) {
                println("Runde $i:")
                game.zugriffAufBeutel()
            }
        } else {
            println("Alle deine Helden sind im Kampf gestorben")
        }
    }
}
