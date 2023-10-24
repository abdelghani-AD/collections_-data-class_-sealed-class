package Tp3_data_sealed_Class.Joueurs

data class Joueur(val numeroTenue: Int, val nom: String, val pointsCumules: Int)

data class Equipe(val pays: Payé, val sigle: String, val joueurs: List<Joueur>)

fun main() {
    val equipeM = Equipe(Payé.MAROC, "OCS", listOf(Joueur(1, "Joueur1", 30),
        Joueur(2, "Joueur2", 25)))

    val equipeT = Equipe(Payé.TUNISIE, "OCK", listOf(Joueur(3, "Joueur3", 28),
        Joueur(4, "Joueur4", 22)))

    println(equipeM)
    println(equipeT)
}