package Enemy

class EnemyBossRonan(
    name: String,
    lp: Int,
    lpStandart: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    weakness: String,
    attaken: MutableList<AttacksEnemys> = mutableListOf(),
    helferBeschworen: Boolean,
    helferLebt: Boolean,
    inFight: MutableList<Enemy>,
    tot: MutableList<Enemy>
) : Enemy(name, lp, lpStandart, armor, armorReduction, speed, weakness, attaken, helferBeschworen, helferLebt, inFight, tot) {
}