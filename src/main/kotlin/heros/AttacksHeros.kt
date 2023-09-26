package heros

// Klasse der Attacken für die Gegner mit Schadenwert und Namen der Attacken
class AttacksHeros(var name: String, var damage: Int?) {
    override fun toString(): String {
        return name
    }
}

