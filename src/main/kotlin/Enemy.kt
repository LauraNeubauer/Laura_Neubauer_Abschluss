open class Enemy(
    var name : String,
    var lp : Int,
    var armor : Int,
    var armorReduction : Int,
    var speed : Int,
    var weakness : String,
) {
    fun HammerSchockWelle( heroes : List<Hero>) {
        for ( hero in heroes ) {
            println("${this.name} hat ${hero.name} um 300 Lebenspunkte verletzt!!")
            println("${hero.name} hat noch ${hero.lp} Lebenspunkte")
            hero.lp -= 300
        }
    }
    fun Packen(hero: Hero) {
        val initialHP = hero.lp
        var currentHP = hero.lp
        while (currentHP > 0.2 * initialHP) {
            println("${this.name} hat ${hero.name} 10% Lebenspunkte entrissen!")
            println("${hero.name} hat noch ${hero.lp} Lebenspunkte!")
            currentHP = (currentHP * 0.9).toInt()
        }
        hero.lp = currentHP
    }
}