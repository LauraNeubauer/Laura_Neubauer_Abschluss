import Beutel.Beutel
import Heros.Hero
import kotlin.random.Random

class GamePlay(
    private val players: List<Hero>,
    private val rucksack: MutableList<Beutel>
) {
    private var currentPlayerIndex: Int = 0

    fun zugriffAufBeutel() {
        val currentPlayer = players[currentPlayerIndex]
        val beutel = rucksack.find { it.canUse(currentPlayer) }

        if (beutel != null) {
            currentPlayer.useBeutel(beutel)
            println("${currentPlayer.name} hat ${beutel.name} verwendet.")
        } else {
            println("${currentPlayer.name} konnte keinen Beutel verwenden.")
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size
    }
}