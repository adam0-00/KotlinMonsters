#!/usr/bin/env kotlin

interface Utilisable {
    /**
     * Applique l'effet de l'objet ou de l'action sur le monstre cible.
     *
     * @param cible Le [IndividuMonstre] sur lequel l'objet est utilisé.
     * @return `true` si l'action a eu un effet, `false` sinon.
     */
    fun utiliser(cible: IndividuMonstre): Boolean
}