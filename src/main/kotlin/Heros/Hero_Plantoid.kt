package Heros

class Hero_Plantoid(
    name : String,
    lp : Int,
    lpReduction : Int,
    armor : Int,
    armorReduction : Int,
    speed : Int,
    weakness : String,
    attacke1 : Attacke_Heros,
    attacke2 : Attacke_Heros,
    attacke3 : Attacke_Heros,
    attacke4 : Attacke_Heros,
) : Hero(name, lp, lpReduction, armor, armorReduction, speed, weakness, attacke1, attacke2, attacke3, attacke4){

    fun healHero(hero: Hero) {
        val needHealing : Boolean = hero.lp <= (hero.lpReduction - 400)
        var healing : Int = this.attacke4.healOrdamage
        if (needHealing == true) {
            hero.lp + healing
            println("${this.name} hat ${hero.name} um $healing geheilt")
        } else {
            println("${hero.name} ist nicht verletzt!")
        }
    }
}