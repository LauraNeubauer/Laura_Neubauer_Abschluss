package Heros

class HeroPeter(
    name: String,
    lp: Int,
    lpReduction: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    weakness: String,
    attacks: MutableList<AttacksHeros>,
    hasUsedBeutel: Boolean,
    cursed: Boolean
) : Hero(name, lp, lpReduction, armor, armorReduction, speed, weakness, attacks, hasUsedBeutel, cursed) {
}