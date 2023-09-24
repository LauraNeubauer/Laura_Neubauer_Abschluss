package Enemy

class EnemyKorath(
    name: String,
    lp: Int,
    lpStandart: Int,
    armor: Int,
    armorReduction: Int,
    attaken: MutableList<AttacksEnemys>,
    korathInFight: Boolean,
    korathAlive: Boolean,
    inFight: MutableList<Enemy>,
    dead: MutableList<Enemy>
) : Enemy(name, lp, lpStandart, armor, armorReduction, attaken, korathInFight, korathAlive, inFight, dead) {
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