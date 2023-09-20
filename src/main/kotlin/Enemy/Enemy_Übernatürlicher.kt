package Enemy

class Enemy_Übernatürlicher(
    name : String,
    lp : Int,
    lpStandart : Int,
    armor : Int,
    armorReduction : Int,
    speed : Int,
    weakness : String,
    attaken : MutableList<Attacke_Enemys> = mutableListOf()
) : Enemy(name, lp, lpStandart, armor, armorReduction, speed ,weakness, attaken){
}