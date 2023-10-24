package Tp3_data_sealed_Class.Joueurs

data class Joueure(val numT: Int, val nom: String, var points: Int)
enum class Payé { MAROC, TUNISIE, EGYPTE, ALGERIE, MAURITANIE }
enum class Siglee(){ OCS,OCK,WAC,RAC }
data class Equipee(val pays: Payé, val sigle: Siglee, val joueurs: MutableList<Joueure>) {
    fun ajouter(j: Joueure): Boolean {
        for(i in joueurs){
            if (i.numT != j.numT){
                joueurs.add(j)
                return true
            }
        }
        return false
    }
    fun recherche(j: Joueure): Int {
        for (i in joueurs){
            if (i.numT == j.numT){
                return joueurs.indexOf(i)
            }
        }
        return -1
    }
    fun suppression(j: Joueure): Boolean {
        for (i in joueurs){
            if (i.numT == j.numT){
                joueurs.remove(i)
                return true
            }
        }
        return false
    }
    fun setPoints(j: Joueure, points: Int) {
        val index = recherche(j)
        if (index != -1) {
            joueurs[index].points = points
        }
    }
    fun affichage() {
        println("Équipe $sigle de payé ${pays.name} :")
        for (joueur in joueurs) {
            println(" ==> ${joueur.nom} de numéro  ${joueur.numT} , points ${joueur.points} .")
        }
    }
}
fun main() {
    var listeJoueur = mutableListOf<Joueure>()
    var j1 = Joueure(21,"Ahmed",30)
    var j2 = Joueure(13,"Yassin",18)
    var j3 = Joueure(17,"Ilyas",26)
    var j4 = Joueure(10,"Otman",15)
    listeJoueur.add(j1)
    listeJoueur.add(j2)
    listeJoueur.add(j3)
    listeJoueur.add(j4)
    val equipeMaroc = Equipee(Payé.MAROC, Siglee.OCS, mutableListOf(j1,j2))
    val equipeTunisie = Equipee(Payé.TUNISIE, Siglee.OCK, mutableListOf(j3,j4))
    val equipeEgypte = Equipee(Payé.EGYPTE, Siglee.WAC, mutableListOf(Joueure(14, "Ali", 40), Joueure(16, "Mohammed", 19)))
    val equipeAlgerie = Equipee(Payé.ALGERIE, Siglee.RAC,mutableListOf(Joueure(27, "Salah", 35), Joueure(28, "Ossama", 25)))
    equipeMaroc.affichage()
    equipeTunisie.affichage()
    equipeEgypte.affichage()
    equipeAlgerie.affichage()
    println()
    equipeMaroc.setPoints(j1,34)
    equipeMaroc.setPoints(j2,20)
    equipeTunisie.setPoints(j3,28)
    equipeTunisie.setPoints(j4,17)
//supprimer les joueures j2 et j4
    equipeMaroc.suppression(j2)
    equipeTunisie.suppression(j4)
//ajouter un joueur en equipe maroc et equipe algerie
    equipeMaroc.ajouter(Joueure(50,"Abdelghani",40))
    equipeAlgerie.ajouter(Joueure(45,"Aymen",32))
//afficher les equipes maroc et tunisie
    equipeMaroc.affichage()
    equipeTunisie.affichage()
    equipeAlgerie.affichage()
    println()
}



