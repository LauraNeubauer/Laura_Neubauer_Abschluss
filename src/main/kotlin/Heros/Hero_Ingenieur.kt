package Heros

class Hero_Ingenieur(
    name: String,
    lp: Int,
    lpReduction: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    weakness: String,
    attacks: MutableList<Attacke_Heros>,
    hasUsedBeutel: Boolean
) : Hero(name, lp, lpReduction, armor, armorReduction, speed, weakness, attacks, hasUsedBeutel) {
}