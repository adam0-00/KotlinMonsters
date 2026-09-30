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


    init {
        exp = expInit
    }



}