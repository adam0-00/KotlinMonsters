import dresseur.Entraineur
import monstre.EspeceMonstre.EspeceMonstre

var joueur = Entraineur(1,"Sacha",100)
var rival = Entraineur(2,"Regis",200)
var springleaf = EspeceMonstre(1,"springleaf","Graine",60,9,11,10,12,14,34.0,6.5,9.0,8.0,7.0,10.0,"Petit monstre espiègle rond comme une graine, adore le soleil.","Sa feuille sur la tête indique son humeur.","Curieux, amical, timide")
var flamkip = EspeceMonstre(4,"Flamkip","Animal",50,12,8,13,16,7,22.0,10.0,5.5,9.5,9.5,6.5,"Petit monstre espiègle rond comme une graine, adore le soleil.","Sa feuille sur la tête indique son humeur.","Curieux, amical, timide")
var aquamy = EspeceMonstre()

fun main() {



    joueur.afficheDetail()
    rival.afficheDetail()
    joueur.argents+=50
    joueur.afficheDetail()
    println(springleaf.afficheArt())
    println(flamkip.afficheArt())




}

/**
 * Change la couleur du message donné selon le nom de la couleur spécifié.
 * Cette fonction utilise les codes d'échappement ANSI pour appliquer une couleur à la sortie console. Si un nom de couleur
 * non reconnu ou une chaîne vide est fourni, aucune couleur n'est appliquée.
 *
 * @param message Le message auquel la couleur sera appliquée.
 * @param couleur Le nom de la couleur à appliquer (ex: "rouge", "vert", "bleu"). Par défaut c'est une chaîne vide, ce qui n'applique aucune couleur.
 * @return Le message coloré sous forme de chaîne, ou le même message si aucune couleur n'est appliquée.
 */

fun changeCouleur(message: String, couleur:String=""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"
}
