package Tp3_data_sealed_Class.Joueurs

//creation d'un class Joueures de Basket Ball
data class Joueure(val numT: Int, val nom: String, var points: Int)

//Créer l’énumération Pays avec les différents pays participants
//à la compétition
enum class Payé { MAROC, TUNISIE, EGYPTE, ALGERIE, MAURITANIE }
//Crée enumuration de Sigle
enum class Siglee(){ OCS,OCK,WAC,RAC }
//3.Créer la classe Equipe
data class Equipee(val pays: Payé, val sigle: Siglee, val joueurs: MutableList<Joueure>) {
    //methode qui ajouter un joueur d'un liste de joueures
    fun ajouter(j: Joueure): Boolean {
        for(i in joueurs){
            if (i.numT != j.numT){
                joueurs.add(j)
                return true
            }
        }
        return false
    }
    //methode qui rechercher un joueures d'un liste de joueures
    fun recherche(j: Joueure): Int {
        for (i in joueurs){
            if (i.numT == j.numT){
                return joueurs.indexOf(i)
            }
        }
        return -1
    }
    //methode qui supprimer un joueure dans la liste
    fun suppression(j: Joueure): Boolean {
        for (i in joueurs){
            if (i.numT == j.numT){
                joueurs.remove(i)
                return true
            }
        }
        return false
    }
    //methode setPoints qui modifie les points du joueur
    fun setPoints(j: Joueure, points: Int) {
        val index = recherche(j)
        if (index != -1) {
            joueurs[index].points = points
        }
    }
    //afficher les informations de joueure
    fun affichage() {
        println("Équipe $sigle de payé ${pays.name} :")
        for (joueur in joueurs) {
            println(" ==> ${joueur.nom} de numéro  ${joueur.numT} , points ${joueur.points} .")
        }
    }
}
fun main() {
    //declarer un liste de joueures
    var listeJoueur = mutableListOf<Joueure>()

    //a.Créer une liste des équipes avec quatre équipes de quatre pays différents,
    var j1 = Joueure(21,"Ahmed",30)
    var j2 = Joueure(13,"Yassin",18)
    var j3 = Joueure(17,"Ilyas",26)
    var j4 = Joueure(10,"Otman",15)

    //ajouter les joueures dans la liste
    listeJoueur.add(j1)
    listeJoueur.add(j2)
    listeJoueur.add(j3)
    listeJoueur.add(j4)

    //Manipuler les equipes et les joueurs afin de tester les méthodes qu’on vient de créer
    val equipeMaroc = Equipee(Payé.MAROC, Siglee.OCS, mutableListOf(j1,j2))
    val equipeTunisie = Equipee(Payé.TUNISIE, Siglee.OCK, mutableListOf(j3,j4))
    val equipeEgypte = Equipee(Payé.EGYPTE, Siglee.WAC, mutableListOf(Joueure(14, "Ali", 40), Joueure(16, "Mohammed", 19)))
    val equipeAlgerie = Equipee(Payé.ALGERIE, Siglee.RAC,mutableListOf(Joueure(27, "Salah", 35), Joueure(28, "Ossama", 25)))
    //afficher les informations de joueurs avant la modification des points
    equipeMaroc.affichage()
    equipeTunisie.affichage()
    equipeEgypte.affichage()
    equipeAlgerie.affichage()
    println()
    //afficher les informations de joueurs après  la modification des pionts
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



