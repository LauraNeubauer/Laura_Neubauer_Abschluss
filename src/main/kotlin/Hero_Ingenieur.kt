class Hero_Ingenieur(
    name : String,
    lp : Int,
    armor : Int,
    armorReduction : Int,
    speed : Int,
    weakness : String,
    attacke1 : Attacke_Heros,
    attacke2 : Attacke_Heros,
    attacke3 : Attacke_Heros,
    attacke4 : Attacke_Heros,
    gestorben : Boolean
) : Hero (name, lp, armor, armorReduction, speed, weakness, attacke1, attacke2, attacke3, attacke4, gestorben){
}