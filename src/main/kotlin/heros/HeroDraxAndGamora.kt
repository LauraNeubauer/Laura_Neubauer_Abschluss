package heros

class HeroDraxAndGamora(
    name: String,
    lp: Int,
    lpStandard: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    attacks: MutableList<AttacksHeros>,
) : Hero(name, lp, lpStandard, armor, armorReduction, speed, attacks){}