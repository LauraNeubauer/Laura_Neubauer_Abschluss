package Heros

class HeroDraxAndGamora(
    name: String,
    lp: Int,
    lpReduction: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    attacks: MutableList<AttacksHeros>,
    hasUsedBag: Boolean,
) : Hero(name, lp, lpReduction, armor, armorReduction, speed, attacks, hasUsedBag){}