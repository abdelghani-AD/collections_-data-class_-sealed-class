package Tp3_data_sealed_Class.Joueurs

// 1. Créer la data classe Etape
data class Etape(val nom: String, val dateDebut: String, val dateFin: String, val distance: Int, val difficulte: Difficulty)
enum class Difficulty(){Facile,Difficile}
// 2. Dans la classe Resultat, créer deux data classes :
sealed class Resultat {
//Data class termine avec comme paramètres tempsEffectue(int) et classement(int
    data class Termine(val tempsEffectue: Int, val classement: Int) : Resultat()
//Data class abandonne avec comme paramètres distanceParcourue(int) et raison(string
    data class Abandonne(val distanceParcourue: Int, val raison: String) : Resultat()
}

// 3. Créer la classe Cycliste
data class Cycliste(val nom: String, val prenom: String, val nationalite: String, val age: Int){
    val historiqueEtapes = HashMap<Etape, Resultat>()
//Ajouter une méthode nouvelleEtape()
    fun nouvelleEtape(etape: Etape, resultat: Resultat) {
        historiqueEtapes[etape] = resultat
    }
//Redéfinie la méthode toString pour afficher les informations du cycliste et des étapes qu’il a déjà passé
    override fun toString(): String {
        val historique = historiqueEtapes.entries.joinToString("\n") { (etape, resultat) ->
            "le nom : ${etape.nom} (date debut : ${etape.dateDebut} , date fin : ${etape.dateFin}), resultat ->  $resultat"
        }
        return "Cycliste: $prenom $nom Nationalité: $nationalite Âge: $age \n Historique des étapes:\n$historique"
    }
}
fun main() {
    var c = Cycliste("Ahmed","Bouguilem","MAROC",22)

    var e1 = Etape("Aymen","2023-10-28","2023-12-18",120,Difficulty.Facile)
    var e2 = Etape("Hicham","2023-11-02","2024-01-10",80,Difficulty.Difficile)
    var e3 = Etape("Ayoub","2023-9-20","2023-10-29",50,Difficulty.Facile)
    var e4 = Etape("Bader","2022-08-23","2023-12-27",230,Difficulty.Difficile)

    var r1 = Resultat.Termine(20,3)
    var r2 = Resultat.Abandonne(200,"problème de distance")
    var r3 = Resultat.Termine(18,6)
    var r4 = Resultat.Abandonne(87,"problème de temps")
    c.nouvelleEtape(e1,r1)
    c.nouvelleEtape(e2,r2)
    c.nouvelleEtape(e3,r3)
    c.nouvelleEtape(e4,r4)
    println(c)
}
