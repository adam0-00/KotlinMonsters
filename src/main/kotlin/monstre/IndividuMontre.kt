package monstre

import dresseur.Entraineur
import monstre.EspeceMonstre.EspeceMonstre

class IndividuMontre (
    var id : Int,
    var nom : String,
    var espece : EspeceMonstre,
    var Entraineur : Entraineur?,
}