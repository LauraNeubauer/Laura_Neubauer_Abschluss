import Beutel.Bag
import Heros.Hero

class GamePlay(
    private val players: List<Hero>,
    private val rucksack: MutableList<Bag>
) {
    private var currentPlayerIndex: Int = 0
}