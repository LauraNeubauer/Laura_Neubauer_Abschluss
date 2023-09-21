package Enemy

class Enemy_Taktiker(
    name: String,
    lp: Int,
    lpStandart: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    weakness: String,
    attaken: MutableList<Attacke_Enemys>,
    helferBeschworen: Boolean,
    helperAlive: Boolean,
    inFight: MutableList<Enemy>,
    tot: MutableList<Enemy>
) : Enemy(name, lp, lpStandart, armor, armorReduction, speed, weakness, attaken, helferBeschworen, helperAlive, inFight, tot) {
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