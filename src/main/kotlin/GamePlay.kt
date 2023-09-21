import Beutel.Beutel
import Heros.Hero
import kotlin.random.Random

class GamePlay(
    private val players: List<Hero>,
    private val rucksack: MutableList<Beutel>
) {
    private var currentPlayerIndex: Int = 0
}