package Beutel

import Heros.Hero

class Beutel(
    var name: String,
    var value: Int,
    val maxUses: Int,
    var usableCat: MutableList<Hero>
) {
    private var remainingUses: Int = maxUses

    fun canUse(hero: Hero): Boolean {
        return remainingUses > 0 && hero in usableCat
    }

    fun use() {
        if (remainingUses > 0) {
            remainingUses--
        }
    }
}