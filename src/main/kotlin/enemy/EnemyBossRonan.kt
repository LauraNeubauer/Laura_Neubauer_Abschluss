package enemy

class EnemyBossRonan(
    name: String,
    lp: Int,
    lpStandart: Int,
    armor: Int,
    armorReduction: Int,
    attaken: MutableList<AttacksEnemys> = mutableListOf(),
    korathInFight: Boolean,
    korathAlive: Boolean,
    inFight: MutableList<Enemy>,
    tot: MutableList<Enemy>
) : Enemy(name, lp, lpStandart, armor, armorReduction, attaken, korathInFight, korathAlive, inFight, tot) {
}