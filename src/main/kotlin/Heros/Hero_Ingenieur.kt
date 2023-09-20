package Heros

class Hero_Ingenieur(
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
}