package Heros

class Hero_Plantoid(
    name: String,
    lp: Int,
    lpReduction: Int,
    armor: Int,
    armorReduction: Int,
    speed: Int,
    weakness: String,
    attacks: MutableList<Attacke_Heros>
) : Hero(name, lp, lpReduction, armor, armorReduction, speed, weakness, attacks) {

    fun healHero(hero: Hero) {
        val needHealing: Boolean = hero.lp <= (hero.lpReduction - 400)
        var healing: Int = this.attacks[3].healOrdamage!!
        if (needHealing == true) {
            hero.lp + healing
            println("${this.name} hat ${hero.name} um $healing geheilt")
        } else {
            println("${hero.name} ist nicht verletzt!")
        }
    }
}