package Tp3_data_sealed_Class.Joueurs

data class Joueurs(val nom: String, val numero: Int, val equipe: Equipes, val points: Int)

enum class Equipes (){ OCS, OCK }

fun main() {
    val joueurs = mutableListOf(
        Joueurs("Joueur1", 1, Equipes.OCS, 10),
        Joueurs("Joueur2", 2, Equipes.OCK, 12),
        Joueurs("Joueur3", 3, Equipes.OCS, 8)
    )
    joueurs.add(Joueurs("Joueur4", 4, Equipes.OCK, 15))

    for(j in joueurs){
        println(j)
    }
}
