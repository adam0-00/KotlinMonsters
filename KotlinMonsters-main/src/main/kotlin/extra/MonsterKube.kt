#!/usr/bin/env kotlin

class MonsterKube(
    id: Int,
    nom: String,
    description: String,
    var chanceCapture: Double
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        println("Vous lancez le Monster Kube !")

        // Si le monstre a déjà un entraîneur, la capture est impossible[cite: 23, 24]
        if (cible.entraineur != null) {
            println("Ce monstre appartient déjà à un dresseur !")
            return false
        }

        // Calcul avec prise en compte des PV actuels[cite: 23, 24]
        val ratioVie = cible.pv.toDouble() / cible.pvMax.toDouble()
        var chanceEffective = chanceCapture * (1.5 - ratioVie)
        chanceEffective = chanceEffective.coerceAtLeast(5.0)

        val tirage = (0..100).random()
        return if (tirage <= chanceEffective) {
            println("Le monstre est capturé !")
            true
        } else {
            println("Presque ! Le Kube n'a pas pu capturer le monstre !")
            false
        }
    }
}