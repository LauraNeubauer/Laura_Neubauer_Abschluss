package enemy

class EnemyBossRonan(
    name: String,
    lp: Int,
    armor: Int,
    armorReduction: Int,
    attacks: MutableList<AttacksEnemy> = mutableListOf(),
    korathInFight: Boolean,
    korathAlive: Boolean,
    inFight: MutableList<Enemy>,
) : Enemy(name, lp, armor, armorReduction, attacks, korathInFight, korathAlive, inFight) {
}