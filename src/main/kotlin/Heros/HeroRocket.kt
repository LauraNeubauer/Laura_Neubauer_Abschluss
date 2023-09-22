package Heros

class HeroRocket(
    name: String,
    lp: Int,
    lpReduction: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    weakness: String,
    attacks: MutableList<AttacksHeros>,
    hasUsedBeutel: Boolean
) : Hero(name, lp, lpReduction, armor, armorReduction, speed, weakness, attacks, hasUsedBeutel) {
}