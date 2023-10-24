package Tp3_data_sealed_Class.Joueurs

data class Joueures(val nom: String, val numero: Int, val equipe: String, val points: Int)

fun main() {
    val joueurs = mutableListOf(
        Joueures("Joueur1", 1, "OCS", 10),
        Joueures("Joueur2", 2, "OCK", 12),
        Joueures("Joueur3", 3, "OCS", 8)
    )
    joueurs.add(Joueures("Joueur4", 4, "OCK", 15))

    for(i in joueurs){
        println(i)
    }
}