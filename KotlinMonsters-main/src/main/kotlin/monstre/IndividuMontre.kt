package monstre

import dresseur.Entraineur
import monstre.EspeceMonstre.EspeceMonstre

class IndividuMontre (
    var id : Int,
    var nom : String,
    var espece : EspeceMonstre,
    var Entraineur : Entraineur?,
    expInit : Double,) {

    var niveau : Int = 1
    var attaque : Int = espece.baseAttaque + (-2..2).random()
    var defense : Int = espece.baseDefense
    var vitesse : Int = espece.baseVitesse
    var attaqueSpe : Int = espece.baseAttaqueSpe
    var defenseSpe : Int = espece.baseDefenseSpe
    var pvMax : Int = espece.basePv
    var potentiel : Double = (5..20).random() / 10.0
    var exp : Double = 0.0
    /**
     *  @property pv  Points de vie actuels.
     * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
     */
    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field = when {
                nouveauPv < 0 -> 0
                nouveauPv > pvMax -> pvMax
                else -> nouveauPv
            }
        }
    var exp: Double = 0.0
        get() = field
        set(value) {
            field = value

            while (field >= palierExp(niveau)) {
                levelUp()
                // On vérifie le niveau actuel juste après le levelUp
                if (niveau > 2) {
                    // Ou if (niveau != 2) selon si le niveau d'origine était 1
                    println("Le monstre $nom est maintenant niveau $niveau ")
                }
            }
        }


    init {
        exp = expInit
    }

    fun palierExp(niveau: Int): Double {
        return 100.0 * Math.pow((niveau - 1).toDouble(), 2.0)
    }

    fun levelUp() {
        niveau++
        attaque += (Math.round(espece.modAttaque * potentiel) + (-2..2).random()).toInt()
        defense += (Math.round(espece.modDefense * potentiel) + (-2..2).random()).toInt()
        vitesse += (Math.round(espece.modVitesse * potentiel) + (-2..2).random()).toInt()
        attaqueSpe += (Math.round(espece.modAttaqueSpe * potentiel) + (-2..2).random()).toInt()
        defenseSpe += (Math.round(espece.modDefenseSpe * potentiel) + (-2..2).random()).toInt()
        val gainPvMax = (Math.round(espece.modPv * potentiel) + (-5..5).random()).toInt()
        pvMax += gainPvMax
        pv += gainPvMax
    }

    fun attaquer(cible: IndividuMonstre) {
        val attaqueBrut = this.attaque
        var degatTotal = attaqueBrut - (cible.defense / 2)

        if (degatTotal < 1) {
            degatTotal = 1
        }

        val pvAvant = cible.pv
        cible.pv -= degatTotal
        val pvApres = cible.pv

        println("${this.nom} attaque ${cible.nom} et lui inflige ${pvAvant - pvApres} dégâts !")
    }

    fun renommer() {
        println("Renommer $nom ?")
        val nouveauNom = readln()
        if (nouveauNom.isNotBlank()) {
            this.nom = nouveauNom
        }
    }


    fun afficheDetail() {
        println(espece.afficheArt())
        println("==============================")
        println("Nom: $nom   Niveau: $niveau")
        println("Exp: $exp")
        println("PV: $pv / $pvMax")
        println("==============================")
        println("Atq : $attaque   Def : $defense   Vitesse : $vitesse")
        println("AtqSpe : $attaqueSpe   DefSpe : $defenseSpe")
        println("==============================")
    }





}