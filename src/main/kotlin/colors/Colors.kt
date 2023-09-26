package colors


// Farben ausgewählt nach der "Haut"-Farbe der Helden in Guardians of the Galaxy
// um die Namen schneller zu erkennen und besser unterscheiden zu können.
enum class GuardiansColors(val code: String) {
    GROOT("\u001B[38;5;94m"),
    DRAX("\u001B[38;5;146m"),
    GAMORA("\u001B[38;5;2m"),
    PETER("\u001B[38;2;255;204;204m"),
    ROCKET("\u001B[38;5;240m"),
    RONAN("\u001B[38;5;33m"),
    KORATH("\u001B[38;5;101m"),
    RESET("\u001B[0m");
}

