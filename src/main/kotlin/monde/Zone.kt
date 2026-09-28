package monde

import monstre.EspeceMonstre.EspeceMonstre

class Zone (

    var id : Int,
    var nom : String,
    var expZone : Int,
    var especesMonstres : MutableList<EspeceMonstre>,
    var zoneSuivante : Zone?,
    var zonePrecedente : Zone?,


    ){
}