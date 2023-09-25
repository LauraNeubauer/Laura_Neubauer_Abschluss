package Heros

class HeroGroot(
    name: String,
    lp: Int,
    lpReduction: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    attacks: MutableList<AttacksHeros>,
) : Hero(name, lp, lpReduction, armor, armorReduction, speed, attacks) {}