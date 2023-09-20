package Enemy

import Heros.Hero

class Enemy_Taktiker(
    name: String,
    lp: Int,
    lpStandart: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    weakness: String,
    attaken: MutableList<Attacke_Enemys> = mutableListOf()
) : Enemy(name, lp, lpStandart, armor, armorReduction, speed, weakness, attaken) {
    fun healEndgegner(enemy: Enemy) {
        val needHealing: Boolean = enemy.lp <= (enemy.lpStandart - 400)
        var healing: Int = enemy.attaken[3].healOrDamage!!
        if (needHealing == true) {
            enemy.lp + healing
            println("${this.name} hat ${enemy.name} um $healing geheilt")
        } else {
            println("${enemy.name} ist nicht verletzt!")
        }
    }
}